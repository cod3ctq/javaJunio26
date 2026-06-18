public class BoletoConcierto {

    String lugar;
    String nombreEvento;
    String zona;
    int boleto;


    public BoletoConcierto(String lugar, String nombreEvento, String zona, int boleto) {
        this.lugar = lugar;
        this.nombreEvento = nombreEvento;
        this.zona = zona;
        this.boleto = boleto;
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

    public int getBoleto() {
        return boleto;
    }

    public void setBoleto(int boleto) {
        this.boleto = boleto;
    }

    @Override
    public String toString() {
        return "BoletoConcierto{" +
                "lugar='" + lugar + '\'' +
                ", nombreEvento='" + nombreEvento + '\'' +
                ", zona='" + zona + '\'' +
                ", boleto=" + boleto +
                '}';
    }
}
