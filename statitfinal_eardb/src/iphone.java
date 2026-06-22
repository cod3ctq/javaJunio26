public class iphone {

    public static  String sistemaOperativo ="iOS";
    public static  String navegador ="safari";
    public static  String fabricante ="Apple";

    private double dimenciones;
    private String color;
    private double precio;
    private String tipoBloqueo;

    public iphone(){}


    public iphone(double dimenciones, String color, double precio, String tipoBloqueo) {
        this.dimenciones = dimenciones;
        this.color = color;
        this.precio = precio;
        this.tipoBloqueo = tipoBloqueo;
    }

    public static String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public static void setSistemaOperativo(String sistemaOperativo) {
        iphone.sistemaOperativo = sistemaOperativo;
    }

    public static String getNavegador() {
        return navegador;
    }

    public static void setNavegador(String navegador) {
        iphone.navegador = navegador;
    }

    public static String getFabricante() {
        return fabricante;
    }

    public static void setFabricante(String fabricante) {
        iphone.fabricante = fabricante;
    }

    public double getDimenciones() {
        return dimenciones;
    }

    public void setDimenciones(double dimenciones) {
        this.dimenciones = dimenciones;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipoBloqueo() {
        return tipoBloqueo;
    }

    public void setTipoBloqueo(String tipoBloqueo) {
        this.tipoBloqueo = tipoBloqueo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "iphone{" +
                "dimenciones=" + dimenciones +
                ", color='" + color + '\'' +
                ", precio=" + precio +
                ", tipoBloqueo='" + tipoBloqueo + '\'' +
                '}';
    }
}
