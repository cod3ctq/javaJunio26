import java.util.List;

public class PractiCaja extends Atm implements IOperacioneAvanzadas{

    @Override
    public List<Object> cobrarRetiroSinTarjeta() {
        return List.of();// Lista vacia (valor por default)
    }

    @Override
    public Ticket depositar(double monto) {
        return null;// vacio (valor por default)
    }

    @Override
    public Ticket depositar(String dato, double monto) {
        return null;
    }

    @Override
    public Ticket pagarServicio(String convenio, String referencia) {
        return null;
    }

    @Override
    public Ticket pagarTarjeta(String numTarjeta, double monto) {
        return null;
    }
}
