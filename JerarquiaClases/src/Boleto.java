import java.time.LocalDate;

//Herencia: Permite reutilizar y/o absorber los miembros de una clase en otra
//Llevar a cabo la especializacion: Concercion y clases/modelos alterando el QUE: (los atributos)

//Al hacer cualquier clase, ya se esta heredando de Object
//Todo es un objeto
public class Boleto {

    Object o;
    //Attributes
    //Es el QUE: Atributos

    String nombre;
    LocalDate fechaHora;
    double precio;

    //Constructor vacio
    public Boleto(){}

    //Constructor lleno

    public Boleto(String nombre, LocalDate fechaHora, double precio) {
        this.nombre = nombre;
        this.fechaHora = fechaHora;
        this.precio = precio;
    }

    //Getter and Setter
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
