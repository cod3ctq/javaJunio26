import java.time.LocalDate;

public class BoletoCine extends Boleto{

    String tipoSala;
    int asiento;
    String nombreCine;
    String nombrePelicula;

    //Contructor lleno
    public BoletoCine(String nombre, LocalDate fechaHora, double precio, String tipoSala, int asiento, String nombreCine, String nombrePelicula) {
        super(nombre, fechaHora, precio);
        this.tipoSala = tipoSala;
        this.asiento = asiento;
        this.nombreCine = nombreCine;
        this.nombrePelicula = nombrePelicula;
    }

    //Setters y Getters


    public String getTipoSala() {
        return tipoSala;
    }

    public void setTipoSala(String tipoSala) {
        this.tipoSala = tipoSala;
    }

    public int getAsiento() {
        return asiento;
    }

    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }

    public String getNombreCine() {
        return nombreCine;
    }

    public void setNombreCine(String nombreCine) {
        this.nombreCine = nombreCine;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombrePelicula = nombreCliente;
    }

    //toString
    @Override
    public String toString() {
        return "BoletoCine{" +
                "tipoSala='" + tipoSala + '\'' +
                ", asiento=" + asiento +
                ", nombreCine='" + nombreCine + '\'' +
                ", nombreCliente='" + nombrePelicula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fechaHora=" + fechaHora +
                ", precio=" + precio +
                '}';
    }
}
