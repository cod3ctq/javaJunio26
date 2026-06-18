import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {


        Boleto ob = new Boleto("Macario", LocalDate.now(), 500.00);

        Boletoutobus boa = new Boletoutobus("Kevin", LocalDate.now(), 800, "Tlaxcala", "Monterey", "Delux", 14, 35);

BoletoCine bc = new BoletoCine("4D",15,"Matrix","Cinemex");

        // invocando los nombres de la clase Padre
        ob.getNombre();
        ob.getPrecio();
        ob.getFechaHora();

        //Invocando a los metodos heredados desde la clase hija desde un objeto de la clase padre
//ob.

        boa.getNombre();
        boa.getPrecio();
        boa.getFechaHora();

// invocar metodos exclusivos de la clase hija
        boa.getAsiento();
        boa.getDestino();
        boa.getOrigen();


        bc.getNombreCine();
        bc.getAsirnto();
        bc.getNombrePelicula();
    }




    }

