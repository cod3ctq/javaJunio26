public class CajaCobro {

    //Atributos de clase : Reciben su valor desde la propia clase
    public static double ventaGlobal=0.0;
    public static int numVentas = 0;

    //Atributos de instancia : Cada instancia decide su valor
    private String idCaja;
    private double ventaIndividual;
    private String empleado;

    public CajaCobro(){}

    public CajaCobro(String idCaja, String empleado) {
        this.idCaja = idCaja;
        this.empleado = empleado;
    }

    public static double getVentaGlobal() {
        return ventaGlobal;
    }

    public static void setVentaGlobal(double ventaGlobal) {
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

        //contabiliza el monto de las ventas por cada caja
        ventaIndividual = ventaIndividual + total;
    }

    public double getVentaIndividual() {
        return ventaIndividual;
    }

    public void setVentaIndividual(double ventaIndividual) {
        this.ventaIndividual = ventaIndividual;
    }

    @Override
    public String toString() {
        return "CajaCobro{" +
                "idCaja='" + idCaja + '\'' +
                ", empleado='" + empleado + '\'' +
                '}';
    }
}
