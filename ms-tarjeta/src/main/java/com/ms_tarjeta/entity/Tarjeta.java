package com.ms_tarjeta.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name="TARJETAS")
public class Tarjeta implements Serializable{





        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="TARJETA_ID",columnDefinition = "NUMBER")
        private int tarjeta;

        @Column(name="CUENTA_ID",columnDefinition = "NUMBER")
        private int cuenta;

        @Column(name="TIPO_TARJETA_ID",columnDefinition = "NUMBER")
        private int tipoTarjeta;

        @Column(name="NUM_TARJETA",columnDefinition = "CHAR(4)")
        private String numTarjeta;

        @Column(name="NIP",columnDefinition = "CHAR(4)")
        private String nip;

        @Column(name="FECHA_VEN",columnDefinition = "DATE")
        private LocalDate fechaVen ;

        @Column(name="STATUS",columnDefinition = "VARCHAR2(15)")
        private String status;


    public int getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(int tarjeta) {
        this.tarjeta = tarjeta;
    }

    public int getCuenta() {
        return cuenta;
    }

    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }

    public int getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(int tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public LocalDate getFechaVen() {
        return fechaVen;
    }

    public void setFechaVen(LocalDate fechaVen) {
        this.fechaVen = fechaVen;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
