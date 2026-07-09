package models;

import java.time.LocalDate;

public class Tiket {




    private String direccion;
    private LocalDate fecha;
    private String numCuenta;
    private String concepto;
    private double monto;
    private String folioOperacion;     //tipo+incremento


    public Tiket(String direccion, LocalDate fecha, String numCuenta, String concepto, double monto, String folioOperacion) {
        this.direccion = direccion;
        this.fecha = fecha;
        this.numCuenta = numCuenta;
        this.concepto = concepto;
        this.monto = monto;
        this.folioOperacion = folioOperacion;
    }


    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getFolioOperacion() {
        return folioOperacion;
    }

    public void setFolioOperacion(String folioOperacion) {
        this.folioOperacion = folioOperacion;
    }


    @Override
    public String toString() {
        return "models.Tiket{" +
                "direccion='" + direccion + '\'' +
                ", fecha=" + fecha +
                ", numCuenta='" + numCuenta + '\'' +
                ", concepto='" + concepto + '\'' +
                ", monto=" + monto +
                ", folioOperacion='" + folioOperacion + '\'' +
                '}';
    }
}
