public abstract class Empleado {
    //Attributes
    String name;
    String fechaNac;
    String domicilio;


    //Constrctor vacio
    public Empleado(){

    }

    //Constractor lleno
    public Empleado(String name, String fechaNac, String domicilio) {
        this.name = name;
        this.fechaNac = fechaNac;
        this.domicilio = domicilio;
    }

    //Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    //to String


    @Override
    public String toString() {
        return "Empleado{" +
                "name='" + name + '\'' +
                ", fechaNac='" + fechaNac + '\'' +
                ", domicilio='" + domicilio + '\'' +
                '}';
    }

    public abstract void trabajo();
}


