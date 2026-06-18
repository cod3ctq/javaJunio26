public class Pantalla {

    int hz;
    String resolucion;
    String tipoPanel;
    String certificacion;
    double tamaño;
    int ppi;


    //Constructor lleno
    public Pantalla(int hz, String resolucion, String tipoPanel, String certificacion, double tamaño, int ppi) {
        this.hz = hz;
        this.resolucion = resolucion;
        this.tipoPanel = tipoPanel;
        this.certificacion = certificacion;
        this.tamaño = tamaño;
        this.ppi = ppi;
    }

    //Getter y Setter
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

    //Metodo toString()
    @Override
    public String toString() {
        return "Pantalla{" +
                "hz=" + hz +
                ", resolucion='" + resolucion + '\'' +
                ", tipoPanel='" + tipoPanel + '\'' +
                ", certificacion='" + certificacion + '\'' +
                ", tamaño=" + tamaño +
                ", ppi=" + ppi +
                '}';
    }
}
