
//Que y como
//Modelo o una plantilla que describe la estructura y comprtamento de un objetO

import java.time.LocalDate;
import java.util.Date;
// QUE Y COMO
//Modelo, plantilla que describe la estructura y comportanieto de un objeto|
//poo:
/*
HERENCIA
ENCAPSULAMIENTO: Proteger los miembros de la calse a travez de modificadores de acceso
ABSTRACCION:Sintetizacion de los atrivutos o caracteristicas relevantes de los objetos
POLIFORMISMO:se refiere a que hay muchas formas "DE"
 */
public class Boleto {
    //QUE : ATRIBUTOS
    String nombre;
    String  destino;
    String origen;
    String tipoServicio;
    LocalDate  frcha; // LocalDate existe a partir de java8
    int IdAdultos;
    double Precio;
    int numeroAsiento;


    // Miembros por default
    // Constructores: mecanismo para definir esatados y valores iniciales del objeto
    public Boleto(){  // CONSTRUCTOR VACIO

    }

    public Boleto(String nombre, String origen, String tipoServicio, double precio, int numeroAsiento){  //casi lleno      {


    // Constructor lleno

    public Boleto(String nombre, String destino, String origen, String tipoServicio, LocalDate frcha, int idAdultos, double precio, int numeroAsiento) {
        this.nombre = nombre;
        this.destino = destino;
        this.origen = origen;
        this.tipoServicio = tipoServicio;
        this.frcha = frcha;
        IdAdultos = idAdultos;
        Precio = precio;
        this.numeroAsiento = numeroAsiento;
    }

    //Getter & setters

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
        this.tipoServicio = tipoServicio;
    }

    public LocalDate getFrcha() {
        return frcha;
    }

    public void setFrcha(LocalDate frcha) {
        this.frcha = frcha;
    }

    public int getIdAdultos() {
        return IdAdultos;
    }

    public void setIdAdultos(int idAdultos) {
        IdAdultos = idAdultos;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }

    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(int numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    //metodo toString
    // sirve para trasformar a texto el esatdo del obejeto y pode rimprimir en consola

    @Override
    public String toString() {
        return "Boleto{" +
                "nombre='" + nombre + '\'' +
                ", destino='" + destino + '\'' +
                ", origen='" + origen + '\'' +
                ", tipoServicio='" + tipoServicio + '\'' +
                ", frcha=" + frcha +
                ", IdAdultos=" + IdAdultos +
                ", Precio=" + Precio +
                ", numeroAsiento=" + numeroAsiento +
                '}';
    }
}




