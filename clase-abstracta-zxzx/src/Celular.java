import java.util.Scanner;

//Clase abstracta: Clase cualquiera que contiene al menos 1 metodo abstracto
public abstract class Celular {

    //QUE: Atributos
    String marca;
    String modelo;
    double precio;
    String gama;
    String mAh; //Solo por ser un dato demostrativo, no hare matematicas con el
    String materiales;

    public Celular(){}

    public Celular(String marca, String modelo, double precio, String gama, String mAh, String materiales) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.gama = gama;
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

    public String getGama() {
        return gama;
    }

    public void setGama(String gama) {
        this.gama = gama;
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
                ", gama='" + gama + '\'' +
                ", mAh='" + mAh + '\'' +
                ", materiales='" + materiales + '\'' +
                '}';
    }

    //COMO : Metodos , comportamiento
    /*
    Las clases obtienen comportamiento de 3 maneras:
    1- Metodos nativos (programados aqui directamente)
    2- Metodos heredados (comunmente se sobreescriben)
    3- Metodos implementados (traidos de interfaces)
     */

    //llamar, mandarMensajes, guardarContactos

    //Metodo abstracto : Metodo que no tiene logica definida (sin implementacion)
    public abstract void llamar(String numero);
    public abstract void nuevoMetodo();
    public abstract void otroMetodo();

//    //sobrecarga de argumentos
//    public void llamar(String nombre, String compañia){
//
//    }
//    //sobrecarga de argumentos
//    public void llamar(String nombre, int saldo){
//
//    }

    //Metodos de la forma 1: Nativos
    public void mandarMensaje(String numero, String mensaje){
        System.out.println("Enviando : \n"+mensaje+ "al numero: "+numero);
    }

    public void crearContacto(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa el nombre del contacto");
        String nombreContacto = sc.nextLine();
        System.out.println("Ingresa el numero");
        String numeroContacto = sc.nextLine();
        System.out.println("Contacto guardado: "
                +nombreContacto + "["+numeroContacto+"]");
    }

    //Sobreescritura : Hacer lo mismo, pero de distinta FORMA

    //Sobrecarga de argumentos : Creacion de varios metodos con el mismo nombre
    //pero distinta cantidad, tipo y orden de los argumentos (FORMA)












}
