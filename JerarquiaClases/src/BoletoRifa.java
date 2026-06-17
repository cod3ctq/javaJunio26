import java.time.LocalDate;

public class BoletoRifa extends Boleto {

    String telefono;
    int numero;

    public BoletoRifa(String nombre, LocalDate fechaHora, double precio, String telefono, int numero) {
        super(nombre, fechaHora, precio);
        this.telefono = telefono;
        this.numero = numero;
    }

    //Getters and Setters
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    //toString
    @Override
    public String toString() {
        return "BoletoRifa{" +
                "telefono='" + telefono + '\'' +
                ", numero=" + numero +
                ", nombre='" + nombre + '\'' +
                ", fechaHora=" + fechaHora +
                ", precio=" + precio +
                '}';
    }
}
