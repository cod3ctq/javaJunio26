import java.time.LocalDate;

public class Ticket {
    private String direccion;
    private LocalDate fecha;
    private String numTarjeta;
    private String concepto;
    private double monto;
    private String folioOperacion;//tipo+incemento

    public Ticket(String direccion, LocalDate fecha, String numTarjeta, String concepto, double monto, String folioOperacion) {
        this.direccion = direccion;
        this.fecha = fecha;
        this.numTarjeta = numTarjeta;
        this.concepto = concepto;
        this.monto = monto;
        this.folioOperacion = folioOperacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
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

    @Override
    public String toString() {
        return "Ticket{" +
                "direccion='" + direccion + '\'' +
                ", fecha=" + fecha +
                ", numTarjeta='" + numTarjeta + '\'' +
                ", concepto='" + concepto + '\'' +
                ", monto=" + monto +
                ", folioOperacion='" + folioOperacion + '\'' +
                '}';
    }
}
