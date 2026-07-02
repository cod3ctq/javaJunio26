//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.sql.*;

import java.util.List;

//dependencia
public class Main {
    public static void main(String[] args) {
        /*
      clasePrueba cp= new clasePrueba();
////        List<Movimientos> x = new clasePrueba().leerMovs();
////
////        for(Movimientos ob:x){
////            System.out.println(ob);
////        }
//        //cp.insertarMov(252, 24, "RETIRO", LocalDate.now(),5000.01);
//        //cp.insertarMov(300, 25, "RETIRO", LocalDate.now(),5000.01);
//        //cp.actualizarRegistri(252, 25, "RETIRO", LocalDate.now(),5500.01);
//        cp.delete(252);*/
        Basico cb = new Basico();
        cb.setUbicacion("Avenida Guadalupe Blass #358");
       List<Object> tk1 = cb.retirar("5578123412340001", "1234", 10);
       // List<Object> tk2 = cb.retirar("5578123412340004", "4567", 10000);
       // List<Object> tk3 = cb.retirar("5578123412340004", "4567", 10000);
        //cb.ultimoMovimiento();
// Imprime los ticket individuales (3)
        //System.out.println(tk1.get(0));
        //12392.75
//        System.out.println(tk2.get(0));
//        System.out.println(tk3.get(0));

        //System.out.println(tk1.get(1));
       // cb.consultarSaldo("5578123412340004", "4567");
    }
}