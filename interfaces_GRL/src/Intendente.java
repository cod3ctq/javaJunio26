public class Intendente extends Empleado implements IVentas, ILimpiar, IElecticidad {

    @Override
    public void trabajar(){
        System.out.println("Estoy trabajando");
    }

    @Override
    public void sanitizarSalon() {

    }

    @Override
    public void recolectarBasura() {

    }

    @Override
    public void podarPasto() {

    }

    @Override
    public void captarCliente() {

    }

    @Override
    public void ascesorar() {
        System.out.println("asesorando como intendente");
    }

    @Override
    public void generarPresupuesto() {

    }

    @Override
    public void generarCotizacion() {

    }

    @Override
    public void tramitarPedido() {

    }


    @Override
    public void lecturaDiagrama() {

    }

    @Override
    public void medirVoltaje() {

    }

    @Override
    public void colocarEnchufe() {

    }
}
