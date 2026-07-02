import java.util.List;
import java.util.Objects;

public class PractiCaja extends Atm implements IoperacionesAvanzadas {
    @Override
    public List<Objects> cobrarRetiroSinTarjeta() {
        return List.of();
    }

    @Override
    public Tiket depositar(double monto) {
        return null;
    }

    @Override
    public Tiket depositar(String dato, double monto) {
        return null;
    }

    @Override
    public Tiket pagarservisio(String convenio, String referencia) {
        return null;
    }

    @Override
    public Tiket pagarTarjeta(String miTarjeta, double monto) {
        return null;
    }
}
