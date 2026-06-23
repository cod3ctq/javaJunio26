public class Ciudad {
    private String nombre;
    private String estado;
    private int habitantes;
    private String actEco;
    private double pib;
    private double tamano;

    public Ciudad(){

    }

    public Ciudad(String nombre, String estado, int habitantes, String actEco, double pib, double tamano) {
        this.nombre = nombre;
        this.estado = estado;
        this.habitantes = habitantes;
        this.actEco = actEco;
        this.pib = pib;
        this.tamano = tamano;
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

    public double getPib() {
        return pib;
    }

    public void setPib(double pib) {
        this.pib = pib;
    }

    public double getTamano() {
        return tamano;
    }

    public void setTamano(double tamano) {
        this.tamano = tamano;
    }

    @Override
    public String toString() {
        return "Ciudad{" +
                "nombre='" + nombre + '\'' +
                ", estado='" + estado + '\'' +
                ", habitantes=" + habitantes +
                ", actEco='" + actEco + '\'' +
                ", pib=" + pib +
                ", tamano=" + tamano +
                '}';
    }
}
