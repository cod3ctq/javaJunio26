public abstract class Empleado {

    String Nombre;
    String fechaNac;
    String domicilio;

    public Empleado() {
    }

    public Empleado(String nombre, String fechaNac, String domicilio) {
        Nombre = nombre;
        this.fechaNac = fechaNac;
        this.domicilio = domicilio;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "Nombre='" + Nombre + '\'' +
                ", fechaNac='" + fechaNac + '\'' +
                ", domicilio='" + domicilio + '\'' +
                '}';
    }

    public abstract void trabajar();
}
