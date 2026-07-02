import java.sql.Date;

public class Movimiento {

    private int movID;
    private int cuentaId;
    private String tipo;
    private Date fecha;
    private double monto;


    public Movimiento(int movID, int cuentaId, String tipo, Date fecha, double monto) {
        this.movID = movID;
        this.cuentaId = cuentaId;
        this.tipo = tipo;
        this.fecha = fecha;
        this.monto = monto;
    }

    public int getMovID() {
        return movID;
    }

    public int getCuentaId() {
        return cuentaId;
    }

    public String getTipo() {
        return tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMovID(int movID) {
        this.movID = movID;
    }

    public void setCuentaId(int cuentaId) {
        this.cuentaId = cuentaId;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Movimiento{" +
                "movID=" + movID +
                ", cuentaId=" + cuentaId +
                ", tipo='" + tipo + '\'' +
                ", fecha=" + fecha +
                ", monto=" + monto +
                '}';
    }
}
