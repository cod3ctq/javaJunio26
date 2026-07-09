package service.impl;
import constants.Mensajes;
import dao.MovimientoDAO;
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
import service.IOperacionesAvanzadas;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Practicaja extends Atm implements IOperacionesAvanzadas {

    //cache de los servicios
    private Map<String, List<ReciboDTO>> servicios;

    private final MovimientoDAO movDAO = new MovimientoDAO();
    private final ServicioDAO servicioDAO = new ServicioDAO();

    public Practicaja() {
        dbcuentas = getDbcuentas();
        servicios = servicioDAO.obtenerCacheServicios();
    }

    @Override
    public List<Object> cobrarRetiroSinTarjeta() {

        //Capturar solo la referencia, validarla
        Scanner scan = new Scanner(System.in);
        String referencia = "", clave="";
        Ticket ticket = null;
        List<Object> respuesta = new ArrayList<Object>();
        System.out.println("Captura la referencia - 16 digitos");
        referencia = scan.nextLine();
        System.out.println("Ingresa la clave de seguridad - 4 digitos");
        clave = scan.nextLine();

        if (referencia.length() != 16) { //Valida longitud de referencia
            //System.out.println("Referencia Invalida");
            throw new InvalidReferenceException(Mensajes.INVALID_REFERENCE);
        } else if (getRetirosCobrados().contains(referencia)) { //validar si ya fue cobrada ....
            //System.out.println("Esta referencia ya fue cobrada !");
            throw new AlreadyCollectedException(Mensajes.ALREADY_PAIDED);
        } else { //sino
            String numCuenta = "";
            double monto = 0.0;
            String llave = ""; //almacena toda la llave, ejemplo 100001:234235234536456456:3436
            //entonces buscamos el retiro dentro del caché
            for (String key : getCacheRetirosST().keySet()) {
                if (key.split(":")[1].equals(referencia)) {
                    numCuenta = key.split(":")[0];
                    monto = getCacheRetirosST().get(key);
                    llave = key;
                    break;
                }
            }
            if (!(llave.split(":")[2].equals(clave))) {
                //System.out.println("Clave de seguridad invalida");
                throw new InvalidSecurityKeyException(Mensajes.INVALID_KEY);
            } else {
                //marcar como cobrado este retiro (agregar al set)
                getRetirosCobrados().add(referencia);
                //Adquiere los datos de la cuenta de donde se tomara el dinero
                CuentaDTO dto = buscarCuenta(numCuenta);
                //descuenta el dinero de la cuenta
                cuentaDAO.actualizarSaldo(numCuenta, dto.getSaldo() - monto);
                //registra el movimiento
                movDAO.registrarMovimiento(new Movimiento(0, dto.getCuentaId(),
                        "RETIRO", Date.valueOf(LocalDate.now()), monto));
                //instancio el objeto ticket
                ticket = new Ticket(this.getUbicacion(), LocalDate.now(), numCuenta, "RETIRO", monto,
                        "RT" + (folioOperacion++));
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

        //Validar cantidad de depositos al dia, dependiendo del tipo de cuenta
        //Validar la cantidad ($$) mensual
        if (monto > cuenta.getSaldoMax()) { // validar que el monto (por si solo) no se pase del maximo de la cuenta
            throw new BusinessException(Mensajes.HIGHEST_AMOUNT_LIMIT);
            //System.out.println("Monto es mayor al maximo permitido de la cuenta");
        } else if ((cuenta.getSaldo() + monto) > cuenta.getSaldoMax()) { //validar que el (saldo actual + monto) > saldo max
            throw new BusinessException(Mensajes.OVER_MAXIMUM_LIMIT);
            //System.out.println("Deposito no permitido. Tope de saldo maximo alcanzado");
        } else {
            //determinar el indice donde estaba la cuenta original en la lista
            int index = getDbcuentas().indexOf(cuenta);
            //abonar el saldo a la cuenta
            cuenta.setSaldo(cuenta.getSaldo() + monto);
            //actualizar el saldo de la cuenta (que esta en la lista)
            getDbcuentas().set(index, cuenta);
            //registrar movimiento (en db)
            movDAO.registrarMovimiento(new Movimiento(0, cuenta.getCuentaId(), "DEPOSITO",
                    Date.valueOf(LocalDate.now()), monto));
            //actualizar el saldo (en db)
            cuentaDAO.actualizarSaldo(cuenta.getNumCuenta(), cuenta.getSaldo());
            //contruye el ticket
            ti = new Ticket(this.getUbicacion(), LocalDate.now(), cuenta.getNumCuenta(),
                    "DEPOSITO", monto, "DP" + (folioOperacion++));
        }
        return ti;
    }

    @Override
    public Ticket pagarServicio(CuentaDTO cuenta, String convenio, String referencia) {
        ReciboDTO reciboDTO = buscarRecibo(convenio, referencia);
        System.out.println(">>>>>>>>>>>>> " + reciboDTO);
        Ticket ticket = null;
        if (reciboDTO != null) { //si existe el recibo
            //calcular el indice donde estaba el recibo original dentro de la lista
            int index = servicios.get(convenio).indexOf(reciboDTO);
            //actualizar el saldo en la cuenta (dentro de la lista)
            cuenta.setSaldo(cuenta.getSaldo() - reciboDTO.getMonto());
            getDbcuentas().set(getDbcuentas().indexOf(cuenta), cuenta);
            //pagarlo
            reciboDTO.setStatus('1');
            //reintegrar el recibo(pagado) de donde lo tome (dentro de la lista del mapa)
            servicios.get(convenio).set(index, reciboDTO);
            //cambiar el status del recibo dentro de la base
            servicioDAO.actualizarStatusRecibo(referencia);
            //descontar el dinero del saldo de la cuenta(el cual obtienes del reciboDTO)
            cuentaDAO.actualizarSaldo(cuenta.getNumCuenta(), cuenta.getSaldo() - reciboDTO.getMonto());
            //registrar el movimiento
            movDAO.registrarMovimiento(new Movimiento(0, cuenta.getCuentaId(),
                    "PAGO SERVICIOS", Date.valueOf(LocalDate.now()), reciboDTO.getMonto()));
            ticket = new Ticket(this.getUbicacion(), LocalDate.now(), cuenta.getNumCuenta(),
                    "PAGO SERVICIOS", reciboDTO.getMonto(), "PS" + (folioOperacion++));
            return ticket;
        } else { // si no, lanzar excepcion
            throw new BusinessException(Mensajes.RECEIPT_ALREADY_PAID);
        }

    }

    @Override
    public Ticket pagarTarjeta(String numTarjeta, double monto) {
        return null;
    }

    //buscar al recibo por convenio y referencia, validando que este sin pagar
    public ReciboDTO buscarRecibo(String convenio, String referencia) {
        ReciboDTO aux = null;
        ReciboDTO temp;
        for (String key : servicios.keySet()) { //Itera sobre las llaves (convenios)
            for (int i = 0; i < servicios.get(key).size(); i++) { //Itera sobre los recibos de cada lista
                temp = servicios.get(key).get(i);
                if (key.equals(convenio) && temp.getReferencia().equals(referencia) && temp.getStatus() == '0') {
                    aux = servicios.get(key).get(i);
                    break;
                }
            }
        }
        return aux;
    }

    public void imprimirCacheCacheServicios() {
        for (String key : servicios.keySet()) {
            System.out.println("Servicio :" + key);
            //Por cada recibo dentro de la lista de recibos del servicio actual
            for (ReciboDTO dto : servicios.get(key)) {
                System.out.println(dto);
            }
        }
    }


}
