public class ciudad {

    private String nombre;
    private String estado;
    private int habitantes;
    private String actEco;
    private double PIB;
    private double tamaño;

    public ciudad(String nombre, String estado, int habitantes, String actEco, double PIB, double tamaño) {
        this.nombre = nombre;
        this.estado = estado;
        this.habitantes = habitantes;
        this.actEco = actEco;
        this.PIB = PIB;
        this.tamaño = tamaño;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getHabitantes() {
        return habitantes;
    }

    public void setHabitantes(int habitantes) {
        this.habitantes = habitantes;
    }

    public String getActEco() {
        return actEco;
    }

    public void setActEco(String actEco) {
        this.actEco = actEco;
    }

    public double getPIB() {
        return PIB;
    }

    public void setPIB(double PIB) {
        this.PIB = PIB;
    }

    public double getTamaño() {
        return tamaño;
    }

    public void setTamaño(double tamaño) {
        this.tamaño = tamaño;
    }

    @Override
    public String toString() {
        return "ciudad{" +
                "nombre='" + nombre + '\'' +
                ", estado='" + estado + '\'' +
                ", habitantes=" + habitantes +
                ", actEco='" + actEco + '\'' +
                ", PIB=" + PIB +
                ", tamaño=" + tamaño +
                '}';
    }
}
