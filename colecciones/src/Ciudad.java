public class Ciudad {
    private String nombre;
    private String estado;
    private int habitantes;
    private String actEco;
    private double pib;
    private double tamaño;


    public Ciudad(String actEco, String estado, int habitantes, String nombre, double pib, double tamaño) {
        this.actEco = actEco;
        this.estado = estado;
        this.habitantes = habitantes;
        this.nombre = nombre;
        this.pib = pib;
        this.tamaño = tamaño;
    }


    public String getActEco() {
        return actEco;
    }

    public void setActEco(String actEco) {
        this.actEco = actEco;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPib() {
        return pib;
    }

    public void setPib(double pib) {
        this.pib = pib;
    }

    public double getTamaño() {
        return tamaño;
    }

    public void setTamaño(double tamaño) {
        this.tamaño = tamaño;
    }


    @Override
    public String toString() {
        return "Ciudad{" +
                "actEco='" + actEco + '\'' +
                ", nombre='" + nombre + '\'' +
                ", estado='" + estado + '\'' +
                ", habitantes=" + habitantes +
                ", pib=" + pib +
                ", tamaño=" + tamaño +
                '}';
    }
}
