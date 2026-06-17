import java.time.LocalDate;

//En java solo existe herencia simple
public class BoletoConcierto extends Boleto {
    String lugar;
    String nombreEvento;
    String zona;
    int bolletoid;

    //Contructor lleno
    public BoletoConcierto(String nombre, LocalDate fechaHora, double precio, String lugar, String nombreEvento, String zona, int bolletoid) {
        super(nombre, fechaHora, precio);
        this.lugar = lugar;
        this.nombreEvento = nombreEvento;
        this.zona = zona;
        this.bolletoid = bolletoid;
    }

    //Getters and Setters

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

    public int getBolletoid() {
        return bolletoid;
    }

    public void setBolletoid(int bolletoid) {
        this.bolletoid = bolletoid;
    }

    //toString

    @Override
    public String toString() {
        return "BoletoConcierto{" +
                "lugar='" + lugar + '\'' +
                ", nombreEvento='" + nombreEvento + '\'' +
                ", zona='" + zona + '\'' +
                ", bolletoid=" + bolletoid +
                ", nombre='" + nombre + '\'' +
                ", fechaHora=" + fechaHora +
                ", precio=" + precio +
                '}';
    }
}
