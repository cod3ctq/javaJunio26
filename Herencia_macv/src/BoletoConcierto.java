import java.time.LocalDate;

public class BoletoConcierto extends Boleto{

    String lugar;
    String nombreEvento;
    String zona;
    int voletoId;

    public BoletoConcierto(String nombre, LocalDate fechaHora, double precio, String lugar, String nombreEvento, String zona, int voletoId) {
        super(nombre, fechaHora, precio);
        this.lugar = lugar;
        this.nombreEvento = nombreEvento;
        this.zona = zona;
        this.voletoId = voletoId;
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

    public int getVoletoId() {
        return voletoId;
    }

    public void setVoletoId(int voletoId) {
        this.voletoId = voletoId;
    }

    @Override
    public String toString() {
        return "BoletoConcierto{" +
                "lugar='" + lugar + '\'' +
                ", nombreEvento='" + nombreEvento + '\'' +
                ", zona='" + zona + '\'' +
                ", voletoId=" + voletoId +
                ", nombre='" + nombre + '\'' +
                ", fechaHora=" + fechaHora +
                ", precio=" + precio +
                '}';
    }
}
