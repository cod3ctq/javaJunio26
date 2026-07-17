package com.Movimientos.dto;

import java.time.LocalDate;

public class MovimientoRequest {

    private Integer movId;
    private Integer cuentaId;
    private String tipo;
    private Double monto;
    private LocalDate fecha;

    public MovimientoRequest(Integer movId, Integer cuentaId, String tipo, Double monto, LocalDate fecha) {

        this.movId = movId;
        this.cuentaId = cuentaId;
        this.tipo = tipo;
        this.monto = monto;
        this.fecha = fecha;
    }

    public MovimientoRequest() {
    }

    public Integer getMovId() {
        return movId;
    }

    public void setMovId(Integer movId) {
        this.movId = movId;
    }

    public Integer getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(Integer cuentaId) {
        this.cuentaId = cuentaId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
