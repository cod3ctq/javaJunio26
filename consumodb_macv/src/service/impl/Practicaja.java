package service.impl;

import constants.Mensajes;
import dao.CuentaDAO;
import dao.MovimientoDAO;
import dao.ServicioDAO;
import dto.CuentaDTO;
import dto.ReciboDTO;
import entity.Movimiento;
import exception.AlreadyPaidedException;
import exception.BusinessException;
import exception.InvalidReferenceException;
import exception.InvalidSecurityKeyException;
import models.ATM;
import models.Ticket;
import service.IOperacionesAvanzadas;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Practicaja extends ATM implements IOperacionesAvanzadas {

    //Cache de los servicios
    private Map<String, List<ReciboDTO>> servicios;


    private final MovimientoDAO movDAO = new MovimientoDAO();
    private final CuentaDAO cuentaDAO = new CuentaDAO();
    private final ServicioDAO servicioDAO = new ServicioDAO();

    public Practicaja() {
        dbcuentas = getDbcuentas();
        servicios = servicioDAO.obtenerCacheServicios();
    }

    @Override
    public List<Object> cicobrarRetirosSinTarjeta() {
        //Capturar solo la referencia y validarla
        Scanner sc = new Scanner(System.in);
        String referencia = "";
        String clave = "";
        Ticket ticket = null;
        List<Object>respuesta = new ArrayList<Object>();

        System.out.println("Captura la referencia - 16 Digitos");
        referencia = sc.nextLine();
        System.out.println("Ingrese la clave de seguridad - 4 Digitos");
        clave = sc.nextLine();

        if(referencia.length()!=16){
            throw new InvalidReferenceException(Mensajes.INVALID_REFERENCE);
        }else if(getRetirosCobrados().contains(referencia)){
            throw new AlreadyPaidedException(Mensajes.ALREADY_PAIDED);
        }else {
            String numCuenta="";
            double monto=0.0;
            String llave=""; //almacena toda la llave
            //entonces buscamos el retiro dentro del cache
            for(String key : getCacheRetirosST().keySet()){
                if(key.split(":")[1].equals(referencia)){
                    numCuenta = key.split(":")[0];
                    monto = getCacheRetirosST().get(key);
                    llave = key;
                    break;
                }
            }
            if(!(llave.split(":")[2].equals(clave))){
                throw new InvalidSecurityKeyException(Mensajes.INVALID_KEY);
            }else{
                //Marcar como cobrado el recibo
                getRetirosCobrados().add(referencia);
                //Adquiere los datos de la cuenta donde se tomara el dinero
                CuentaDTO dto = buscarCuenta(numCuenta);
                //descuenta el dinero de la cuenta
                cuentaDAO.actualizarSaldo(numCuenta,dto.getSaldo()-monto);
                //registra el movimiento
                movDAO.registrarMovimiento(new Movimiento(0,dto.getCuentaId(),"RETIRO",
                        Date.valueOf(LocalDate.now()),monto));
                //Instancio el objeto ticket
                ticket = new Ticket(this.getUbicacion(), LocalDate.now(),numCuenta,"RETIRO",monto,
                        "RT"+(folioOperacion++));
                //construye lista de salida
                respuesta.add(ticket);
                respuesta.add(monto);
            }
        }
        return respuesta;
    }


    @Override
    public Ticket depositar(CuentaDTO cuenta, double monto) throws BusinessException {

        Ticket ti = null;

         if (monto > cuenta.getSalfomax()) { //validar que el monto (por si solo) no se pase del maximo de la cuenta
            throw new BusinessException(Mensajes.HIGHEST_AMOUNT_LIMIT);
            //System.out.println("Monto es mayor al maximo permitido de la cuenta");
        } else if ((cuenta.getSaldo() + monto) > cuenta.getSalfomax()) {
            throw new BusinessException(Mensajes.OVER_MAXIMUN_LIMIT);
            //System.out.println("Deposito no permitido. Tope de saldo maximo alcanzado");
        } else {

            //determinar el inidice donde estaba la cuenta original en la lista
            int index = getDbcuentas().indexOf(cuenta);

            //abonar el saldo a la cuenta
            cuenta.setSaldo(cuenta.getSaldo() + monto);

            //actualizar el salfo de la cuenta (que esta en la lista)
            this.getDbcuentas().set(index, cuenta);

            //registar movimiento (en db)
            movDAO.registrarMovimiento(new Movimiento(0, cuenta.getCuentaId(), "DEPOSITO",
                    Date.valueOf(LocalDate.now()), monto));

            //actualizar saldo en db
            cuentaDAO.actualizarSaldo(cuenta.getNumCuenta(), cuenta.getSaldo());

            //construir el ticket
            ti = new Ticket(this.getUbicacion(), LocalDate.now(), cuenta.getNumCuenta(),
                    "DEPOSITO", monto, "DP" + (folioOperacion++));
        }
        return ti;
    }

    @Override
    public Ticket pagarServicio(CuentaDTO cuenta, String convenio, String referencia) {
        ReciboDTO reciboDTO = buscarRecibo(convenio,referencia);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+reciboDTO);

        Ticket ticket = null;
        if (reciboDTO !=null){ //Si existe el recibo
            //calcular el indice donde estaba el recibo original dentro de la lista
            int index = servicios.get(convenio).indexOf(reciboDTO);
            //actualizar el saldo en la cuenta (dentro de la lista)
            cuenta.setSaldo(cuenta.getSaldo()-reciboDTO.getMonto());
            getDbcuentas().set(getDbcuentas().indexOf(cuenta), cuenta);
            //pagarlo
            reciboDTO.setStatus('1');
            //reintegrar el recibo(pagado) de donde lo tome (dentro de la ista del mapa)
            servicios.get(convenio).set(index,reciboDTO);
            //cambiar el status del recibo de la base
            servicioDAO.actualizarStatusRecibo(referencia);
            //descontar el dinero del saldo de la cuenta (el cual optienes del reciboDTO)
            cuentaDAO.actualizarSaldo(cuenta.getNumCuenta(), cuenta.getSaldo()- reciboDTO.getMonto());
            //Registrar el movimiento
            movDAO.registrarMovimiento(new Movimiento(0, cuenta.getCuentaId(), "PAGO SERVICIOS",
                    Date.valueOf(LocalDate.now()), reciboDTO.getMonto()));

            ticket = new Ticket(this.getUbicacion(),LocalDate.now(), cuenta.getNumCuenta(),"PAGO SERVICIOS",
                    reciboDTO.getMonto(), "PS"+(folioOperacion++));
            return ticket;
        }else {//si no existe la cuenta
            throw new BusinessException(Mensajes.RECEIPT_ALREADY_PIAD);

        }


    }
    @Override
    public Ticket pagarTarjeta(String numTarjeta, double monto) {
        return null;
    }

    //buscar el recibo por convenio y referencia validando que este sin pagar
    public ReciboDTO buscarRecibo(String convenio, String referencia) {
        ReciboDTO aux = null;
        ReciboDTO temp;
        for (String key : servicios.keySet()) {
            for (int i = 0; i < servicios.get(key).size(); i++) {
                temp = servicios.get(key).get(i);
                if (key.equals(convenio) && temp.getReferencia().equals(referencia) && temp.getStatus() == '0') {
                    aux = servicios.get(key).get(i);
                }

            }
        }
        return aux;
    }
    public void imprimirCacheCacheServicios(){
        for(String key:servicios.keySet()){
            System.out.println("Servicios"+key);
            for(ReciboDTO dto:servicios.get(key)){
                System.out.println(dto);
            }
        }
    }


}
