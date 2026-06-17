import java.time.LocalDate;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el nombre");

        //objeto de la clase boleto
        //Clase nombreObjeto = new Constructor
        Boleto b1 = new Boleto();

        //Ver el estado del objeto : ver que valores componen a los atributos del objeto
//        System.out.println(b1);

        //inyectar un valor al objeto
        b1.setNombre("Miguel Angel");
        b1.setDestino("Acapulco");
        b1.setOrigen("CDMX");
        b1.setTipoServicio("Economico");
        b1.setPrecio(1800.00);
        b1.setIdAutobus(70);
        b1.setNumeroAsiento(1);
        b1.setFechaHoraSalida(LocalDate.now());
//        System.out.println(b1);

        //obtener valores individuales desde los objetos (getters)
//        System.out.println("Destino: "+b1.getDestino());
        //System.out.println("Fecha: "+b1.setFechaHoraSalida(LocalDate.now()));

        //instanciar un objeto con TODOS sus datos completos desde el inicio
        Boleto b2 = new Boleto("Carla Lopez","Tijuana","Cancun","Economico",LocalDate.now(),15,2500.60,40);

        //Estado del objeto COMPLETO
        System.out.println(b2);

        System.out.println("Cliente");



    }
}