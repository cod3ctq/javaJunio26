import java.sql.Date;

public class Movimiento {



    private int movId;
    private int cuentaId;
    private String tipo;
    private Date fecha;
    private double monto;

    //Constructor lleno
    public Movimiento(int movId, int cuentaId, String tipo, Date fecha, double monto) {
        this.movId = movId;
        this.cuentaId = cuentaId;
        this.tipo = tipo;
        this.fecha = fecha;
        this.monto = monto;
    }
     //getters y setters
    public int getMovId() {
        return movId;
    }

    public void setMovId(int movId) {
        this.movId = movId;
    }

    public int getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(int cuentaId) {
        this.cuentaId = cuentaId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    //To String
    @Override
    public String toString() {
        return "Movimiento{" +
                "movId=" + movId +
                ", cuentaId=" + cuentaId +
                ", tipo='" + tipo + '\'' +
                ", fecha=" + fecha +
                ", monto=" + monto +
                '}';
    }
}
