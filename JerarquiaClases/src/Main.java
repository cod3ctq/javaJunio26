import java.time.LocalDate;

//No es posibe acceder a los miembros de clases hijas desde un objeto de la clase Padre

public class Main {
    public static void main(String[] args) {

        //Objeto de la clase padre (Superclase)
        Boleto ob = new Boleto("Macario", LocalDate.now(),500.00);

        //Objeto de la clase hija (Subclase)
        BoletoAutobus boa = new BoletoAutobus("Juan",LocalDate.now(),400.00,"Tlaxcala","Monterrey","Delux",231,2);

        BoletoCine bc = new BoletoCine("juan",LocalDate.now(),800.00,"Delux",4,"cine","dejdeid");

        //Invocando los metodos de la clase Padre
        ob.getNombre();
        ob.getPrecio();
        ob.getFechaHora();

        //Invocar miembros de las clases hijas desde un objeto de la clase padre
        //ob.getDestino(); ERROR
        //ob.getNombrePelicula(); ERROR

        //Invocando a los metodos heredados de desde un objeto de la clase hija
        boa.setNombre("Manuel");
        boa.setPrecio(400);
        boa.setFechaHora(LocalDate.now());

        //Invocar metodos exclusivos de la clase hija
        boa.getAsiento();
        boa.getDestino();
        boa.getOrigen();

        bc.getNombreCine();
        bc.getAsiento();
        bc.getNombrePelicula();





    }
}
