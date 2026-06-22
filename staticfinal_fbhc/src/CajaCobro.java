public class CajaCobro {


    public static  double ventaGlobal = 0.0;
    public static int numVentas = 0;


    // Atributos de istancia : Cada indstancia decide su valor
    private String idCaja;
    private double ventaIndividual;
    private String empleado;


    public CajaCobro (){}

    public CajaCobro(String empleado, String idCaja) {
        this.empleado = empleado;
        this.idCaja = idCaja;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public String getIdCaja() {
        return idCaja;
    }

    public void setIdCaja(String idCaja) {
        this.idCaja = idCaja;
    }

    public static int getNumVentas() {
        return numVentas;
    }

    public static void setNumVentas(int numVentas) {
        CajaCobro.numVentas = numVentas;
    }

    public static double getVentaGlobal() {
        return ventaGlobal;
    }

    public static void setVentaGlobal(double ventaGlobal) {
        CajaCobro.ventaGlobal = ventaGlobal;
    }

    public void registrarVenta (double total){
        ventaGlobal =ventaGlobal+total;
        numVentas++;

        // contabiliza el monto de las ventas

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
                "empleado='" + empleado + '\'' +
                ", idCaja='" + idCaja + '\'' +
                '}';
    }

}
