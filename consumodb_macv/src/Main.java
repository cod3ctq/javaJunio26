import java.util.List;

public class Main {
    public static void main(String[] args) {

//clasePrueba cprueba = new clasePrueba();
//Lectura - SELECT
//List<Movimiento> movs = cprueba.leerMovs();
//Imprimir la lista
//        for (Movimiento ob:movs){
//            System.out.println(ob);
//        }
//        //Escritura - INSERT
//        //cprueba.guardarMov(0,14,"DEPOSITO", LocalDate.now(),5000.00);
//        //Actualizacion
//        //cprueba.actualizarMov(261,14,"RETIRO", LocalDate.now(),8000.00);
//        cprueba.eliminarMov(261);

        //Objeto de la clase hija
        Basico cb = new Basico();
        cb.setUbicacion("Avenia Guadalupe Blass #358");
        cb.imprimirCuentas();
        cb.consultarSaldo("5578123412340003","3456");

        List<Object> tk1 = cb.retirar("5578123412340003","3456",10000);
//        List<Object> tk2 = cb.retirar("5578123412340003","3456",10000);
//        List<Object> tk3 = cb.retirar("5578123412340003","3456",10000);
        //imprime los tickets individualmente
        System.out.println(tk1.get(0));
//        System.out.println(tk2.get(0));
//        System.out.println(tk3.get(0));

        System.out.println(tk1.get(1));
        cb.consultarSaldo("5578123412340003","3456");

    }
}


