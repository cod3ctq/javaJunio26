/*
Objeto: Variable (direccion de memoria) que contiene la misma estructura definida por la clase
(instancia) es como se le conoce a la variable

la abstraccion tambien se le puede representar como el ocultar para simplificar

Instanciar es crear
*/

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa el nombre: ");

        //Objeto de la clase boleto
        //Clase nombreobjeto = new Constructor
        Boleto b1 = new Boleto();

        //Inyectar un valor al objeto(setter)
        b1.setNombre("Kelly Ozuna");

        //Inyectar un valor al objeto(setter)
        b1.setDestino("Acapulco");

        //Inyectar un valor al objeto(setter)
        b1.setOrigen("CDMX");

        //Inyectar un valor al objeto(setter)
        b1.setTipoServicio("Economico");

        //Inyectar un valor al objeto(setter)
        b1.setPrecio(1800.00);

        //Inyectar un valor al objeto(setter)
        b1.setNumeroAsiento(1);

        //Inyectar un valor al objeto(setter)
        b1.getFechaHoraSalida(LocalDate.now());


        //Ver el estado del objeto: ver que valores componen a los atributos del objeto
        System.out.println(b1);
        System.out.println("Destino: "+b1.getDestino());

        //Instanciar un objeto con TODOs sus datos completos desde el inicio
        //Forma es: (cantidad, orden, tipos de los argumentos)

        Boleto b2 = new Boleto("Carla lopez","Tijuana","Cancun","Economico",LocalDate.now(),15,2500.60,40);
    }


}
