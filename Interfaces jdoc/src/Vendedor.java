public class Vendedor extends Empleado implements IVentas{

    public Vendedor();


    public Vendedor(String nombre, String fechaNac, String domicilio) {
        super(nombre, fechaNac, domicilio);
    }

    @Override
    public String hacerPresupuestos() {
        return "";
    }

    @Override
    public String captarClientes() {
        return "";
    }

    @Override
    public String generarCotizaciones() {
        return "";
    }
}
