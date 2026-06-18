
//  Una clase es un conjunto de que y como
// modelo i plantilla que describe la estructura y compoprta,iento de un objeto


import java.time.LocalDate;
import java.util.Date;

// programacion orientada a objetos cuatro conceptos importantes
/*
Herencia
encapsilamiento   : Proteger a los miembros de la clase a traves de modificadores de acceso
abstraccion : sintetizacion de atributos o caracteristicas relevantes del objeto

polimorfidmo : Muchas formas de
                */
// que atributos del objeto
public class Boleto {

    String nombre;
    String destino;
    String origen;
    String tiposervicio;
    LocalDate fechaHoraSalida;  //Local date a partir de java 8
    int IdAutobus;
    double Precio;
    int numeroAciento;

    // Miembros por defaul
    // constructores: Mecanismo para definir estados y valores iniciales de un objeto
    public Boleto (){  //constructor vacio no recibe argimentos y no tiene logica en su cuerpo

    }


    public Boleto(String nombre, String origen, String destino, String tiposervicio, double precio, int numeroAciento, double precio){
        this.nombre = nombre;
        this.destino = destino;
        this.origen = origen;
        this.tiposervicio= tiposervicio;
        this.Precio= precio;
    }
//constructor lleno
    public Boleto(String nombre, String destino, String origen, String tiposervicio, LocalDate fechaHoraSalida, int idAutobus, int numeroAciento, double precio) {
        this.nombre = nombre;
        this.destino = destino;
        this.origen = origen;
        this.tiposervicio = tiposervicio;
        this.fechaHoraSalida = fechaHoraSalida;
        this.IdAutobus = idAutobus;
        this.numeroAciento = numeroAciento;
        this.Precio = precio;
    }

    // Getter & Setters

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getTiposervicio() {
        return tiposervicio;
    }

    public void setTiposervicio(String tiposervicio) {
        this.tiposervicio = tiposervicio;
    }

    public LocalDate getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    public void setFechaHoraSalida(LocalDate fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }

    public int getIdAutobus() {
        return IdAutobus;
    }

    public void setIdAutobus(int idAutobus) {
        IdAutobus = idAutobus;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }

    public int getNumeroAciento() {
        return numeroAciento;
    }

    public void setNumeroAciento(int numeroAciento) {
        this.numeroAciento = numeroAciento;
    }


    //metodo tiString()
//Sirve para transformara texto el estado del objeto y poder imprimirlo en consola


    @Override
    public String toString() {
        return "Boleto{" +
                "nombre='" + nombre + '\'' +
                ", destino='" + destino + '\'' +
                ", origen='" + origen + '\'' +
                ", tiposervicio='" + tiposervicio + '\'' +
                ", fechaHoraSalida=" + fechaHoraSalida +
                ", IdAutobus=" + IdAutobus +
                ", Precio=" + Precio +
                ", numeroAciento=" + numeroAciento +
                '}';
    }
}
