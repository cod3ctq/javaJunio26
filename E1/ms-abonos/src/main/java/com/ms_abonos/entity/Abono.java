package com.ms_abonos.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

//(1)
//Serializacion : Desintegracion en bytes del estado del objeto
//Deserializacion : Reconstruccion del estado del objeto basado en bytes
@Entity
@Table(name="ABONOS")
public class Abono {
    @Id
    @Column(name = "ABONO_ID", columnDefinition = "NUMBER")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int abonoId;
    @Column(name = "PRESTAMO_ID", columnDefinition = "NUMBER")
    private int prestamoId;
    @Column(name = "FECHA", columnDefinition = "DATE")
    private LocalDate fecha;
    @Column(name = "MONTO", columnDefinition = "NUMBER(8,2)")
    private double monto;
    @Column(name = "MEDIO_PAGO", columnDefinition = "NUMBER")
    private int medioPagoId;

    public int getAbonoId() {
        return abonoId;
    }

    public void setAbonoId(int abonoId) {
        this.abonoId = abonoId;
    }

    public int getPrestamoId() {
        return prestamoId;
    }

    public void setPrestamoId(int prestamoId) {
        this.prestamoId = prestamoId;
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

    public int getMedioPagoId() {
        return medioPagoId;
    }

    public void setMedioPagoId(int medioPagoId) {
        this.medioPagoId = medioPagoId;
    }
}
