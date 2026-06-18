import java.util.Scanner;

public class Celular {

    //QUE
    String marca;
    String modelo;
    double precio;
    String gama;
    String mAh; // Solo por ser un dato demostrativo, no se harana matematicas con el
    String materiales;

    public Celular(){}

    //CONSTRUCTOR LLENO
    public Celular(String marca, String modelo, double precio, String gama, String mAh, String materiales) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.gama = gama;
        this.mAh = mAh;
        this.materiales = materiales;
    }

    //GETTER Y SETTER
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

    //METODO toString().
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


    //COMO : Metodos o el comportamiento del objeto, SON LAS ACCIONES QUE REALIZA EL OBJETO.
    /*

    Las clases obtienen comportamiento de 3 maneras:

    1.- Metodos NATIVOS (programados aqui directamente).
    2.- Metodos HEREDADOS (comunmente se sobreescriben).
    3.- Metodos IMPLEMENTADOS (traidos de interfaces).

     */

    //Llamar, mandarMensajes, crearContacto

    //Metodos de la forma 1.- NATIVOS
    public void llamar(String numero){

        System.out.println("Llamando al "+numero+" ...");
    }
    public void llamar(String nombre, String compañia){

    }
    public void llamar(String nombre, int saldo){

    }

    public void mandarMensaje(String numero, String mensaje){
        System.out.println("Enviando: \n"+mensaje+" al numero: "+numero);
    }

    public void crearContacto(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre del contacto");
        String nombreContacto = sc.nextLine();
        System.out.println("Ingrese el numero");
        String numeroContacto  = sc.nextLine();
        System.out.println("Contacto guardado: "+nombreContacto+
                            " ["+numeroContacto+"]");
    }

    // SOBRECARGA DE ARGUMENTOS : Creación de varios metodos con el mismo nombre,
    // pero distinta cantidad, tipo y orden de los argumentos (FORMA) son POLIMORFICOS.






    //SOBREESCRITURA : Hcer lo mismo pero de distinta FORMA


}
