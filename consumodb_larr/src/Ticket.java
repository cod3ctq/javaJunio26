import java.time.LocalDate;

public class Ticket {

    private String dieccion;
    private LocalDate fecha;
    private String numCuenta;
    private String concepto;
    private double monto;
    private String folioOperacion; // tipo + incremento

    //Constructor
    public Ticket(String dieccion, LocalDate fecha, String numCuenta, String concepto, double monto, String folioOperacion) {
        this.dieccion = dieccion;
        this.fecha = fecha;
        this.numCuenta = numCuenta;
        this.concepto = concepto;
        this.monto = monto;
        this.folioOperacion = folioOperacion;
    }

    // Getter y Setter
    public String getDieccion() {
        return dieccion;
    }

    public void setDieccion(String dieccion) {
        this.dieccion = dieccion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getFolioOperacion() {
        return folioOperacion;
    }

    public void setFolioOperacion(String folioOperacion) {
        this.folioOperacion = folioOperacion;
    }


    //Metodo toString()
    @Override
    public String toString() {
        return "Ticket{" +
                "dieccion='" + dieccion + '\'' +
                ", fecha=" + fecha +
                ", numCuenta='" + numCuenta + '\'' +
                ", concepto='" + concepto + '\'' +
                ", monto=" + monto +
                ", folioOperacion='" + folioOperacion + '\'' +
                '}';
    }
}
