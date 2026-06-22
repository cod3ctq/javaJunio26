public abstract class Empleado {


    String nombre;
    String fechaNac;
    String domicilio;

    public Empleado() {
    }

    public Empleado(String domicilio, String fechaNac, String nombre) {
        this.domicilio = domicilio;
        this.fechaNac = fechaNac;
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "domicilio='" + domicilio + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fechaNac='" + fechaNac + '\'' +
                '}';
    }
}
