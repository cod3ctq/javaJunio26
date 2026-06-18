import java.time.LocalDate;

//HEENCIA1: se aplica con extends
// Define una relacion ES UN
public class BoletoAutobus extends Boleto{

    // Parte 2: Especializacion
    // Agregar mas atributos que sean espesificos/exclusivos del modelo
    String origen;
    String destini;
    String nombre;
    int idAultos;
    int asiento;

    public String getOrigen() {
        return origen;
    }

    public String getDestini() {
        return destini;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdAultos() {
        return idAultos;
    }

    public int getAsiento() {
        return asiento;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public void setDestini(String destini) {
        this.destini = destini;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdAultos(int idAultos) {
        this.idAultos = idAultos;
    }

    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }

    @Override
    public String toString() {
        return "BoletoAutobus{" +
                "origen='" + origen + '\'' +
                ", destini='" + destini + '\'' +
                ", nombre='" + nombre + '\'' +
                ", idAultos=" + idAultos +
                ", asiento=" + asiento +
                ", tipoServicio='" + tipoServicio + '\'' +
                ", fechaHora=" + fechaHora +
                ", Precio=" + Precio +
                '}';
    }

    public BoletoAutobus(String tipoServicio, LocalDate fechaHora, double precio, String origen, String destini, String nombre, int idAultos, int asiento) {
        super(tipoServicio, fechaHora, precio); // Investigar
        this.origen = origen;
        this.destini = destini;
        this.nombre = nombre;
        this.idAultos = idAultos;
        this.asiento = asiento;







    }
}
