package com.ddd_ms_persistence.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "ROLES")
public class Roles implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROL_ID")
    private int rolId;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "SUELDO")
    private double sueldo;

    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
}
