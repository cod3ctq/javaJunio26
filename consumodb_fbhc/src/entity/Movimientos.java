package entity;

import java.sql.Date;

public class Movimientos {
    private int movId;
    private  int cuentaId;
    private String tipo;
    private Date fecha;
    private double monto;


    public Movimientos(int movId,int cuentaId, String tipo, Date fecha, double monto) {
        this.cuentaId = cuentaId;
        this.fecha = fecha;
        this.monto = monto;
        this.movId = movId;
        this.tipo = tipo;
    }


    public int getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(int cuentaId) {
        this.cuentaId = cuentaId;
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

    public int getMovId() {
        return movId;
    }

    public void setMovId(int movId) {
        this.movId = movId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    @Override
    public String toString() {
        return "entity.Movimientos{" +
                "cuentaId=" + cuentaId +
                ", movId=" + movId +
                ", tipo='" + tipo + '\'' +
                ", fecha=" + fecha +
                ", monto=" + monto +
                '}';
    }
}



