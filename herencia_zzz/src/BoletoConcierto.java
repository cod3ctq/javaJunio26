import java.time.LocalDate;

public class BoletoConcierto extends Boleto{

    String lugar;
    String nombreEvento;
    String zona;
    int boletoId;

    public BoletoConcierto(String nombre, LocalDate fechaHora, double precio, String lugar, String nombreEvento, String zona, int boletoId) {
        super(nombre, fechaHora, precio);
        this.lugar = lugar;
        this.nombreEvento = nombreEvento;
        this.zona = zona;
        this.boletoId = boletoId;
    }

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

    public int getBoletoId() {
        return boletoId;
    }

    public void setBoletoId(int boletoId) {
        this.boletoId = boletoId;
    }

    @Override
    public String toString() {
        return "BoletoConcierto{" +
                "lugar='" + lugar + '\'' +
                ", nombreEvento='" + nombreEvento + '\'' +
                ", zona='" + zona + '\'' +
                ", boletoId=" + boletoId +
                ", nombre='" + nombre + '\'' +
                ", fechaHora=" + fechaHora +
                ", precio=" + precio +
                '}';
    }
}
