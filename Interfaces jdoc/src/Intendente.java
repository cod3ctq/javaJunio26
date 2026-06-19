public class Intendente extends Empleado implements ILimpieza,IElectricidad,IVentas {



    //Metodo de la forma 2: herdedado y sobreescrito
    //Este metodo refleja un contrato de acciones celacadas desde le padre
    //Al ser abstracto, deben ser implementados TODOS, asi sea 1 o mas
    //Lo cual haceinflexible su uso


    public Intendente() {
    }

    public Intendente(String nombre, String fechaNac, String domicilio) {
        super(nombre, fechaNac, domicilio);


    }

    @Override
    public String trabajar() {
        return "";
    }

    @Override
    public String leerDiagramas() {
        return "";
    }

    @Override
    public String medirVoltaje1() {
        return "";
    }

    @Override
    public String sanitizarSalon() {
        return "";
    }

    @Override
    public String recolectarBasura1() {
        return "";
    }

    @Override
    public String podarPastor() {
        return "";
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

