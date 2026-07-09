package com.ms_roles.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "ROLES")
public class Roles implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ROL_ID", columnDefinition = "NUMBER")
    private int rolesId;

    @Column(name="DESCRIPCION", columnDefinition = "VARCHAR2(100)")
    private String descripcion;

    @Column(name="SUELDO", columnDefinition = "NUMBER")
    private double sueldo;

    public int getRolId() {
        return rolesId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setRolesIdId(int rolesId) {
        this.rolesId = rolesId;
    }

    public void setDescripcion (String descripcion) {
        this.descripcion = descripcion;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
}
