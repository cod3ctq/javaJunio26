public class Camara {

    String resolucion;
    int nivelZoom;
    String tipoLente;
    int valorISO;

    //Constructor lleno
    public Camara(String resolucion, int nivelZoom, String tipoLente, int valorISO) {
        this.resolucion = resolucion;
        this.nivelZoom = nivelZoom;
        this.tipoLente = tipoLente;
        this.valorISO = valorISO;
    }


    //Getter y Setter
    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public int getNivelZoom() {
        return nivelZoom;
    }

    public void setNivelZoom(int nivelZoom) {
        this.nivelZoom = nivelZoom;
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

    //Metodo toString()
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
