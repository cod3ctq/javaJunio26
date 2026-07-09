package com.ms_empleados.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "EMPLEADOS")
public class Empleados implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMPLEADO_ID", columnDefinition = "NUMBER")
    private int empleadosId;

    @Column(name = "ROL_ID", columnDefinition = "NUMBER")
    private int rolId;

    @Column(name = "NOMBRE", columnDefinition = "VARCHAR2(100)")
    private String nombre ;

    @Column(name = "AP_P", columnDefinition = "VARCHAR2(100)")
    private String apP ;

    @Column(name = "AP_M", columnDefinition = "VARCHAR2(100)")
    private String apA ;

    @Column(name = "FECHA_IN", columnDefinition = "DATE")
    private LocalDate fechaIn ;

    @Column(name = "CORREO", columnDefinition = "VARCHAR2(100)")
    private String correo ;

    @Column(name = "TEL", columnDefinition = "CHAR(10)")
    private String telefono;

    @Column(name = "STATUS", columnDefinition = "VARCHAR2(50)")
    private String status ;

    public int getEmpleadosId(){
        return empleadosId;
    }

    public int getRolId(){return rolId;}

    public String getNombre(){return nombre;}

    public String getApP(){return apP;}

    public String getApA(){return apA;}

    public LocalDate getFechaIn(){return fechaIn;}

    public String getCorreo(){return correo;}

    public String getTelefono(){return telefono;}

    public String getStatus(){return status;}

    public void setEmpleadosId(int empleadosId){this.empleadosId=empleadosId;}

    public void setRolId(int empleadosId){this.rolId=rolId;}

    public void setNombre(String nombre){this.nombre=nombre;}

    public void setApP(String apP){this.apP=apP;}

    public void setApA(String apA){this.apA=apA;}

    public void setFechaIn(LocalDate fechaIn){this.fechaIn=fechaIn;}

    public void setCorreo(String correo){this.correo=correo;}

    public void setTelefono(String telefono){this.telefono=telefono;}

    public void setStatus(String status){this.status=status;}















}
