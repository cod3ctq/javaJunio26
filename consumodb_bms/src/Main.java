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
//        Lectura
//        List<Movimiento> movs = cprueba.leerMovs();
//        imprime la lista
//        for(Movimiento ob:movs){
//            System.out.println(ob);
//        }
//         Escritura - INSERT
//        cprueba.guardarMov(0,25,"RETIRO", LocalDate.now(),5000);
//        Actualizacion - update
//        cprueba.actualizarMov(261,25,"DEPOSITO",LocalDate.now(),8000.00);
//        Eliminacion - DELETE
//        cprueba.eliminarMovs(261);

        //Instance object cb
        Basico cb = new Basico();
        cb.setUbicacion("Avenida Guadalupe Blass #333");
//        cb.imprimirCuentas();
        cb.consultarSaldo("5578123412340004","4566");
        System.out.println("-----------------------------------------------------------------------");
        List<Object> tk1 = cb.retirar("5578123412340004","4567",1000);
//        List<Object> tk2 = cb.retirar("5578123412340004","4567",1000);
//        List<Object> tk3 = cb.retirar("5578123412340004","4567",1000);
        System.out.println(tk1.get(0));
//        System.out.println(tk2.get(0));
//        System.out.println(tk3.get(0));

        System.out.println(tk1.get(1));
        cb.consultarSaldo("5578123412340004","4567");
        System.out.println("-----------------------------------------------------------------------");
    }
}