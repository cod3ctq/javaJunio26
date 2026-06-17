import java.time.LocalDate;

public class BoletoCine extends Boleto{

    String tipoSala;
    int asiento;
    String nimbrePelicula;
    String nombreCine;

    public BoletoCine(String nombre, LocalDate fechaHora, double precio, String tipoSala, int asiento, String nimbrePelicula, String nombreCine) {
        super(nombre, fechaHora, precio);
        this.tipoSala = tipoSala;
        this.asiento = asiento;
        this.nimbrePelicula = nimbrePelicula;
        this.nombreCine = nombreCine;
    }

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

    public String getNimbrePelicula() {
        return nimbrePelicula;
    }

    public void setNimbrePelicula(String nimbrePelicula) {
        this.nimbrePelicula = nimbrePelicula;
    }

    public String getNombreCine() {
        return nombreCine;
    }

    public void setNombreCine(String nombreCine) {
        this.nombreCine = nombreCine;
    }

    @Override
    public String toString() {
        return "BoletoCine{" +
                "tipoSala='" + tipoSala + '\'' +
                ", asiento=" + asiento +
                ", nimbrePelicula='" + nimbrePelicula + '\'' +
                ", nombreCine='" + nombreCine + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fechaHora=" + fechaHora +
                ", precio=" + precio +
                '}';
    }
}
