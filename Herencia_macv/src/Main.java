import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Objeto de la clase padre
        Boleto ob = new Boleto("Macario", LocalDate.now(),500.00);

        //Objeto de la clase hija
        BoletoAutobus boa = new BoletoAutobus("Kevil", LocalDate.now(),800.00,
                "Tlaxcala","Monterrey","DELUXE",14,35);

        BoletoCine bc = new BoletoCine("Martin",LocalDate.now(),90.00,
                "4D",15,"Matrix","Cinemex");

        //invoca a los metodos de la clase padre
        ob.getNombre();
        ob.getPrecio();
        ob.getFechaHora();


        //Invocar onjetos de las clases hijas desde un objeto de la clase padre
//        ob.getDestino(); ERROR
//        ob.getNombrePelicula(); ERROR

        //invoca a los metodos heredados desde un objero de la clase hija

        boa.getNombre();
        boa.getPrecio();
        boa.getFechaHora();

        //Metodos exclusivos de la clase hija
        boa.getAsiento();
        boa.getDestino();
        boa.getOrigen();


        bc.getNombreCine();
        bc.getAsiento();
        bc.getNimbrePelicula();








    }
}