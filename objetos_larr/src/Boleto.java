
//  Una calse es un conjunto de QUÉ y CÓMO.
//Modelo, plantilla que describe la estructura y comportamiento de un objeto.

//POO:

/*
HERENCIA : Permite reutilizar y/o absorber los miembros de una clase en otra.
ENCAPSULAMIENTO : Proteger el acceso a los miembros de la clase a través de modificadores de acceso.
ABSTRACCIÓN : Sintetización de atributos o características relevantes del objeto
POLIMORFISMO : Muchas formas DE
 */

import java.time.LocalDate;

public class Boleto {

    // QUÉ : Atributos

    String nombre;
    String destino;
    String origen;
    String tipoServicio;
    LocalDate fechaHoraSalida; // LocalDate existe a partir de Java 8
    int idAutobus;
    double precio;
    int numeroAsiento;

    //Miembros por default

    //Constructores: Mecanismo para definir estados y valores iniciales de un objeto
    public Boleto(){ //consructor vacio : Porque no recibe argumentos y no tiene lógica en su cuerpo.
    }

    public Boleto(String nombre, String origen, String destino, String tipoServicio,double precio, int numeroAsiento){

    }

    //Constructor lleno
    public Boleto(String nombre, String destino, String origen, String tipoServicio, LocalDate fechaHoraSalida, int idAutobus, double precio, int numeroAsiento) {
        this.nombre = nombre;
        this.destino = destino;
        this.origen = origen;
        this.tipoServicio = tipoServicio;
        this.fechaHoraSalida = fechaHoraSalida;
        this.idAutobus = idAutobus;
        this.precio = precio;
        this.numeroAsiento = numeroAsiento;
    }

    //Getter & Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
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
        //this punta a los miembros (atributos o metodos) de la instancia. Los atributos de instancia de este objeto
        this.tipoServicio = tipoServicio;
    }

    public LocalDate getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    public void setFechaHoraSalida(LocalDate fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }

    public int getIdAutobus() {
        return idAutobus;
    }

    public void setIdAutobus(int idAutobus) {
        this.idAutobus = idAutobus;
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


    //sirve para transformar a texto el estado del objeto y hacer visible el estado del objeto (Imprimirlo).
    @Override
    public String toString() {
        return "Boleto{" +
                "nombre='" + nombre + '\'' +
                ", destino='" + destino + '\'' +
                ", origen='" + origen + '\'' +
                ", tipoServicio='" + tipoServicio + '\'' +
                ", fechaHoraSalida=" + fechaHoraSalida +
                ", idAutobus=" + idAutobus +
                ", precio=" + precio +
                ", numeroAsiento=" + numeroAsiento +
                '}';
    }
}
