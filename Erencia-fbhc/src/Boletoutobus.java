import java.time.LocalDate;

// Herencia : Se aplica con extends
// Define una relacion es UN

public class Boletoutobus extends Boleto{

    // Parte 2 Especializazcion
    //Agregar mas atributos que sean especificos /exclusivos del modelo
    String origen;
    String destino;
    String tipoServicio;
    int idAutobus;
    int asiento;


    // Dentro de una clase si no se genera ningun constructor
    //Java entrega el constructor vacio por drfaul
    //Pero si se genera alguno, entonces ya no se genera el vacio

    public Boletoutobus(String nombre, LocalDate fechaHora, double precio, String origen, String destino, String tipoServicio, int idAutobus, int asiento) {
        super(nombre, fechaHora, precio);   //Llama al constructor de la clase padre
        this.origen = origen;
        this.destino = destino;
        this.tipoServicio = tipoServicio;
        this.idAutobus = idAutobus;
        this.asiento = asiento;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public int getIdAutobus() {
        return idAutobus;
    }

    public void setIdAutobus(int idAutobus) {
        this.idAutobus = idAutobus;
    }

    public int getAsiento() {
        return asiento;
    }

    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }

    @Override
    public String toString() {
        return "Boletoutobus{" +
                "origen='" + origen + '\'' +
                ", destino='" + destino + '\'' +
                ", tipoServicio='" + tipoServicio + '\'' +
                ", idAutobus=" + idAutobus +
                ", asiento=" + asiento +
                ", nombre='" + nombre + '\'' +
                ", fechaHora=" + fechaHora +
                ", Precio=" + Precio +
                '}';
    }
}
