public class Intendente extends Empleado implements ILimpieza, IElectricidad, IVentas{

    //Metodo de la forma 2: Heredado y sobreescrito
    //Este metodo refleja un contrato de acciones calcadas desde el Padre
    //Al ser abstractos, deben ser implementados TODOS, asi sea 1 o más
    //lo cual hace inflexible su uso
    @Override
    public void trabajar() {

    }

    //Con las interfaces tienes libertad de implementar solo aquellas interfaces
    //que contengan los metodos que necesitas
    //Al estar descoplado el comportamiento de los atributos,
    //evitamos el problema del diamante, y se simula la multiherencia
    @Override
    public void leerDiagramas() {

    }

    @Override
    public void medirVoltajes() {

    }

    @Override
    public void colocarEnchufe() {

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
    public void captarClientes() {

    }

    @Override
    public void asesorarVenta() {

    }

    @Override
    public void generarPresupuesto() {

    }

    @Override
    public void generaCotizacion() {

    }

    @Override
    public void tramitarPedido() {

    }
}
