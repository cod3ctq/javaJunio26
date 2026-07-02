import java.util.List;

public class Basico extends Atm {

    @Override
    public List<Object> cobrarRetiroSinTarjeta() {
        return List.of();
    }
    //imprimir el contenido de la lista de cuentas
    public void imprimirCuentas() {
        //acceder a la lista heredada a traves de getters
        //la cual ya esta cargada
        for(CuentaDTO c: this.getDbcuentas()) {
            System.out.println(c);
        }
    }
}