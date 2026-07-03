import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Practicaja extends Atm implements IOperacionesAvanzadas{

    //cache de los servicios
    private Map<String, List<ReciboDTO>> servicios;

    private final MovimientoDAO movDAO = new MovimientoDAO();
    private final CuentaDAO cuentaDAO = new CuentaDAO();
    private final ServicioDAO servicioDAO = new ServicioDAO();

    public Practicaja(){
        dbcuentas = getDbcuentas();
        servicios = servicioDAO.obtenerCacheServicios();
    }

    @Override
    public List<Object> cobrarRetiroSinTarjeta() {
        return List.of();
    }


    @Override
    public Ticket depositar(String dato, double monto) throws BusinessException{

        CuentaDTO cuenta = buscarCuenta(dato);
        Ticket ti = null;

        //Validar cantidad de depositos al dia, dependiendo del tipo de cuenta
        //Validar la cantidad ($$) mensual
        if(cuenta==null){
            throw new BusinessException("Deposito no fue posible, no existe la cuenta");
            //System.out.println("Deposito no fue posible, no existe la cuenta");
        }else if(monto>cuenta.getSaldoMax()){ // validar que el monto (por si solo) no se pase del maximo de la cuenta
            throw new BusinessException("Monto es mayor al maximo permitido de la cuenta");
            //System.out.println("Monto es mayor al maximo permitido de la cuenta");
        }else if((cuenta.getSaldo() + monto )>cuenta.getSaldoMax()){ //validar que el (saldo actual + monto) > saldo max
            throw new BusinessException("Deposito no permitido. Tope de saldo maximo alcanzado");
            //System.out.println("Deposito no permitido. Tope de saldo maximo alcanzado");
        }else{
            //determinar el indice donde estaba la cuenta original en la lista
            int index  = getDbcuentas().indexOf(cuenta);
            //abonar el saldo a la cuenta
            cuenta.setSaldo(cuenta.getSaldo() + monto);
            //actualizar el saldo de la cuenta (que esta en la lista)
            getDbcuentas().set(index, cuenta);
            //registrar movimiento (en db)
            movDAO.registrarMovimiento(new Movimiento(0,cuenta.getCuentaId(),"DEPOSITO",
                    Date.valueOf(LocalDate.now()),monto));
            //actualizar el saldo (en db)
            cuentaDAO.actualizarSaldo(cuenta.getNumCuenta(), cuenta.getSaldo());
            //contruye el ticket
            ti = new Ticket(this.getUbicacion(),LocalDate.now(),cuenta.getNumCuenta(),
                    "DEPOSITO",monto,"DP"+(folioOperacion++));
        }
        return ti;
    }

    @Override
    public Ticket pagarServicio(String dato,String convenio, String referencia) {
        ReciboDTO reciboDTO = buscarRecibo(convenio, referencia);
        System.out.println(">>>>>>>>>>>>> "+reciboDTO);
        CuentaDTO cuentaDTO = null;
        Ticket ticket = null;
        if(reciboDTO!=null) { //si existe el recibo
            //calcular el indice donde estaba el recibo original dentro de la lista
            int index = servicios.get(convenio).indexOf(reciboDTO);
            //pagarlo
            reciboDTO.setStatus('1');
            //reintegrar el recibo(pagado) de donde lo tome (dentro de la lista del mapa)
            servicios.get(convenio).set(index, reciboDTO);
            //cambiar el status del recibo dentro de la base
            servicioDAO.actualizarStatusRecibo(referencia);
            //buscar a la cuenta para obtener su saldo actual
            cuentaDTO = buscarCuenta(dato);
            //descontar el dinero del saldo de la cuenta(el cual obtienes del reciboDTO)
            cuentaDAO.actualizarSaldo(cuentaDTO.getNumCuenta(), cuentaDTO.getSaldo()-reciboDTO.getMonto());
            //registrar el movimiento
            movDAO.registrarMovimiento(new Movimiento(0,cuentaDTO.getCuentaId(),
                    "PAGO SERVICIOS", Date.valueOf(LocalDate.now()), reciboDTO.getMonto()));
            ticket = new Ticket(this.getUbicacion(), LocalDate.now(), cuentaDTO.getNumCuenta(),
                    "PAGO SERVICIOS", reciboDTO.getMonto(),"PS"+(folioOperacion++));
            return ticket;
        }else{ // si no, lanzar excepcion
            throw new BusinessException("La referencia no existe o ya fue pagada");
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
        for(String key: servicios.keySet()){ //Itera sobre las llaves (convenios)
            for(int i=0; i<servicios.get(key).size(); i++){ //Itera sobre los recibos de cada lista
                temp = servicios.get(key).get(i);
                if(key.equals(convenio) && temp.getReferencia().equals(referencia) && temp.getStatus()=='0'){
                    aux = servicios.get(key).get(i);
                    break;
                }

            }
        }
        return aux;
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
