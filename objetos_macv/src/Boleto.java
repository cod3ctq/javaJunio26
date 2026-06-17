
// QUE Y COMO
//Modelo o plantilla que describe la estructura y comportamiento de un objeto


import java.time.LocalDate;
import java.util.Date;

//POO:
/*
HERENCIA
ENCAPSULAMIENTO: Proteguer el acceso a los miembros de la clase a traves de modificadores de acceso
ABSTRACCION: sintetizacion de los atributos/caracteristicas relevantes del objeto
POLIMORFISMO: Se refiere a muchas forma DE (objeto, metodo, clase)

 */
public class Boleto {

    //QUE: ATRIBUTOS
    String nombre;
    String origen;
    String destino;
    String tipoServicio;
    LocalDate fechaHoraSalida; //LocalDate a partir de java8
    int IdAutobus;
    double precio;
    int numeroAsiento;


    //Miembros por default
   //metodos
     //constructores: Mecanismo para definir estados y valores iniciales de un objeto (vacio o lleno)
    //siempre lleva el nombre de la clase//
    public Boleto(){//constructor vacio
        // si esta vacio no recibe argumentos y no tiene logicas en su cuerpo

    }

    public Boleto(String nombre, String origen,String destino,String tipoServicio, double precio, int numeroAsiento){//MEEDIO LLENO

    }

    //constructor lleno
    public Boleto(String nombre, String origen, String destino, String tipoServicio, LocalDate fechaHoraSalida, int idAutobus, double precio, int numeroAsiento) {
        this.nombre = nombre;
        this.origen = origen;
        this.destino = destino;
        this.tipoServicio = tipoServicio;
        this.fechaHoraSalida = fechaHoraSalida;
        IdAutobus = idAutobus;
        this.precio = precio;
        this.numeroAsiento = numeroAsiento;
    }

    //getter & setters

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

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        //this apunta a los miembros (atributos o metodos)de instancia
        this.tipoServicio = tipoServicio;
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


    //metodo toString()

    //sirve para transformar a texto el estado del objeto y poder imprimirlo en consola
    @Override
    public String toString() {
        return "Boleto{" +
                "nombre='" + nombre + '\'' +
                ", origen='" + origen + '\'' +
                ", destino='" + destino + '\'' +
                ", tipoServicio='" + tipoServicio + '\'' +
                ", fechaHoraSalida=" + fechaHoraSalida +
                ", IdAutobus=" + IdAutobus +
                ", precio=" + precio +
                ", numeroAsiento=" + numeroAsiento +
                '}';
    }
}
