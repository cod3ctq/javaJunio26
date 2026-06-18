import java.time.LocalDate;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner entrada= new Scanner(System.in);
        // Objero de la clase Boleto
        //calse
        Boleto b1= new Boleto();

        //Ber el estado del objeto: ver que valores componen a los atributos del objeto

        b1.setNombre("KELLY OZUNA");
        System.out.println(b1);
        b1.setDestino("acapulco");
        b1.setOrigen("cdmx");
        b1.setTipoServicio("economico");
        b1.setPrecio(1800);
        b1.setIdAdultos(70);
        b1.setNumeroAsiento(1);
        b1.setFrcha(LocalDate.now());
        System.out.println(b1);

        //OBTENER VALORES INDIVIDUALES DEL OBJETOS (GETTERS)
        System.out.println("DESTINO:"  + b1.getDestino());
        // INSTANCIAR UN OBJETO CON TODOS sus datos completos desde el inicio
        Boleto b2= new Boleto("carla lopez", "tijuana", "cancun", "economico",LocalDate.now(),15,2500,25);
        //Estado del objeto completo
        System.out.println(b2);

        System.out.println("Cliente" +b2.getNombre());













    }
}