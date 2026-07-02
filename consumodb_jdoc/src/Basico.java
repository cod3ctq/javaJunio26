import java.util.List;

public class Basico extends Atm {


    @Override
    public List<Object> cobrarRetiroSinTarjeta() {
        return List.of();

    }


    //Imprime el contenido de la lista de cuentas
    public void imprimirCuentas(){
        //Accede a la lista heredada a travez del getter
        //la cual ya esta cargada en este punto
        for (CuentaDTO c:this.getDbcuentas()){
            System.out.println(c);
        }
    }
}
