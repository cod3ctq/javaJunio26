import java.time.LocalDate;

// HERENCIA : Permite reutilizar y/o absorber los miembros de una clase en otra.
// Especialización : Concreción de clases/modelos alterando la forma o el QUÉ (atributos)
public class Boleto {
    String nombre;
    LocalDate fechaHoraSalida; // LocalDate existe a partir de Java 8
    double precio;

    //Constructor vacio
    public Boleto(){}

    //Constructor lleno
    public Boleto(String nombre, LocalDate fechaHoraSalida, double precio) {
        this.nombre = nombre;
        this.fechaHoraSalida = fechaHoraSalida;
        this.precio = precio;
    }

    //Getter y Setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    public void setFechaHoraSalida(LocalDate fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    //Metodo toString()
    @Override
    public String toString() {
        return "Boleto{" +
                "nombre='" + nombre + '\'' +
                ", fechaHoraSalida=" + fechaHoraSalida +
                ", precio=" + precio +
                '}';
    }
}
