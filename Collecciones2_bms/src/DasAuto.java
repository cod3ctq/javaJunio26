public class DasAuto {

    //Attributes
    private String marca;
    private String modelo;
    private int ano;
    private double precio;
    private String tipo;
    private String color;
    private String trasmision;


    public DasAuto() {
    }

    public DasAuto(String marca, String modelo, int ano, double precio, String tipo, String color, String trasmision) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.precio = precio;
        this.tipo = tipo;
        this.color = color;
        this.trasmision = trasmision;
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

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
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

    public String getTrasmision() {
        return trasmision;
    }

    public void setTrasmision(String trasmision) {
        this.trasmision = trasmision;
    }

    @Override
    public String toString() {
        return "DasAuto{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", ano=" + ano +
                ", precio=" + precio +
                ", tipo='" + tipo + '\'' +
                ", color='" + color + '\'' +
                ", trasmision='" + trasmision + '\'' +
                '}';
    }
}
