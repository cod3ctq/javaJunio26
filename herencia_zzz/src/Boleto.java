import java.time.LocalDate;

//Herencia: Permite reutiliza y/o absorber los miembros de una clase en otra
//Especializacion : Concrecion de clases/modelos alterando la forma o el QUE (atributos)
//Al hacer cualquier clase, ya se esta herendando de Object
public class Boleto {

    Object o;

    String nombre;
    LocalDate fechaHora; //LocalDate a partir de Java8
    double precio;

    public Boleto(){}

    public Boleto(String nombre, LocalDate fechaHora, double precio) {
        this.nombre = nombre;
        this.fechaHora = fechaHora;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDate fechaHora) {
        this.fechaHora = fechaHora;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Boleto{" +
                "nombre='" + nombre + '\'' +
                ", fechaHora=" + fechaHora +
                ", precio=" + precio +
                '}';
    }
}
