public class Intendente extends Empleado implements IVentas,IElectricidad,ILimpieza{
    /*
    Metodo de la forma 2: Heredado y sobreescrito
    Este metodo refleja un contrato de acciones calcadas desde el padre al ser abstracto, deben ser implementados TODOS, asi sia 1 o mas lo cual hace inflexiable su uso
     */

    @Override
    public void trabajo() {

    }

    @Override
    public void lecturaDiagramas() {

    }

    @Override
    public double medidorVoltajes() {
        return 0;
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
    public void PodarPasto() {

    }

    @Override
    public void captarClientes() {

    }

    @Override
    public void asesoramiento() {

    }

    @Override
    public void generarPresupuestos() {

    }

    @Override
    public void generarCotizacion() {

    }

    @Override
    public void tramitaPerdido() {

    }

    /*
    Con las interfaces tiene libertad de implementar solo aquellas interfaces que contengan los metodos que necesitas.
    Al estar descoplado el comportamiento de los atributos, evitamos el problema del diamante, y se simila la multiherencia

     */
}
