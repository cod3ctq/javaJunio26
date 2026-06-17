import java.time.LocalDate;

public class BoletoRifa extends Boleto{

    String telefono;
    int numero;

    //Contructor con argumentos

    public BoletoRifa(String nombre, LocalDate fechaHoraSalida, double precio, String telefono, int numero) {
        super(nombre, fechaHoraSalida, precio);
        this.telefono = telefono;
        this.numero = numero;
    }


    //Getters y Setters

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


    //Metodo toString().

    @Override
    public String toString() {
        return "BoletoRifa{" +
                "telefono='" + telefono + '\'' +
                ", numero=" + numero +
                ", nombre='" + nombre + '\'' +
                ", fechaHoraSalida=" + fechaHoraSalida +
                ", precio=" + precio +
                '}';
    }
}
