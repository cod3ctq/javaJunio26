public class Iphone {

    //Atributos estaticos : definen su valor desde la propi clase
    // static + final = constante

    public static final String SISTEMA_OPERATIVO = "i0s";
    public static  String navegador = "Safari";
    public static String Fabricante = "Apple";


    private double dimenciones;
    private String color;
    private double precio;
    private String tipoBloqueo;

    public Iphone() {
    }

    public Iphone(String color, double dimenciones, double precio, String tipoBloqueo) {
        this.color = color;
        this.dimenciones = dimenciones;
        this.precio = precio;
        this.tipoBloqueo = tipoBloqueo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getDimenciones() {
        return dimenciones;
    }

    public void setDimenciones(double dimenciones) {
        this.dimenciones = dimenciones;
    }

    public static String getFabricante() {
        return Fabricante;
    }

    public static void setFabricante(String fabricante) {
        Fabricante = fabricante;
    }

    public static String getNavegador() {
        return navegador;
    }

    public static void setNavegador(String navegador) {
        Iphone.navegador = navegador;
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
                "color='" + color + '\'' +
                ", dimenciones=" + dimenciones +
                ", precio=" + precio +
                ", tipoBloqueo='" + tipoBloqueo + '\'' +
                '}';
    }
}


