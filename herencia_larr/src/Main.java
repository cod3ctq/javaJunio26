import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Objeto de la clase Padre
        Boleto ob = new Boleto("Macario", LocalDate.now(),500.00);

        //Objeto de la clase hoja
        BoletoAutobus boa = new BoletoAutobus("Kevin",LocalDate.now(),
                800.00,"Tlaxcala","Monterrey","DELUXE",14,35);

        BoletoCine bc = new BoletoCine("Martin",LocalDate.now(),90.00,"4D",
                15,"Matrix","Cinemex");


        //Invocando a los atributos de la clase Padre
        ob.getNombre();
        ob.getPrecio();
        ob.getFechaHoraSalida();

        //Invocar miembros de las clases hijas desde un objeto de la clase Padre
//        ob.getDestino(); // ERROR
//        ob.getNombrePelicula(); // ERROR

        //Invocando a los metodos desde un objeto de la clase hija
        boa.getNombre();
        boa.getPrecio();
        boa.getFechaHoraSalida();

        //Invocar metodos exclusivos de la clase hija
        boa.getAsiento();
        boa.getDestino();
        boa.getOrigen();

        bc.getNombreCine();
        bc.getAsiento();
        bc.getNombrePelicula();


    }
}