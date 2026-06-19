import java.time.LocalDate;

public class Empleado {
    String nombre;
    LocalDate brithdate;
    String  domicilio;

    public Empleado() {
    }

    public Empleado(String nombre, LocalDate brithdate, String domicilio) {
        this.nombre = nombre;
        this.brithdate = brithdate;
        this.domicilio = domicilio;
    }

    public void  trabajar(){
        System.out.println("Estoy trabajado");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getBrithdate() {
        return brithdate;
    }

    public void setBrithdate(LocalDate brithdate) {
        this.brithdate = brithdate;
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
                "nombre='" + nombre + '\'' +
                ", brithdate=" + brithdate +
                ", domicilio='" + domicilio + '\'' +
                '}';
    }
}
