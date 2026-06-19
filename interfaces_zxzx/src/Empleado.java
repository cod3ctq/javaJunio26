public abstract class Empleado {

    String nombre;
    String fechaNac;
    String domicilio;

    public Empleado(){}

    public Empleado(String nombre, String fechaNac, String domicilio) {
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.domicilio = domicilio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public abstract void trabajar();
}
