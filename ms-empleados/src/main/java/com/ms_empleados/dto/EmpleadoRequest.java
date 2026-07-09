package com.ms_empleados.dto;

import java.time.LocalDate;
import java.util.Date;

public class EmpleadoRequest {

    private int empleadosId;
    private  int rolId;
    private String nombre;
    private String apP;
    private String apM;
    private LocalDate fechaIn;
    private String correo;
    private String telefono;
    private String status;

    public EmpleadoRequest(){}

    public EmpleadoRequest(int empleadosId, int rolId, String nombre, String apP, String apM, LocalDate fechaIn, String correo, String telefono, String status) {
        this.empleadosId = empleadosId;
        this.rolId = rolId;
        this.nombre = nombre;
        this.apP = apP;
        this.apM = apM;
        this.fechaIn = fechaIn;
        this.correo = correo;
        this.telefono = telefono;
        this.status = status;
    }

    public int getEmpleadosId() {
        return empleadosId;
    }

    public int getRolId() {
        return rolId;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApP() {
        return apP;
    }

    public String getApM() {
        return apM;
    }

    public LocalDate getFechaIn() {
        return fechaIn;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getStatus() {
        return status;
    }

    public void setEmpleadosId(int empleadosId) {
        this.empleadosId = empleadosId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApP(String apP) {
        this.apP = apP;
    }

    public void setApM(String apM) {
        this.apM = apM;
    }

    public void setFechaIn(LocalDate fechaIn) {
        this.fechaIn = fechaIn;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}



