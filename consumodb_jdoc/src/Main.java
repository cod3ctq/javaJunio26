import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        ClasePrueba cprueba = new ClasePrueba();
//        //ller-SELECT
//
//
////
////        List<Movimiento> movs = cprueba.leerMovs();
////
////
////
////        //IMPRIMIR LA LISTA
////        for (Movimiento ob:movs){
////            System.out.println(ob);
////        }
//
//
//          //cprueba.actualizarMovs(261,25,"DEPOSITO",LocalDate.now(),8000.00);
//
//        //ELINMINACION
//
//        cprueba.eliminarMovs(262);

        //bjetos de  la clase hija
        Basico cb = new Basico();
cb.setUbicacion("Avenida Guadalupe");
        cb.imprimirCuentas();
        cb.consultarSaldo("5578123412340004","4567");

        List<Object> tk1 = cb.retirar("5578123412340004","4567",10000);
        List<Object> tk2 = cb.retirar("5578123412340004","4567",10000);
        List<Object> tk3 = cb.retirar("5578123412340004","4567",10000);

        //imprimir los tickets
        System.out.println(tk1.get(0));
        System.out.println(tk1.get(0));
        System.out.println(tk1.get(0));

        System.out.println(tk1.get(1));
        cb.consultarSaldo("5578123412340004","4567");











    }
}