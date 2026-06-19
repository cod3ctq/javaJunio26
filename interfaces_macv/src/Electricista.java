public class Electricista extends Empleado implements IElectricidad{
    public Electricista(String nombre, String fechaNac, String domicilio) {
        super(nombre, fechaNac, domicilio);
    }

    public Electricista() {
    }

    @Override
    public void trabajar() {

    }

    @Override
    public void lecturaDiagrama() {

    }

    @Override
    public void medirVoltaje() {

    }

    @Override
    public void colocarContacto() {

    }
}
