public class Pantalla {
    int hz;
    String resolucion;
    String tipoPanel;
    String certificion;
    double tamaño;
    int ppi;

    public Pantalla(int hz, String resolucion, String tipoPanel, String certificion, double tamaño, int ppi) {
        this.hz = hz;
        this.resolucion = resolucion;
        this.tipoPanel = tipoPanel;
        this.certificion = certificion;
        this.tamaño = tamaño;
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

    public String getCertificion() {
        return certificion;
    }

    public void setCertificion(String certificion) {
        this.certificion = certificion;
    }

    public double getTamaño() {
        return tamaño;
    }

    public void setTamaño(double tamaño) {
        this.tamaño = tamaño;
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
                ", certificion='" + certificion + '\'' +
                ", tamaño=" + tamaño +
                ", ppi=" + ppi +
                '}';
    }
}
