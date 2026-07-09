package com.ms_tarjeta.dto;

import java.time.LocalDate;

public class TarjetaRequest {

    private int tarjeta;
    private int cuenta;
    private int tipoTarjeta;
    private  String numTarjeta;
    private  String nip;
    private LocalDate fechaVen;
    private String status;

    //Contructor vacio

    public TarjetaRequest() {}

    //Constructor lleno

    public TarjetaRequest(int tarjeta, int cuenta, int tipoTarjeta, String numTarjeta, String nip, LocalDate fechaVen, String status) {
        this.tarjeta = tarjeta;
        this.cuenta = cuenta;
        this.tipoTarjeta = tipoTarjeta;
        this.numTarjeta = numTarjeta;
        this.nip = nip;
        this.fechaVen = fechaVen;
        this.status = status;
    }

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
