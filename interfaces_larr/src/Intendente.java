public class Intendente extends Empleado implements ILimpieza, IElectricidad, IVentas{

    //Metodo de la forma 2 : HEREDADO Y SOBREESCRITO
    //Este refleja un contrato de acciones calcadas desde el Padre, al ser abstractos, deben ser implementados TODOS, asi
    //sea 1 o mas, lo cual hace inflexible su uso

    @Override
    public void trabajar() {

    }


    //Con las interfaces tienes libertad de implementar sólo aquellas interfaces que contengan los metodos que necesitas
    //al estar desacoplado el comportamiento de los atributos, evitamos el problema del diamante, y se SIMULA multiherencia.


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
    public void lecturaDiagramas() {

    }

    @Override
    public void medirVoltajes() {

    }

    @Override
    public void colocarEnchufe() {

    }

    @Override
    public void captarClientes() {

    }

    @Override
    public void asesorarVentas() {

    }

    @Override
    public void generarPresupuestos() {

    }

    @Override
    public void generarCotizacion() {

    }

    @Override
    public void tramitarPedido() {

    }
}
