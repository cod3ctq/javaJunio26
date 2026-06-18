public class Camara {
    String resolucion;
    int nivelZoom;
    String tipoLente;
    int valorIso;

    public Camara(String resolucion, int nivelZoom, String tipoLente, int valorIso) {
        this.resolucion = resolucion;
        this.nivelZoom = nivelZoom;
        this.tipoLente = tipoLente;
        this.valorIso = valorIso;
    }

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

    public int getValorIso() {
        return valorIso;
    }

    public void setValorIso(int valorIso) {
        this.valorIso = valorIso;
    }

    @Override
    public String toString() {
        return "Camara{" +
                "resolucion='" + resolucion + '\'' +
                ", nivelZoom=" + nivelZoom +
                ", tipoLente='" + tipoLente + '\'' +
                ", valorIso=" + valorIso +
                '}';
    }
}
