package service.impl;

import constants.Mensajes;
import dao.CuentaDAO;
import dao.MovimientoDAO;
import dao.ServicioDAO;
import dto.CuentaDTO;
import dto.ReciboDTO;
import exception.AlredyCollectedException;
import exception.BussinessException;
import exception.InvalidReferenceEception;
import exception.InvalidSegurityException;
import models.Atm;
import models.Tiket;

import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

public class PractiCaja extends Atm implements IoperacionesAvanzadas {

//cache de los servicios

    private Map<String, List<ReciboDTO>> servicios;


    private final MovimientoDAO movDAO = new MovimientoDAO();
    private final CuentaDAO cuentaDAO = new CuentaDAO();
    private final ServicioDAO servicioDAO = new ServicioDAO();

    public PractiCaja() {
        dbcuentas = getDbcuentas();
        servicios = servicioDAO.obtenerCacheServicios();

    }


    @Override
    public List<Object> cobrarRetiroSinTarjeta() {
        Scanner scan = new Scanner(System.in);
        String referencia = "";
        Tiket tiket = null;
        String clave;
        String llave="";
        List<Object> respuesta = new ArrayList<Object>();
        System.out.println("Capturar la referencia - 16 digitos ");
        referencia = scan.nextLine();

        System.out.println("Ingrese la clave de seguridad de 4 digitos");
        clave = scan.nextLine();

        if (referencia.length() != 16) {
//            System.out.println("Referencia invalida");
            throw new InvalidReferenceEception(Mensajes.INVALID_REFERENCE);
        } else if (getRetirosCobrados().contains(referencia)) {//Validar  si ya fue cobrada
//            System.out.println("Esta referencia ya fue cobrada !");
            throw new AlredyCollectedException(Mensajes.ALREDY_PAIDED);
        } else {
            String numCuenta = "";
            double monto = 0.0;

            for (String key : getCaheRetirosST().keySet()) {
                if (key.split(":")[1].equals(referencia)) {
                    numCuenta = key.split(":")[0];
                    monto = getCaheRetirosST().get(key);
                    llave = key;
                    break;
                }

            }

            if (!(llave.split(":")[2].equals(clave))) {
//                System.out.println("Clave de seguridad invalida");
                throw new InvalidSegurityException("Clave de seguridad invalida");
            } else {


//Marcar como cobrado este retiro (agregar al set)
                getRetirosCobrados().add(referencia);
                //Adquirir los datos de la tarjeta de donde se obtendran los datos
                CuentaDTO dto = buscarCuenta(numCuenta);
                //Descuenta el dinero de la cuenta
                cuentaDAO.actualizarSaldo(numCuenta, dto.getSaldo() - monto);
                movDAO.registrarMovimiento(new Movimientos(0, dto.getCuentaId(),
                        "RETIRO", Date.valueOf(LocalDate.now()), monto));
                //instancia el objeto tiket
                tiket = new Tiket(this.getUbicacion(), LocalDate.now(), numCuenta, "RETIRO", monto, "RT" + (folioOperacion++));
                //Construye la lista de salida
                respuesta.add(tiket);
                respuesta.add(monto);
            }
        }
        return respuesta;


    }


    @Override
    public Tiket depositar(CuentaDTO cuenta, double monto) throws BussinessException {

        // validar cantidad de deposito al dia, dependiendo del tipo de cuenta


        Tiket t1 = null;
        if (monto > cuenta.getSaldoMax()) {  // validar que el monto por si solo no se pase del monto maximo de la cuenta
            throw new BussinessException(Mensajes.HIGHEST_AMOUNT_LIMIT);
            //System.out.println("Monto es mayor al maximo permitido de la cuenta");
        } else if ((cuenta.getSaldo() + monto) > cuenta.getSaldoMax()) { // Validar que el (saldo actual + monto) > saldo max
            throw new BussinessException(Mensajes.OVER_MAXIMUM_LIMIT);
            //System.out.println("Deposito no permitido tope de saldo maximo alcanzado");
        } else {

            //Determinar el indice donde estaba la cuenta original en la lista
            int index = getDbcuentas().indexOf(cuenta);
            // abonar el saldo a la cuenta
            cuenta.setSaldo(cuenta.getSaldo() + monto);
            //actualizar el saldo de la cuenta (que esta en la lista)
            getDbcuentas().set(index, cuenta);
            //registrar movimiento ( en db)
            movDAO.registrarMovimiento(new Movimientos(0, cuenta.getCuentaId(), "DEPOSITO",
                    Date.valueOf(LocalDate.now()), monto));
            //actualizar el saldo en (db)
            cuentaDAO.actualizarSaldo(cuenta.getNumCuenta(), cuenta.getSaldo());
            //Construye el tiket
            t1 = new Tiket(this.getUbicacion(), LocalDate.now(), cuenta.getNumCuenta(),
                    "DEPOSITO", monto, "DP" + (folioOperacion++));


        }


        return t1;
    }

    @Override
    public Tiket pagarservisio(CuentaDTO cuenta, String convenio, String referencia) {
        ReciboDTO reciboDTO = buscarRecibo(convenio, referencia);

        Tiket ticket=null;

        ReciboDTO dto = buscarRecibo(convenio , referencia);
        if(dto!=null){//si existe el recibo

            //Calcular el indice donde staba el recibo original dentro de la lista
           int index = servicios.get(convenio).indexOf(dto);

//actualizar el saldo en la cuenta (dentro de la lista)
            cuenta.setSaldo(cuenta.getSaldo()-reciboDTO.getMonto());
            getDbcuentas().set(getDbcuentas().indexOf(cuenta), cuenta);




            //pagarlo
            dto.setStatus('1');

            servicios.get(convenio).set(index, dto);
            //cambiar el estatus del recibo dentro de la base
            //desconectar el dinero del saldo de la cuenta
            servicioDAO.actualizarStatusRecibo(referencia);


            cuentaDAO.actualizarSaldo(cuenta.getNumCuenta(), cuenta.getSaldo()-reciboDTO.getStatus());

            movDAO.registrarMovimiento(new Movimientos(0, cuenta.getCuentaId(),
            "PAGO SERVICIOS",Date.valueOf(LocalDate.now()),reciboDTO.getMonto()));


            ticket = new Tiket(this.getUbicacion(), LocalDate.now(), cuenta.getNumCuenta(),
                    "PAGO SERVICIOS", reciboDTO.getMonto(),"PS"+(folioOperacion++));
            return ticket;

        }else{// si no lanza la excepcion

            throw  new BussinessException("La referencia no existe o ya fue pagada");

        }
    }

    @Override
    public Tiket pagarTarjeta(String miTarjeta, double monto) {
        return null;
    }


    // Buscar el recibo por convenio y referencia validadndo que este sin pagar


    public ReciboDTO buscarRecibo(String convenio, String referencia) {

        ReciboDTO aux = null;
        for (String key : servicios.keySet()) {
            for (int i = 0; i < servicios.get(key).size(); i++) {
                aux = servicios.get(key).get(i);

                if(key.equals(convenio) && aux.getReferencia().equals(referencia) && aux.getStatus()=='0'){
                    aux = servicios.get(key).get(i);
                    break;
                }else {

                    aux = null;

                }


            }
        }

return  aux;
    }


    public void imprimirCacheCacheServicios(){

        for(String key:servicios.keySet()){
            System.out.println("Servicio :"+key);
            //Por cada recibo dentro de la lista de recibos del servicio actual
            for(ReciboDTO dto:servicios.get(key)){
                System.out.println(dto);
            }
        }
    }
}



