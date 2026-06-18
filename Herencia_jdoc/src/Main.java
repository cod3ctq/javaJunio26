import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Objeto calse madre
        Boleto ob = new Boleto("macario", LocalDate.now(),500);
        System.out.println(ob);

        //OBJETO CLASE HIJA


        //Dentro de una clase, SINO SE LE GENERA NINGUN CONSTRUCTOR
        //Java otorga el CONSTRUCTOR VACIO POR DEFAULT
        //Pero si se genera alguno, entonces ya no se le otorga el vacio
        BoletoAutobus boa = new BoletoAutobus("kevin", LocalDate.now(), 800, "Tlaxcala", "Monterrey", "Deluxe", 14, 3 );

        BoletoCine bc = new BoletoCine



        // Invocando a los metodos de la clase padre

        ob.getTipoServicio();
        ob.getPrecio();
        ob.getFechaHora();

        //Invocando los metodos heredados desde un objeto de la clase padre
        //ob.getDestino(); ERROR
        //ob.getNombrePelicula();ERROR

        //Invocando onjetos desde la clase

        boa.getTipoServicio();
        boa.getPrecio();
        boa.getFechaHora();

        //Invocando metodos exclusivoss de la clase hija

        boa.getAsiento();
        boa.getDestini();
        boa.getOrigen();

        bc.getNombreSala();
        bc.getAsiento();
        bc.getNombrePelicula();

        boa.





}