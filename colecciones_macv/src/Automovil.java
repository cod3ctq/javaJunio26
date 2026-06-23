public class Automovil {
    private String marca;
    private String modelo;
    private int ño;
    private double precio;
    private String tipo;
    private  String color;
    private String transmision;

    public Automovil(String marca, String modelo, int ño, double precio, String tipo, String color, String transmision) {
        this.marca = marca;
        this.modelo = modelo;
        this.ño = ño;
        this.precio = precio;
        this.tipo = tipo;
        this.color = color;
        this.transmision = transmision;
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

    public int getÑo() {
        return ño;
    }

    public void setÑo(int ño) {
        this.ño = ño;
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

    @Override
    public String toString() {
        return "Automovil{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", ño=" + ño +
                ", precio=" + precio +
                ", tipo='" + tipo + '\'' +
                ", color='" + color + '\'' +
                ", transmision='" + transmision + '\'' +
                '}';
    }
}
