public class Ciudad {

    private String nombre;
    private String estado;
    private int habitantes;
    private String actEco;
    private double pib;
    private double tamaño;


    //Constructor lleno.
    public Ciudad(String nombre, String estado, int habitantes, String actEco, double pib, double tamaño) {
        this.nombre = nombre;
        this.estado = estado;
        this.habitantes = habitantes;
        this.actEco = actEco;
        this.pib = pib;
        this.tamaño = tamaño;
    }


    //Getters y Setters
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

    public double getTamaño() {
        return tamaño;
    }

    public void setTamaño(double tamaño) {
        this.tamaño = tamaño;
    }


    //Metodo tiString()
    @Override
    public String toString() {
        return "Ciudad{" +
                "nombre='" + nombre + '\'' +
                ", estado='" + estado + '\'' +
                ", habitantes=" + habitantes +
                ", actEco='" + actEco + '\'' +
                ", pib=" + pib +
                ", tamaño=" + tamaño +
                '}';
    }
}
