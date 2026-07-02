import java.sql.Date;

public class Movimiento {


    private int mov_Id;
    private int cuentaId;
    private String tipo;
    private Date fecha;
    private Double monto;

    public Movimiento(int mov_Id, int cuentaId, String tipo, Date fecha, Double monto) {
        this.mov_Id = mov_Id;
        this.cuentaId = cuentaId;
        this.tipo = tipo;
        this.fecha = fecha;
        this.monto = monto;
    }

    public int getMov_Id() {
        return mov_Id;
    }

    public void setMov_Id(int mov_Id) {
        this.mov_Id = mov_Id;
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

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Movimiento{" +
                "mov_Id=" + mov_Id +
                ", cuentaId=" + cuentaId +
                ", tipo='" + tipo + '\'' +
                ", fecha=" + fecha +
                ", monto=" + monto +
                '}';
    }
}
