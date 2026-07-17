package com.Movimientos.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name ="MOVIMIENTOS")
public class Movimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MOVIMIENTOS_SEQ")
    @SequenceGenerator(name = "MOVIMIENTOS_SEQ", sequenceName = "MOVIMIENTOS_SEQ", allocationSize = 1)
    @Column(name = "MOV_ID", columnDefinition = "NUMBER")
    private Integer movId;

    @Column(name = "CUENTA_ID", columnDefinition = "NUMBER")
    private Integer cuentaId;

    @Column( name= "TIPO", columnDefinition = "VARCHAR2(100)")
    private String tipo;

    @Column( name= "FECHA", columnDefinition = "DATE")
    private LocalDate fecha;

    @Column(name = "MONTO", columnDefinition = "NUMBER(8,2)", nullable = true)
    private Double monto;



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
