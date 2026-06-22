public class iphone {

    public static final String  SISTEMA_OPERATIVO = "iOs";
    public static String navegador = " Safari";
    public static String fabricante = "Apple";

    private double dimensiones;
    private String color;
    private double precio;
    private String tipoBloqueo;

    public iphone() {
    }

    public iphone(double dimensiones, String color, double precio, String tipoBloqueo) {
        this.dimensiones = dimensiones;
        this.color = color;
        this.precio = precio;
        this.tipoBloqueo = tipoBloqueo;
    }




    public static String getNavegador() {
        return navegador;
    }

    public static String getFabricante() {
        return fabricante;
    }

    public double getDimensiones() {
        return dimensiones;
    }

    public String getColor() {
        return color;
    }

    public double getPrecio() {
        return precio;
    }

    public String getTipoBloqueo() {
        return tipoBloqueo;
    }

    public static void setSistemaOperativo(String sistemaOperativo) {
        iphone.sistemaOperativo = sistemaOperativo;
    }

    public static void setNavegador(String navegador) {
        iphone.navegador = navegador;
    }

    public static void setFabricante(String fabricante) {
        iphone.fabricante = fabricante;
    }

    public void setDimensiones(double dimensiones) {
        this.dimensiones = dimensiones;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setTipoBloqueo(String tipoBloqueo) {
        this.tipoBloqueo = tipoBloqueo;
    }

    @Override
    public String toString() {
        return "iphone{" +
                "dimensiones=" + dimensiones +
                ", color='" + color + '\'' +
                ", precio=" + precio +
                ", tipoBloqueo='" + tipoBloqueo + '\'' +
                '}';
    }
}
