public class Pantalla {

    int hz;
    String resolucion;
    String tiposPanel;
    String certificacion;
    double tamaño;
    int ppi;

    public Pantalla(int hz, String resolucion, String tiposPanel, String certificacion, double tamaño, int ppi) {
        this.hz = hz;
        this.resolucion = resolucion;
        this.tiposPanel = tiposPanel;
        this.certificacion = certificacion;
        this.tamaño = tamaño;
        this.ppi = ppi;
    }

    public int getHz() {
        return hz;
    }

    public String getResolucion() {
        return resolucion;
    }

    public String getTiposPanel() {
        return tiposPanel;
    }

    public String getCertificacion() {
        return certificacion;
    }

    public double getTamaño() {
        return tamaño;
    }

    public int getPpi() {
        return ppi;
    }

    public void setHz(int hz) {
        this.hz = hz;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public void setTiposPanel(String tiposPanel) {
        this.tiposPanel = tiposPanel;
    }

    public void setCertificacion(String certificacion) {
        this.certificacion = certificacion;
    }

    public void setTamaño(double tamaño) {
        this.tamaño = tamaño;
    }

    public void setPpi(int ppi) {
        this.ppi = ppi;
    }

    @Override
    public String toString() {
        return "Pantalla{" +
                "hz=" + hz +
                ", resolucion='" + resolucion + '\'' +
                ", tiposPanel='" + tiposPanel + '\'' +
                ", certificacion='" + certificacion + '\'' +
                ", tamaño=" + tamaño +
                ", ppi=" + ppi +
                '}';
    }
}

