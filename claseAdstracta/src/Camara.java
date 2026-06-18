public class Camara {
    String resolucicon;
    int zoom;
    String tipoLente;
    int valorISO;

    public Camara(String resolucicon, int zoom, String tipoLente, int valorISO) {
        this.resolucicon = resolucicon;
        this.zoom = zoom;
        this.tipoLente = tipoLente;
        this.valorISO = valorISO;
    }

    public String getResolucicon() {
        return resolucicon;
    }

    public void setResolucicon(String resolucicon) {
        this.resolucicon = resolucicon;
    }

    public int getZoom() {
        return zoom;
    }

    public void setZoom(int zoom) {
        this.zoom = zoom;
    }

    public String getTipoLente() {
        return tipoLente;
    }

    public void setTipoLente(String tipoLente) {
        this.tipoLente = tipoLente;
    }

    public int getValorISO() {
        return valorISO;
    }

    public void setValorISO(int valorISO) {
        this.valorISO = valorISO;
    }

    @Override
    public String toString() {
        return "Camara{" +
                "resolucicon='" + resolucicon + '\'' +
                ", zoom=" + zoom +
                ", tipoLente='" + tipoLente + '\'' +
                ", valorISO=" + valorISO +
                '}';
    }
}
