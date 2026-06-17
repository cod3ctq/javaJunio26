import java.time.LocalDate;
//HERENCIA PERMITE REUTILIZAR Y/O ABSORBER LOS MIEMBORS DE UNA CLASE A OTRA
//Especializacion: se refiere a la concrecion de clases/modelos alterando la forma o el QUE (atributos)
//Al hacer cualquier  clase, ya se hereda e Object
public class Boleto {
        String nombre;
        LocalDate fechaHora; //LocalDate a partir de java8
        double precio;

        public Boleto(){}
//constructor
    public Boleto(String nombre, LocalDate fechaHora, double precio) {
        this.nombre = nombre;
        this.fechaHora = fechaHora;
        this.precio = precio;
    }
//getter y setters
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
