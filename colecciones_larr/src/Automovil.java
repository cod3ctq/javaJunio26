public class Automovil {

    private String marca;
    private String modelo;
    private int año;
    private double precio;
    private String tipo;
    private String color;
    private String transmision;

    //Constructor lleno
    public Automovil(String marca, String modelo, int año, double precio, String tipo, String color, String transmision) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.precio = precio;
        this.tipo = tipo;
        this.color = color;
        this.transmision = transmision;
    }


    //Getter y Setter
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

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
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

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }


    //Metodo toString()
    @Override
    public String toString() {
        return "Automovil{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", año=" + año +
                ", precio=" + precio +
                ", tipo='" + tipo + '\'' +
                ", color='" + color + '\'' +
                ", transmision='" + transmision + '\'' +
                '}';
    }
}
