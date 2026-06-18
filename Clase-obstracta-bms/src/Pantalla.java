public class Pantalla {
    int hz;
    String resolucion;
    String  tipoPanel;
    String certificacion;
    double tamano;
    int ppi;

    public Pantalla(int hz, String resolucion, String tipoPanel, String certificacion, double tamano, int ppi) {
        this.hz = hz;
        this.resolucion = resolucion;
        this.tipoPanel = tipoPanel;
        this.certificacion = certificacion;
        this.tamano = tamano;
        this.ppi = ppi;
    }

    public int getHz() {
        return hz;
    }

    public void setHz(int hz) {
        this.hz = hz;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public String getTipoPanel() {
        return tipoPanel;
    }

    public void setTipoPanel(String tipoPanel) {
        this.tipoPanel = tipoPanel;
    }

    public String getCertificacion() {
        return certificacion;
    }

    public void setCertificacion(String certificacion) {
        this.certificacion = certificacion;
    }

    public double getTamano() {
        return tamano;
    }

    public void setTamano(double tamano) {
        this.tamano = tamano;
    }

    public int getPpi() {
        return ppi;
    }

    public void setPpi(int ppi) {
        this.ppi = ppi;
    }

    @Override
    public String toString() {
        return "Pantalla{" +
                "hz=" + hz +
                ", resolucion='" + resolucion + '\'' +
                ", tipoPanel='" + tipoPanel + '\'' +
                ", certificacion='" + certificacion + '\'' +
                ", tamano=" + tamano +
                ", ppi=" + ppi +
                '}';
    }
}
