package com.ddd_ms_persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "ABONOS")
public class Abono implements Serializable {

    @Id
    @Column(name = "ABONO_ID")
    private int abonoId;

    @Column(name = "PRESTAMO_ID")
    private int prestamoId;

    @Column(name = "FECHA")
    private LocalDate fecha;

    @Column(name = "MONTO")
    private double monto;

    @Column(name = "MEDIO_PAGO")
    private int medioPagoId;

    // getters y setters
}