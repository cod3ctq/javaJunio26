import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Basico extends Atm implements IOperacionesBasicas{


    //Inyeccion de dependencias (F1) : atributo
    private final MovimientoDAO movDAO = new MovimientoDAO();
    private final CuentaDAO cuentaDAO = new CuentaDAO();


    @Override
    public List<Object> cobrarRetiroSinTarjeta() {
        return List.of();
    }


    // propagacion de excepciones : throw y throws
    // throw : crea la excepcion en el punto necesario del flujo, se coloca dentro del metodo
    // throws : propaga la excepcion, se coloca en la firma o definicion del metodo
    @Override    //momento 1
    public List<Object> retirar(String numTarjeta, String nip, double monto)
            throws AccountNotFoundException,WrongNipException, InsufficentBalanceException,UnderMinimunLimitException {
        //Validar limite de monto ($$$) de retiro diario *****
        //Validar la cantidad (solo multiplos de 100)
        CuentaDTO cuenta = buscarCuenta(numTarjeta);
        Ticket ti = null;
        List<Object> data = new ArrayList<>();
        //si la no cuenta existe
        if(cuenta==null){
            throw new AccountNotFoundException("No fue posible hacer el retiro, no existe la cuenta");
            //System.out.println("No fue posible hacer el retiro, no existe la cuenta.");
            //si nip no es valido
        }else if( !(cuenta.getNip().equals(nip))){
            throw new WrongNipException("No fue posible hacer el retiro, NIP ingresado invalido");
            //System.out.println("No fue posible hacer el retiro, NIP ingresado invalido");
            //Aqui asumo que la cuenta existe y ademas el nip es valido
        }else if(monto > cuenta.getSaldo()){
            //validar que monto a retirar sea menor al saldo disponible
            throw new InsufficentBalanceException("Saldo insuficiente");
            //System.out.println("Saldo insuficiente");
        }else if( (cuenta.getSaldo() - monto) < cuenta.getSaldoMin()){
            //validar que (saldo disponible - monto) > saldo minimo de la cuenta
            throw new UnderMinimunLimitException("Retiro no disponible, limite inferior alcanzado");
            //System.out.println("Retiro no disponible, limite inferior alcanzado");
        }else{
            //calcular el indice de donde tome el objeto original
            int index = getDbcuentas().indexOf(cuenta);
            //retirar (descontar el monto)
            cuenta.setSaldo(cuenta.getSaldo() - monto);
            //actualizar el saldo de la cuenta (la que esta en la lista, reemplazando al objeto)
            getDbcuentas().set(index, cuenta);
            //invoca al metodo que registra el movimiento (en la base de datos)
            movDAO.registrarMovimiento(new Movimiento(0, cuenta.getCuentaId(),
                    "RETIRO", Date.valueOf(LocalDate.now()),monto));
            //invocar al metodo que actualiza los saldos de las cuentas (en la base de datos)
            cuentaDAO.actualizarSaldo(cuenta.getNumCuenta(), cuenta.getSaldo());
            //generar el ticket
            ti = new Ticket(this.getUbicacion(), LocalDate.now(),
                    cuenta.getNumCuenta(),"RETIRO",monto, "RT"+ (folioOperacion++));
            //añade los elementos resultantes a la lista de salida
            data.add(ti);
            data.add(monto);
        }
        //retornar resultados
        return data;
    }









}
