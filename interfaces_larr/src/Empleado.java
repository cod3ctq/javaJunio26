

public abstract class Empleado {

    // QUE
    String nombre;
    String fechaNac;
    String domimcilio;

    // Contructor vacio

    public Empleado(){};

    //Constructor lleno

    public Empleado(String nombre, String fechaNac, String domimcilio) {
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.domimcilio = domimcilio;
    }


    // Getter y Setter

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

    public String getDomimcilio() {
        return domimcilio;
    }

    public void setDomimcilio(String domimcilio) {
        this.domimcilio = domimcilio;
    }


    //Metodo toString()


    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", fechaNac='" + fechaNac + '\'' +
                ", domimcilio='" + domimcilio + '\'' +
                '}';
    }


    public abstract void trabajar();

}
