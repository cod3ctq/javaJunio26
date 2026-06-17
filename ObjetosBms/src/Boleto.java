//Un conjunto de que y como
//Modelo, plantila que describe la estructura y comportamineto de un objeto

import java.time.LocalDate;

//POO:  Es pregunta de entrevista
/*
HERENCIA
ENCAPSULAMIENTO: Proteger el acceso a los mienbros de la clase a traves de modificadores de acceso
ABSTRACION: Sintetizacion de los atributos/caracteristicas reelevantes del objeto
POLIMORFISMO: Muchas formas DE

La recursividad es la capacidad de un proceso, función o concepto de definirse, contenerse o aplicarse a sí mismo

Los metodos getter deben definir el tipo de retorno despues de la palabra public el cual depende del valor devuelto en el return

Un getterno puede retornar void

Precado: significa obsoleto

 */

public class Boleto {
    //Attributes

    //Es el QUE: Atributos

    //nombre
    String nombre;
    //destino
    String destino;
    //origen
    String origen;
    //tipoServicio
    String tipoServicio;
    //fecha (la clase Locas existe apartir de java 8 y sustituye la clase Date)
    LocalDate fechaHoraSalida;
    //IdAutobus
    int IdAutobus;
    //precio
    double precio;
    //numeroAsiento
    int numeroAsiento;


    //Miembros por default
    //Constructores: Mecanismos para definir estados y valores iniciales de un objeto
    public Boleto(){//Constructor vacio
        //No recibe argumentos y no tiene logica en su cuerpo

    }

    //Contructor lleno

    public Boleto(String nombre, String destino, String origen, String tipoServicio, LocalDate fechaHoraSalida, int idAutobus, double precio, int numeroAsiento) {
        this.nombre = nombre;
        this.destino = destino;
        this.origen = origen;
        this.tipoServicio = tipoServicio;
        this.fechaHoraSalida = fechaHoraSalida;
        IdAutobus = idAutobus;
        this.precio = precio;
        this.numeroAsiento = numeroAsiento;
    }


    //Getter & Setters

    //Encapsulamiento
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        //this. apunta a los miembros(atributos o metodos) de instancia
        this.nombre = nombre;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public LocalDate getFechaHoraSalida(LocalDate now) {
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
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(int numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }


    //metodos toString()
    @Override
    public String toString() {
        return "Boleto{" +
                "nombre='" + nombre + '\'' +
                ", destino='" + destino + '\'' +
                ", origen='" + origen + '\'' +
                ", tipoServicio='" + tipoServicio + '\'' +
                ", fechaHoraSalida=" + fechaHoraSalida +
                ", IdAutobus=" + IdAutobus +
                ", precio=" + precio +
                ", numeroAsiento=" + numeroAsiento +
                '}';
    }
}
