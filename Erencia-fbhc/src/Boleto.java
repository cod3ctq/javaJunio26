import java.time.LocalDate;

public class Boleto {

    // Herencia Permite reutilizar y /0 absorber los miembros de una clase en otra
    //Especializacion : Concrecion de clases o de modelos alterando el que (Son los atributos )

        String nombre;
        LocalDate fechaHora;  //Local date a partir de java 8
        double Precio;

        public Boleto() {


        }

        public Boleto(String nombre, LocalDate fechaHora, double precio) {
            this.nombre = nombre;
            this.fechaHora = fechaHora;
            Precio = precio;
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
            return Precio;
        }

        public void setPrecio(double precio) {
            Precio = precio;
        }

        @Override
        public String toString() {
            return "Boleto{" +
                    "nombre='" + nombre + '\'' +
                    ", fechaHora=" + fechaHora +
                    ", Precio=" + Precio +
                    '}';
        }
    }


