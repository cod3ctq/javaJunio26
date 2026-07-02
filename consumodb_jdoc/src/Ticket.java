import java.time.LocalDate;

public class Ticket {

    private String direcion;
    private LocalDate fecha;
    private String numCuenta;
    private String concepto;
    private double monto;
    private String folioOperacion; //tipo+incremento

    public Ticket(String direcion, LocalDate fecha, String numCuenta, String concepto, double monto, String folioOperacion) {
        this.direcion = direcion;
        this.fecha = fecha;
        this.numCuenta = numCuenta;
        this.concepto = concepto;
        this.monto = monto;
        this.folioOperacion = folioOperacion;
    }

    public String getDirecion() {
        return direcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public String getConcepto() {
        return concepto;
    }

    public double getMonto() {
        return monto;
    }

    public String getFolioOperacion() {
        return folioOperacion;
    }

    public void setDirecion(String direcion) {
        this.direcion = direcion;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public void setFolioOperacion(String folioOperacion) {
        this.folioOperacion = folioOperacion;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "direcion='" + direcion + '\'' +
                ", fecha=" + fecha +
                ", numCuenta='" + numCuenta + '\'' +
                ", concepto='" + concepto + '\'' +
                ", monto=" + monto +
                ", folioOperacion='" + folioOperacion + '\'' +
                '}';
    }
}
