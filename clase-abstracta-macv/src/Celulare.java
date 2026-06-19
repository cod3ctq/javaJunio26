import javax.xml.transform.sax.SAXTransformerFactory;
import java.util.Scanner;

//Clase abstracta: Clase cualquiera ue contiene al menos 1 metodo abstracto
//es toda aquella que contiene etructura y para volverse abstracta debe tener por lo meno una entiad abstracta
public abstract class Celulare {

    //  QUE: atributos
    String marca;
    String modelo;
    double precio;
    String gamma;
    String mAh; //solo por ser un dato demostrativo, no hare calculo con el
    String materiales;

    public Celulare(){}

    public Celulare(String marca, String modelo, double precio, String gamma, String mAh, String materiales) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.gamma = gamma;
        this.mAh = mAh;
        this.materiales = materiales;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getGamma() {
        return gamma;
    }

    public void setGamma(String gamma) {
        this.gamma = gamma;
    }

    public String getmAh() {
        return mAh;
    }

    public void setmAh(String mAh) {
        this.mAh = mAh;
    }

    public String getMateriales() {
        return materiales;
    }

    public void setMateriales(String materiales) {
        this.materiales = materiales;
    }

    @Override
    public String toString() {
        return "Celular{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", precio=" + precio +
                ", gamma='" + gamma + '\'' +
                ", mAh='" + mAh + '\'' +
                ", materiales='" + materiales + '\'' +
                '}';
    }
    //COMO: metodos, comportamiento del objeto
    /*
    Las clases obtienen comportamiento de tres maneras
    1-Metodos nativos(programadso aqui directamente)
    2-metodos heredados (comunmente se sobreescriben)
    3-Metodos implementados ()traidos de interfaces)
     */

    //Llamar, mandarMensajes, guardarContactos


   //Metodo abstracto: metodo que no tiene logica definida (sin especificación)
    public abstract void llamar(String numero);




//    //sobrecarga argumentos
//    public void llamar(String nombre, String compañia){
//
//    }
//    //sobrecarga argumentos
//    public void llamar(String nombre, int saldo){
//
//    }


//Metodos de la forma 1: Nativos
    public abstract void mandarMensaje(String numero, String mensaje);
    public abstract void crearContacto();

    //Sobreescritura: hacer lo mismo pero distinta forma

    //sobrecarga de argumementos: Creacion de varios metodos con el mismo nombre
    //pero distinta cantidad,tipo,orden de los argumentos(forma)







}
