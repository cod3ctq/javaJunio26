public class Iphone {

    //Atributos estaticos: Definen sus valores desde la propia clase
    //static + final = CONSTANTE
    public static final String SISTEMA_OPERATIVO = "IOS";
    public static String navegadir = "Safari";
    public static String fabricante = "Apple";


    //Atributos de instancia: cada instancia puede recibir valores diferentes en entos atributos
    private double dimensiones;
    private String color;
    private double precio;
    private String tipoBloqueo;


    public Iphone (){}

    public Iphone(double dimensiones, String color, double precio, String tipoBloqueo) {
        this.dimensiones = dimensiones;
        this.color = color;
        this.precio = precio;
        this.tipoBloqueo = tipoBloqueo;
    }


    public static String getNavegadir() {
        return navegadir;
    }

    public static void setNavegadir(String navegadir) {
        Iphone.navegadir = navegadir;
    }

    public static String getFabricante() {
        return fabricante;
    }

    public static void setFabricante(String fabricante) {
        Iphone.fabricante = fabricante;
    }

    public double getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(double dimensiones) {
        this.dimensiones = dimensiones;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTipoBloqueo() {
        return tipoBloqueo;
    }

    public void setTipoBloqueo(String tipoBloqueo) {
        this.tipoBloqueo = tipoBloqueo;
    }

    @Override
    public String toString() {
        return "Iphone{" +
                "dimensiones=" + dimensiones +
                ", color='" + color + '\'' +
                ", precio=" + precio +
                ", tipoBloqueo='" + tipoBloqueo + '\'' +
                '}';
    }
}
