import java.util.List;
import java.util.Objects;

public class Basico extends ATM{
    @Override
    public List<Object> cicobrarRetirosSinTarjeta() {
        return List.of();
    }

    //imprime el contenido de la lista de cuentas
    public void imprimirCuentas(){
        //accede a la lista heredada a traves del getter
        //la cual ya esta cargada en este punto
        for(CuentaDTO c: this.getDbcuentas()){
            System.out.println(c);
        }

    }
}
