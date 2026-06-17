import java.time.LocalDate;

public class BoletoCine extends Boleto{

    String tipoSala;
    int asiento;
    String nombrePelicula;
    String nombreCine;

    //Constructor con argumentos.

    public BoletoCine(String nombre, LocalDate fechaHoraSalida, double precio, String tipoSala, int asiento, String nombrePelicula, String nombreCine) {
        super(nombre, fechaHoraSalida, precio);
        this.tipoSala = tipoSala;
        this.asiento = asiento;
        this.nombrePelicula = nombrePelicula;
        this.nombreCine = nombreCine;
    }


    //Getter y Setter

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

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    public String getNombreCine() {
        return nombreCine;
    }

    public void setNombreCine(String nombreCine) {
        this.nombreCine = nombreCine;
    }


    //Metodo toString().

    @Override
    public String toString() {
        return "BoletoCine{" +
                "tipoSala='" + tipoSala + '\'' +
                ", asiento=" + asiento +
                ", nombrePelicula='" + nombrePelicula + '\'' +
                ", nombreCine='" + nombreCine + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fechaHoraSalida=" + fechaHoraSalida +
                ", precio=" + precio +
                '}';
    }
}
