/*
* Herencia
* Encapsulado
* Adstracion
* Polimorfismo
* */

import java.util.Date;
import java.util.Locale;
import java.time.LocalDate;

public class Boleto {

  protected   String nombre;
    String destino;
    String origen;
    String tipoServicio;
    LocalDate ferchaHorario;
    int idAutobus;
    float precio;
    int numeroAsientos;

    //mientras por default
    //constructor: mecanismos para definir estadks y valoles  iniciales de un objeto
    public Boleto(String nombre, String destino, String origen, String tipoServicio, LocalDate ferchaHorario, int idAutobus, float precio, int numeroAsientos) {
        this.nombre = nombre;
        this.destino = destino;
        this.origen = origen;
        this.tipoServicio = tipoServicio;
        this.ferchaHorario = ferchaHorario;
        this.idAutobus = idAutobus;
        this.precio = precio;
        this.numeroAsientos = numeroAsientos;
    }

    public Boleto(String nombre, String destino, LocalDate ferchaHorario, String tipoServicio) {
        this.nombre = nombre;
        this.destino = destino;
        this.ferchaHorario = ferchaHorario;
        this.tipoServicio = tipoServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDestino() {
        return destino;
    }

    public String getOrigen() {
        return origen;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public LocalDate getFerchaHorario() {
        return ferchaHorario;
    }

    public int getIdAutobus() {
        return idAutobus;
    }

    public float getPrecio() {
        return precio;
    }

    public int getNumeroAsientos() {
        return numeroAsientos;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public void setFerchaHorario(LocalDate ferchaHorario) {
        //apuntan a los metodods de la intancia
        this.ferchaHorario = ferchaHorario;
    }

    public void setIdAutobus(int idAutobus) {
        this.idAutobus = idAutobus;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setNumeroAsientos(int numeroAsientos) {
        this.numeroAsientos = numeroAsientos;
    }

    //sirve par aimprimir el estado del objeto
    @Override
    public String toString() {
        return "Boleto{" +
                "nombre='" + nombre + '\'' +
                ", destino='" + destino + '\'' +
                ", origen='" + origen + '\'' +
                ", tipoServicio='" + tipoServicio + '\'' +
                ", ferchaHorario=" + ferchaHorario +
                ", idAutobus=" + idAutobus +
                ", precio=" + precio +
                ", numeroAsientos=" + numeroAsientos +
                '}';
    }
}


