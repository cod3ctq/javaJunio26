import java.util.List;

public class Basico extends  Atm{

    @Override
    public List<Object> cobrarRetiroSinTarjeta(){
        return List.of();
    }

//imprime el contenido de la lista de cuentas

    public void  imprimirCuentas(){

        //accede aa lista heredada a traves del getter
        //la cual ya esta cargada en este punto
        for (cuentaDTO c: this.getDbcuentas()){
            System.out.println(c);
        }
    }




}
