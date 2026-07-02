import java.util.List;
import java.util.Objects;

public class Practicaja extends ATM implements IOperacionesAvanzadas {


    @Override
    public List<Object> cicobrarRetirosSinTarjeta() {
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
