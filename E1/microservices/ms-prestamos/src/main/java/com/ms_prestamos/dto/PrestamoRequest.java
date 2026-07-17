package com.ms_prestamos.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;

import java.sql.Date;
import java.time.LocalDate;

public class PrestamoRequest {

    private int prestamoId;

    @NotNull(message ="Este valor no puede quedar vacio")
    private int tipoId;
    @NotBlank(message ="El RFC no puede quedar vacio o nulo")
    @Size(max = 13, min = 13, message = "El RFC debe tener 13 caracteres")
    private String rfc;//revive el RFC

    //ya no sera necesario incluirla en el request dad0 que se toma de sitema
    //private LocalDate fecha;

    @NotNull(message = "Este valor no puede quedar vacio")
    @Positive(message = "Este valor no puede ser menor a cero")
    private double monto;

    @NotNull(message = "Este valor no puede quedar vacio")
    @Future(message = "La fecha de fin debe de ser del futuro")
    private LocalDate fechaFin;//Depemde del tipo de prestamo

    //private double restante;

    // Constructor vacio
    public PrestamoRequest() {
    }

    // Constructor lleno

    public PrestamoRequest(int prestamoId, int tipoId, String rfc, double monto, LocalDate fechaFin) {
        this.prestamoId = prestamoId;
        this.tipoId = tipoId;
        this.rfc = rfc;
        this.monto = monto;
        this.fechaFin = fechaFin;
    }


    // Getter y Setter

    public int getPrestamoId() {
        return prestamoId;
    }

    public int getTipoId() {
        return tipoId;
    }

    public String getRfc() {
        return rfc;
    }

    public double getMonto() {
        return monto;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setPrestamoId(int prestamoId) {
        this.prestamoId = prestamoId;
    }

    public void setTipoId(int tipoId) {
        this.tipoId = tipoId;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }
}
