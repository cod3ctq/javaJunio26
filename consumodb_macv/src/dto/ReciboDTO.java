package dto;

import java.util.Date;

public class ReciboDTO {

    private String referencia;
    private Date fechaeIncio;
    private Date fechaFin;
    private double monto;
    private char status;

    public ReciboDTO(String referencia, Date fechaeIncio, Date fechaFin, double monto, char status) {
        this.referencia = referencia;
        this.fechaeIncio = fechaeIncio;
        this.fechaFin = fechaFin;
        this.monto = monto;
        this.status = status;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Date getFechaeIncio() {
        return fechaeIncio;
    }

    public void setFechaeIncio(Date fechaeIncio) {
        this.fechaeIncio = fechaeIncio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "dto.ReciboDTO{" +
                "referencia='" + referencia + '\'' +
                ", fechaeIncio=" + fechaeIncio +
                ", fechaFin=" + fechaFin +
                ", monto=" + monto +
                ", status=" + status +
                '}';
    }
}
