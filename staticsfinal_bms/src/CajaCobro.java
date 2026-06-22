public class CajaCobro {

    //Attributes of class: Reciben su valor desde la propia clase (static es para miembros de clase)
    public static double ventaGlobal = 0.0;
    public static int numVentas = 0;

    //Attributes of instancia: Caja instancia decide su valor
    private String isCaja;
    private double ventaIndividual;
    private String empleado;

    public CajaCobro(){ }

    public CajaCobro(String isCaja, String empleado) {
        this.isCaja = isCaja;
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

    public String getIsCaja() {
        return isCaja;
    }

    public void setIsCaja(String isCaja) {
        this.isCaja = isCaja;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public void registrarVenta(double total){
        ventaGlobal += total;
        numVentas++;

        ventaIndividual+=total;
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
                "isCaja='" + isCaja + '\'' +
                ", empleado='" + empleado + '\'' +
                '}';
    }


}
