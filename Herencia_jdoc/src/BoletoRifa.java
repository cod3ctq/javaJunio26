public class BoletoRifa {

    String telefono;
    int numero;

    public BoletoRifa(String telefono, int numero) {
        this.telefono = telefono;
        this.numero = numero;

    }

    public int getNumero() {
        return numero;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "BoletoRifa{" +
                "telefono='" + telefono + '\'' +
                ", numero=" + numero +
                '}';
    }
}
