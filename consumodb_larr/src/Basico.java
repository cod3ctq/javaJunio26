import java.util.List;

public class Basico extends Atm{

    @Override
    public List<Object> cobrarRetiroSinTarjeta() {
        return List.of();
    }

    // Imprime el contenido de la lista cuentas
    public void imprimirCuentas(){

        // Accede a la lista heredada a traves de getter la cual ya está cargada en este punto
        for(CuentaDTO c : this.getDbcuentas()){
            System.out.println(c);
        }
    }
}
