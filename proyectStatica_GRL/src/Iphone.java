import java.util.Stack;

public class Iphone {

    public static final  String systema="10s";
    public static  String navegado="Safari";
    public static String fabricante="apple";

    private  double dimenisones;
    private String color;
    private  double precio;
    private  String tipoBloqueo;



    public Iphone(){}

    public Iphone(double dimenisones, String color, double precio, String tipoBloqueo) {
        this.dimenisones = dimenisones;
        this.color = color;
        this.precio = precio;
        this.tipoBloqueo = tipoBloqueo;
    }

    @Override
    public String toString() {
        return "Iphone{" +
                "dimenisones=" + dimenisones +
                ", color='" + color + '\'' +
                ", precio=" + precio +
                ", tipoBloqueo='" + tipoBloqueo + '\'' +
                '}';
    }

    public static String getSystema() {
        return systema;
    }

    public static String getNavegado() {
        return navegado;
    }

    public static void setNavegado(String navegado) {
        Iphone.navegado = navegado;
    }

    public static String getFabricante() {
        return fabricante;
    }

    public static void setFabricante(String fabricante) {
        Iphone.fabricante = fabricante;
    }

    public double getDimenisones() {
        return dimenisones;
    }

    public void setDimenisones(double dimenisones) {
        this.dimenisones = dimenisones;
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
