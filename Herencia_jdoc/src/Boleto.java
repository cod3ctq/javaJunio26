import java.time.LocalDate;
// Permite reutilizar  y/o absorber los miembreos de una calase en otra
// llevar a cabo la especializacion:
//Especializacion: ccreacion de clases/modelos alteralndo la forma o el Que (son los atributos)
// Al hacer cualquier clase, ya se esat heredando de un objeto

public class Boleto {
    String tipoServicio;
    LocalDate fechaHora; // LocalDate existe a partir de java8
    double Precio;

    public Boleto(String tipoServicio, LocalDate fechaHora, double precio) {
        this.tipoServicio = tipoServicio;
        this.fechaHora = fechaHora;
        Precio = precio;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public LocalDate getFechaHora() {
        return fechaHora;
    }

    public double getPrecio() {
        return Precio;
    }


    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public void setFechaHora(LocalDate fechaHora) {
        this.fechaHora = fechaHora;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }

    @Override
    public String toString() {
        return "Boleto{" +
                "tipoServicio='" + tipoServicio + '\'' +
                ", fechaHora=" + fechaHora +
                ", Precio=" + Precio +
                '}';
    }
}

