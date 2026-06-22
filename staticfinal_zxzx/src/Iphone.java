public class Iphone {

    //Atributos estaticos : Definen sus valores desde la propia clase
    //static + final = CONSTANTE
    public static final String SISTEMA_OPERATIVO = "iOs";
    public static String navegador = "Safari";
    public static String fabricante="Apple";

    //Atributos de instancia : cada instancia puede recibir valores diferentes en estos atributos
    private double dimensiones;
    private String color;
    private double precio;
    private String tipoBloqueo;

    public Iphone(){}

    public Iphone(double dimensiones, String color, double precio, String tipoBloqueo) {
        this.dimensiones = dimensiones;
        this.color = color;
        this.precio = precio;
        this.tipoBloqueo = tipoBloqueo;
    }


    public static String getNavegador() {
        return navegador;
    }

    public static void setNavegador(String navegador) {
        Iphone.navegador = navegador;
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
}
