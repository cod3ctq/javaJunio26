import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        ClasePrueba cprueba =  new ClasePrueba();
//// LECTURA-> SELECT
////        List<Movimiento> movs = cprueba.leerMovs();
////        //imprimir lista
////        for (Movimiento ob:movs){
////            System.out.println(ob);
////        }
//
//
//        //ESCRITURA
//        //-> INSERT
//      //  cprueba.guardarMov(0,2,"RETIRO", LocalDate.now(),5000);
//    //ACTUALIZACION- UPDATE
//        //cprueba.actualizarMov(521,2,"RETIRO", LocalDate.now(),5001);
//
//
//        //ELIMINACION
//        cprueba.eliminarMovs(521);

Basico cb = new Basico();
//List<Cuenta> cuentas = cb.obtenerCuenta();//invoca al metodo que carga la lista de cuentas
//    for(Cuenta C : cuentas){
//        System.out.println(C);
//    }
cb.imprimirCuentas();
cb.consultarSaldo("557812341234004","4567");


List <Object> resultados = cb.retirar("557812341234004","4567",10000);
        System.out.println(resultados.get(0));
        System.out.println(resultados.get(0));
        System.out.println(resultados.get(0));

        System.out.println(resultados.get(1));
        cb.consultarSaldo("557812341234004","4567");
    }
}