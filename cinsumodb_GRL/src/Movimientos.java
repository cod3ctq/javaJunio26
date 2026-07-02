import java.time.LocalDate;

public class Movimientos {
  private int movId;
  private int CuentaId;
  private String tipo;
  private LocalDate fecha;
  private  double monto;


    public Movimientos(int movId, int cuentaId, String tipo, LocalDate fecha, double monto) {
        this.movId = movId;
        CuentaId = cuentaId;
        this.tipo = tipo;
        this.fecha = fecha;
        this.monto = monto;
    }

    public int getMovId() {
        return movId;
    }

    public void setMovId(int movId) {
        this.movId = movId;
    }

    public int getCuentaId() {
        return CuentaId;
    }

    public void setCuentaId(int cuentaId) {
        CuentaId = cuentaId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "movimientos{" +
                "movId=" + movId +
                ", CuentaId=" + CuentaId +
                ", tipo='" + tipo + '\'' +
                ", fecha=" + fecha +
                ", monto=" + monto +
                '}';
    }
}
