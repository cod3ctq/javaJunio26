public class cajaCobro {




    public static double ventaTotal;
    public static int numVenta;

    public double ventaIndividual;

    private String idCaja;
    private String empleado;

    public  cajaCobro(){}

    public cajaCobro(String idCaja, String empleado) {
        this.idCaja = idCaja;
        this.empleado = empleado;
        numVenta++;
    }

    public  void registrarVenta (double total){
        ventaTotal+=total;
        numVenta++;

        ventaIndividual+=total;
    }








    public static double getVentaTotal() {
        return ventaTotal;
    }

    public static void setVentaTotal(double ventaTotal) {
        cajaCobro.ventaTotal = ventaTotal;
    }

    public static int getNumVenta() {
        return numVenta;
    }

    public static void setNumVenta(int numVenta) {
        cajaCobro.numVenta = numVenta;
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

    public double getVentaIndividual() {
        return ventaIndividual;
    }

    public void setVentaIndividual(double ventaIndividual) {
        this.ventaIndividual = ventaIndividual;
    }

    @Override
    public String toString() {
        return "cajaCobro{" +
                "idCaja='" + idCaja + '\'' +
                ", empleado='" + empleado + '\'' +
                '}';
    }
}
