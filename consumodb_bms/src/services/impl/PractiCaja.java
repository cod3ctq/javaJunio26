package services.impl;

import constance.Mensajes;
import dao.CuentaDAO;
import dao.MovimientosDAO;
import dao.ServicioDAO;
import dto.CuentaDTO;
import dto.ReciboDTO;
import entity.Movimiento;
import exception.AlreadyCollectedException;
import exception.BusinessException;
import exception.InvalidReferenceException;
import exception.InvalidSecurityKeyException;
import models.Atm;
import models.Ticket;
import services.IOperacioneAvanzadas;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PractiCaja extends Atm implements IOperacioneAvanzadas {


    //cache de los servicios
    private Map<String, List<ReciboDTO>> servicios;

    //Inyeccion de dependencias (F1) : atributos
    private final MovimientosDAO movDAO = new MovimientosDAO();
    private final CuentaDAO cuentaDAO = new CuentaDAO();
    private final ServicioDAO servicioDAO = new ServicioDAO();

    public PractiCaja(){
        Atm.dbcuentas = Atm.getDbcuentas();
        servicios = servicioDAO.obtenerCachesServicios();
    }

    @Override
    public List<Object> cobrarRetiroSinTarjeta() {
        //Capturar solo la referencia, validarla
        Scanner sc = new Scanner(System.in);
        String referencia ="";
        String clave="";
        System.out.println("Captura la referencia -16 digitos");
        referencia = sc.nextLine();

        System.out.println("Ingresa la clave de seguridad - 4 digitos");
        clave = sc.nextLine();
        Ticket ticket = null;
        List<Object> respuesta = new ArrayList<Object>();

        if(referencia.length()!=16){//Valida longitud de referencia
//            System.out.println("Referencia Invalida");
            throw new InvalidReferenceException(Mensajes.INVALID_REFERENCE);
        } else if (Atm.getRetirosCobrados().contains(referencia)) {//validar si la fue cobrado
//            System.out.println("Esta referencia ya fue cobrada");
            throw new AlreadyCollectedException(Mensajes.ALREADY_PAIDED);
        } else{ //si no, entonces buscamos a los
            String numCuenta = "";
            double monto = 0.0;
            String llave = "";//almacena toda la llave 100001:1234567:1234
            //entonces buscamos el retiro dentro del cache
            for(String key : Atm.getCacheRetirosST().keySet()){
                if (key.split(":")[1].equals(referencia)) {
                    numCuenta = key.split(":")[0];
                    monto = Atm.getCacheRetirosST().get(key);
                    llave = key;
                    break;
                }
            }

            if(!(llave.split(":")[2]).equals(clave)){
                System.out.println("Clave de seguridad invalida");
                throw new InvalidSecurityKeyException(Mensajes.INVALID_REFERENCE);
            } else {
                //marcar como cobrado este retir(agregar al set)
                Atm.getRetirosCobrados().add(referencia);
                CuentaDTO dto = Atm.buscarCuenta(numCuenta);
                cuentaDAO.actualizarSaldo(numCuenta, dto.getSaldo() - monto);
                movDAO.registrarMovimiento(new Movimiento(0, dto.getCuentaId(), "RETIRO", Date.valueOf(LocalDate.now()), monto));
                //instancia el objeto ticket
                ticket = new Ticket(this.getUbicacion(), LocalDate.now(), numCuenta, "RETIRO", monto, "RT" + (Atm.folioOperacion++));
                //construye lista de salida
                respuesta.add(ticket);
                respuesta.add(monto);
            }
        }
        return respuesta;// Lista vacia (valor por default)
    }

    //propagacion de excepciones: throw y throws
    @Override
    public Ticket depositar(CuentaDTO cuenta, double monto) throws BusinessException {
        Ticket ti = null;

        if (monto>cuenta.getSaldoMax()) { //validar que el monto por si solo no se pase del maximo de la cuenta
            throw new BusinessException("Monto es mayor al maximo permitido de la cuenta");
            //System.out.println("Monto es mayor al maximo permitido de la cuenta");
        } else if ((cuenta.getSaldo() + monto) > cuenta.getSaldoMax()) { //validar que el (saldo actual + monto) > ...
            throw new BusinessException("Deposito no permitido. Tope de saldo alcanzado");
            //System.out.println("Deposito no permitido. Tope de saldo alcanzado");
        } else {
            //determinar el indice donde estaba la cuenta original en la lista
            int index = Atm.getDbcuentas().indexOf(cuenta);
            //abonar el saldo a la cuenta
            cuenta.setSaldo(cuenta.getSaldo()+monto);
            //actualizar el saldo de la cuenta (que esta en la lista)
            Atm.getDbcuentas().set(index, cuenta);
            //registrar movimientos
            movDAO.registrarMovimiento(new Movimiento(0, cuenta.getCuentaId(),"DEPOSITO", Date.valueOf(LocalDate.now()),monto));
            //actualizar el
            cuentaDAO.actualizarSaldo(cuenta.getNumCuenta(), cuenta.getSaldo());
            //construye el ticket
            ti = new Ticket(this.getUbicacion(),LocalDate.now(),cuenta.getNumCuenta(),"DEPOSITO",monto,"DP"+(Atm.folioOperacion++));
        }

        return ti;
    }

    @Override
    public Ticket pagarServicio(CuentaDTO cuenta, String convenio, String referencia) {
        ReciboDTO reciboDTO = buscarRecibo(convenio, referencia);
        System.out.println(">>>>>>>>>>>"+reciboDTO);
        Ticket ticket = null;

        if(reciboDTO != null){ //si existe el recibo
            //calcular el indice donde estabs el recibo original dentro de la lista
            int index = servicios.get(convenio).indexOf(reciboDTO);

            //actualizar el saldo en la cuenta (dentro de la lista)
            cuenta.setSaldo(cuenta.getSaldo()-reciboDTO.getMonto());
            Atm.getDbcuentas().set(Atm.getDbcuentas().indexOf(cuenta), cuenta);
            //pagar recibo
            reciboDTO.setStatus('1');
            //reintegrar el recibo(pagado) de donde lo tome (dentro de la lista del mapa)
            servicios.get(convenio).set(index,reciboDTO);
            //cambiar el status del recibo dentro de la base
            servicioDAO.actualizarStatusRecibo(referencia);
            //descontar el dinero del saldo de la cuenta (el cual abtienes del reciboDTO
            cuentaDAO.actualizarSaldo(cuenta.getNumCuenta(),cuenta.getSaldo()-reciboDTO.getMonto());
            //registrarmovimiento
            movDAO.registrarMovimiento(new Movimiento(0,cuenta.getCuentaId(),"PAGO SERVICIOS",Date.valueOf(LocalDate.now()),reciboDTO.getMonto()));

            ticket = new Ticket(this.getUbicacion(), LocalDate.now(),cuenta.getNumCuenta(), "PAGO SERVICIO", reciboDTO.getMonto(),"PS"+(Atm.folioOperacion++));
            return ticket;

        } else { //si no, lanzar excepcion
            throw new BusinessException(Mensajes.RECEPT_ALREADY_PAID);
        }
    }

    @Override
    public Ticket pagarTarjeta(String numTarjeta, double monto) {
        return null;
    }

    //buscar al recibo por convenio y referencia, validando que este sin pagar
    public ReciboDTO buscarRecibo(String convenio, String referencia){
        ReciboDTO aux = null;
        ReciboDTO temp;
        for (String key:servicios.keySet()){ //Itera sobre las llaves de convenios
            for(int i=0; i<servicios.get(key).size();i++){ //Itera sobre las llaves (convenios)
                temp = servicios.get(key).get(i);
                if(key.equals(convenio) && temp.getReferencia().equals(referencia) && temp.getStatus() == '0'){
                    aux = servicios.get(key).get(i);
                    break;
                }
            }
        }
        return aux;
    }

    public void imprimirCacheServicios(){
        for(String key:servicios.keySet()){
            System.out.println("Servicio : "+key);

            //Por cada recibo dentro de la lista de recibos del servicio actual
            for(ReciboDTO dto : servicios.get(key)){
                System.out.println(dto);
            }
        }
    }
}
