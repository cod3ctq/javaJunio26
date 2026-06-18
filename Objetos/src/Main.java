import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner sca = new Scanner(System.in);
        System.out.println("Ingrese el nombre");


        // Objetos de la clase boleto
        // Clase nombreobjeto = constructor
        Boleto b1 = new Boleto();             // Es la instancia de la clase  objetio variable (direccion de memoria que contiene

        // ver el estado del objeto : Ver que valores componen a los atributos del objeto
        System.out.println(b1);


        // Inyectar un valor al objeto (seter)
         b1.setNombre("Kelly Ozuna");
         b1.setDestino("Chiapas");
         b1.setOrigen("CDMX");
         b1.setTiposervicio("Economico");
         b1.setPrecio(1800.00);
         b1.setIdAutobus(70);
         b1.setNumeroAciento(1);
         b1.setFechaHoraSalida(LocalDate.now());
        System.out.println(b1);


        // Obtener valores individuales desde los objetos (getters)
        System.out.println("Destino :"+ b1.getDestino());
//        System.out.println("Fecha :"+ b1.);


        // instanciar un objeto con sus datos completos desde el inicio

        Boleto b2 = new Boleto("Carla Lopez","Tijuana"," Cancun","Economico",LocalDate.now(),15,2500,40);

        // Estado del objeto
        System.out.println(b2);
        System.out.println("Cliente : " + b2.getNombre());


    }
}