import javax.xml.crypto.Data;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        String nombre="Gabreil";
        String destino="micuacan";
        String origen="puebla";
        String tipoServicio="transporte";
        LocalDate ferchaHorario=LocalDate.now();
        int idAutobus=10;
        float precio=100.2f;
        int numeroAsientos=100;
        Boleto b= new Boleto(nombre,destino,origen,tipoServicio,ferchaHorario,idAutobus,precio,numeroAsientos);

        //inyeciones
         b.setNombre("Luna bella");
         b.setTipoServicio("premium");
         b.setOrigen("CDMX");
         b.setTipoServicio("economico");
         b.setPrecio(1800);

        System.out.println(b);

        //objeto; variable (direccion de memeoria )
        //ver el esraod del objeto  ver quev valores  componen a los atributos del objeto

        //intanciar un objeto con todos sus todas desde el principio
        //cantidad y orden de los argumentos
        Boleto b2= new Boleto(nombre,destino,origen,tipoServicio,ferchaHorario,idAutobus,precio,numeroAsientos);
        System.out.println(b2);
        Boleto b3=new Boleto("pasafero 1","cholula", LocalDate.now(),"mediabo");
        System.out.println(b3);
    }
}