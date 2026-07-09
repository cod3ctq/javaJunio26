package com.ms_roles.dto;

public class RolesRequest {
    private int rolId;
    private String descripcion;
    private double sueldo;

    public RolesRequest(){}

    public RolesRequest(int rolId, String descripcion, double sueldo) {
        this.rolId = rolId;
        this.descripcion = descripcion;
        this.sueldo = sueldo;
    }

    public int getRolId() {
        return rolId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
}
