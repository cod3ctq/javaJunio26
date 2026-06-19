public class Intendente extends Empleado implements ILimpieza, IVentas, IElectricidad {
    /*
    Metodo de la forma 2: Heredados y sobreescrito
    Este metodo refleja un contrato de acciones calcadas desde el Padre
    al ser abstractos, deben ser implementaods TODOS,asi se 1 o mas
    lo cual hace inflexible su uso
     */
    public Intendente(String nombre, String fechaNac, String domicilio) {
        super(nombre, fechaNac, domicilio);
    }

    public Intendente() {
    }

    /*
        Con las interfaces tienes libertad de implemnetar solo aquellas interfaces
        que contengan los metodos que necesitas
        Al estar desacoplado el compartamiento de los atributos, evitmaos el problema
        del diamante, y e simula la multiherencia
         */
    @Override
    public void trabajar() {

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
    public void lecturaDiagrama() {

    }

    @Override
    public void medirVoltaje() {

    }

    @Override
    public void colocarContacto() {

    }

    @Override
    public void captatCliente() {

    }

    @Override
    public void asesorar() {

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
}
