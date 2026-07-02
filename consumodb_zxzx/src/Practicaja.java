import java.util.List;

public class Practicaja extends Atm implements IOperacionesAvanzadas{


    @Override
    public List<Object> cobrarRetiroSinTarjeta() {
        return List.of();
    }

    @Override
    public Ticket depositar(double monto) {
        return null;
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
