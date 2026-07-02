import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {


        ClasePrueba cprueba = new ClasePrueba();


//        // Lectura - SELECT
//        List<Movimientos> movs = cprueba.leerMovs();



        //Imprimir la lista

//        for(Movimientos ob: movs){
//            System.out.println(ob);
//        }


        //Escritura -insert


//        cprueba.guardarMov(0,25,"RETIRO", LocalDate.now(),5000.00);
//
        //Actualizacio
//        cprueba.actualizarMov(261,25,"DEPOSITO",LocalDate.now(),8000.00);


        // Eliminacion - delete

//        cprueba.eliminarMov(261);



// Objetos de clases hijas


        Basico cb = new Basico();

        cb.setUbicacion("Avenida Guadalupe #308");
//        List<Cuenta> cuentas = cb.obtenerCuentas(); //Invoca al metodo que que cargue la lista de
//        for (Cuenta c: cuentas){
//            System.out.println(c);
//        }

        cb.imprimirCuentas();
        cb.consultarSaldo("5578123412340004","4567");

        List<Object> tk1 = cb.retirar("5578123412340004","4567",10000);
//        List<Object> tk2 = cb.retirar("5578123412340004","4567",10000);
//        List<Object> tk3 = cb.retirar("5578123412340004","4567",10000);

        System.out.println(tk1.get(0));
//        System.out.println(tk2.get(0));
//        System.out.println(tk3.get(0));
        System.out.println(tk1.get(1));
        cb.consultarSaldo("5578123412340004","4567");








    }





}
