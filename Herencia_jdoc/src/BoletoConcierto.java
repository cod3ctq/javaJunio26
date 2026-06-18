public class BoletoConcierto {

    String lugar;
    String nombreEvento;
    String zona;
    int boletoId;

    public BoletoConcierto(String lugar, String nombreEvento, String zona, int boletoId) {
        this.lugar = lugar;
        this.nombreEvento = nombreEvento;
        this.zona = zona;
        this.boletoId = boletoId;

    }

    public String getLugar() {
        return lugar;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public String getZona() {
        return zona;
    }

    public int getBoletoId() {
        return boletoId;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public void setZona(String zona) {
        this.zona = zona;
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
                '}';
    }
}
