public class Camara {

    String resolucion;
    int nivelZoom;
    String tipoLente;
    int valorISO;

    public Camara(String resolucion, int nivelZoom, String tipoLente, int valorISO) {
        this.resolucion = resolucion;
        this.nivelZoom = nivelZoom;
        this.tipoLente = tipoLente;
        this.valorISO = valorISO;
    }

    public String getResolucion() {
        return resolucion;
    }

    public int getNivelZoom() {
        return nivelZoom;
    }

    public String getTipoLente() {
        return tipoLente;
    }

    public int getValorISO() {
        return valorISO;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public void setNivelZoom(int nivelZoom) {
        this.nivelZoom = nivelZoom;
    }

    public void setTipoLente(String tipoLente) {
        this.tipoLente = tipoLente;
    }

    public void setValorISO(int valorISO) {
        this.valorISO = valorISO;
    }

    @Override
    public String toString() {
        return "Camara{" +
                "resolucion='" + resolucion + '\'' +
                ", nivelZoom=" + nivelZoom +
                ", tipoLente='" + tipoLente + '\'' +
                ", valorISO=" + valorISO +
                '}';
    }
}
