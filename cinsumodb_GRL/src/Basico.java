import java.util.List;

public class Basico extends  Atm {

    @Override
    public List<Object> cobrarRetiroSinTarjeta() {
        return List.of();
    }


    //imprime el contenido de la lista de cuentas
    public void imprimirCuentas() {
        for (CuentaDTO c : this.getObtenerCuentas()) {
            System.out.println(c);
        }
    }



}
