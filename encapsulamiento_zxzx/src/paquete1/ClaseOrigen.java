package paquete1;

public class ClaseOrigen {

    public String valor1;
    public String valor2;
    protected int numero1;
    protected int numero2;
    private String texto1;
    private String texto2;

    //private : restringe el acceso solamente para el interior de la clase

    public ClaseOrigen(){}

    public ClaseOrigen(String valor1, String valor2, int numero1, int numero2, String texto1, String texto2) {
        this.valor1 = valor1;
        this.valor2 = valor2;
        this.numero1 = numero1;
        this.numero2 = numero2;
        this.texto1 = texto1;
        this.texto2 = texto2;
    }

    public String getValor1() {
        return valor1;
    }

    public void setValor1(String valor1) {
        this.valor1 = valor1;
    }

    public String getValor2() {
        return valor2;
    }

    public void setValor2(String valor2) {
        this.valor2 = valor2;
    }

    public int getNumero1() {
        return numero1;
    }

    public void setNumero1(int numero1) {
        this.numero1 = numero1;
    }

    public int getNumero2() {
        return numero2;
    }

    public void setNumero2(int numero2) {
        this.numero2 = numero2;
    }

    public String getTexto1() {
        return texto1;
    }

    public void setTexto1(String texto1) {
        this.texto1 = texto1;
    }

    public String getTexto2() {
        return texto2;
    }

    public void setTexto2(String texto2) {
        this.texto2 = texto2;
    }
}
