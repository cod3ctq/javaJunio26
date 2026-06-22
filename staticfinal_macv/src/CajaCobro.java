public class CajaCobro {


    // Atributos de clase: reciben su valor desde la propia clase
    public static double ventaGlobal=0.0;
    public static int numVentas=0;


    //Atributos de instancia: Cada instancia decide su valor
    private String idCaja;
    private double ventaIndividual;
    private String empleado;

    public CajaCobro(){}

    public CajaCobro(String idCaja, String empleado) {
        this.idCaja = idCaja;
        this.empleado = empleado;
    }

    public double getVentaIndividual() {
        return ventaIndividual;
    }

    public void setVentaIndividual(double ventaIndividual) {
        this.ventaIndividual = ventaIndividual;
    }

    public static double getventaGlobal() {
        return ventaGlobal;
    }

    public static void setventaGlobal(double ventaGlobal) {
        CajaCobro.ventaGlobal = ventaGlobal;
    }

    public static int getNumVentas() {
        return numVentas;
    }

    public static void setNumVentas(int numVentas) {
        CajaCobro.numVentas = numVentas;
    }

    public String getIdCaja() {
        return idCaja;
    }

    public void setIdCaja(String idCaja) {
        this.idCaja = idCaja;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }
    public void registrarVenta(double total){
        ventaGlobal = ventaGlobal + total;
        numVentas++;

        ventaIndividual = ventaIndividual+total;
    }

    @Override
    public String toString() {
        return "CajaCobro{" +
                "idCaja='" + idCaja + '\'' +
                ", empleado='" + empleado + '\'' +
                '}';
    }
}
