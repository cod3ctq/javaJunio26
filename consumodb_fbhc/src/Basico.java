import java.util.List;
import java.util.Objects;

public class Basico extends Atm{


    @Override
    public List<Objects> cobrarRetiroSinTarjeta() {
        return List.of();

    }

    //Imprime el contenido de la lista de cuentas
    public void imprimirCuentas(){
        // acceder a la lista heredada  a traves del guetter
        // la cual ya esta cargada en este epunto


        for(CuentaDTO c:this.getDbcuentas()){
            System.out.println(c);
        }

    }

}
