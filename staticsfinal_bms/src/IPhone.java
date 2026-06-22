public class IPhone {

    //Attributes of class: Reciben su valor desde la propia clase (static es para miembros de clase)
    //static + final = Constante
    public static final String SISTEMA_OPERATIVO = "ios"; //( SOLO EN ESTE CASO SE ACEPTA EL _ Y LAS MAYUSCULAS)
    public static String navegador = "Safari";
    public static String fabricante = "Apple";

    //Attributes of instancia: Caja instancia decide su valor
    private double dimensiones;
    private String color;
    private double precio;
    private String tipoBloqueo;


    public IPhone(){
    }

    public IPhone(double dimensiones, String color, double precio, String tipoBloqueo) {
        this.dimensiones = dimensiones;
        this.color = color;
        this.precio = precio;
        this.tipoBloqueo = tipoBloqueo;
    }



    public static String getNavegador() {
        return navegador;
    }

    public static void setNavegador(String navegador) {
        IPhone.navegador = navegador;
    }

    public static String getFabricante() {
        return fabricante;
    }

    public static void setFabricante(String fabricante) {
        IPhone.fabricante = fabricante;
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
        return "IPhone{" +
                "dimensiones=" + dimensiones +
                ", color='" + color + '\'' +
                ", precio=" + precio +
                ", tipoBloqueo='" + tipoBloqueo + '\'' +
                '}';
    }
}
