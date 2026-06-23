public class Automovil {
    private String marca;
    private String modelo;
    private int ago;
    private double precio;
    private String tipo;
    private String color;
    private String transmicion;


    















    public Automovil(String marca, String modelo, int ago, double precio, String tipo, String color, String transmicion) {
        this.marca = marca;
        this.modelo = modelo;
        this.ago = ago;
        this.precio = precio;
        this.tipo = tipo;
        this.color = color;
        this.transmicion = transmicion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAgo() {
        return ago;
    }

    public void setAgo(int ago) {
        this.ago = ago;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTransmicion() {
        return transmicion;
    }

    public void setTransmicion(String transmicion) {
        this.transmicion = transmicion;
    }

    @Override
    public String toString() {
        return "Automovil{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", ago=" + ago +
                ", precio=" + precio +
                ", tipo='" + tipo + '\'' +
                ", color='" + color + '\'' +
                ", transmicion='" + transmicion + '\'' +
                '}';
    }
}
