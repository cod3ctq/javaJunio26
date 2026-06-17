import java.time.LocalDate;

public class BoletoConcierto extends Boleto{

    String lugar;
    String nombreEvento;
    String zona;
    int idBoleto;

    //Constructor con argumentos

    public BoletoConcierto(String nombre, LocalDate fechaHoraSalida, double precio, String lugar, String nombreEvento, String zona, int idBoleto) {
        super(nombre, fechaHoraSalida, precio);
        this.lugar = lugar;
        this.nombreEvento = nombreEvento;
        this.zona = zona;
        this.idBoleto = idBoleto;
    }


    //Getter y Setter

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public int getIdBoleto() {
        return idBoleto;
    }

    public void setIdBoleto(int idBoleto) {
        this.idBoleto = idBoleto;
    }


    //Metodo toString()

    @Override
    public String toString() {
        return "BoletoConcierto{" +
                "lugar='" + lugar + '\'' +
                ", nombreEvento='" + nombreEvento + '\'' +
                ", zona='" + zona + '\'' +
                ", idBoleto=" + idBoleto +
                ", nombre='" + nombre + '\'' +
                ", fechaHoraSalida=" + fechaHoraSalida +
                ", precio=" + precio +
                '}';
    }
}
