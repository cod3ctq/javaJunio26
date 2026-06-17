import java.time.LocalDate;

public class BoletoCine extends Boleto{

    String tipoSala;
    int asiento;
    String nombrePelicula;
    String nombreCine;

    public BoletoCine(String nombre, LocalDate fechaHora, double precio, String tipoSala, int asiento, String nombrePelicula, String nombreCine) {
        super(nombre, fechaHora, precio);
        this.tipoSala = tipoSala;
        this.asiento = asiento;
        this.nombrePelicula = nombrePelicula;
        this.nombreCine = nombreCine;
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

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    public int getAsiento() {
        return asiento;
    }

    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }

    public String getTipoSala() {
        return tipoSala;
    }

    public void setTipoSala(String tipoSala) {
        this.tipoSala = tipoSala;
    }

    @Override
    public String toString() {
        return "BoletoCine{" +
                "nombre='" + nombre + '\'' +
                ", tipoSala='" + tipoSala + '\'' +
                ", asiento=" + asiento +
                ", nombrePelicula='" + nombrePelicula + '\'' +
                ", nombreCine='" + nombreCine + '\'' +
                ", fechaHora=" + fechaHora +
                ", precio=" + precio +
                '}';
    }
}
