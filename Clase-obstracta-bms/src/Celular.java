import java.util.Scanner;

//QUE:
public class Celular {
    String marca;
    String modelo;
    String gama;
    double precio;
    String mAh; //Solo demostrativo

    //constructor vacio
    public Celular(){}

    //Constructor
    public Celular(String marca, String modelo, String gama, double precio, String mAh) {
        this.marca = marca;
        this.modelo = modelo;
        this.gama = gama;
        this.precio = precio;
        this.mAh = mAh;
    }

    //getters and setters
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

    public String getGama() {
        return gama;
    }

    public void setGama(String gama) {
        this.gama = gama;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getmAh() {
        return mAh;
    }

    public void setmAh(String mAh) {
        this.mAh = mAh;
    }

    //toString
    @Override
    public String toString() {
        return "Celular{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", gama='" + gama + '\'' +
                ", precio=" + precio +
                ", mAh='" + mAh + '\'' +
                '}';
    }

    //Lo de arriba es el QUE

    //COMO: Metodos, comportamiento

    /*
    Las clases obtienen comportamiento de 3 maneras:
    1.-Metodos nativos(programados aqui directamente) surgen dentro de la clase
    2.-Metodos heredados (comunes se sobreescribe)
    3.-Metodos implementados (traidos de interfaces)

    //llamar, mandarMensaje, guardarContactos
     */

    //Metodos de la forma 1: Nativos
    public void llamar(String numero){
        System.out.println("Llamando al "+numero+"... ");
    }

    //Sobrecarga de argumentos
    public void llamar(int numero,String nombre){
        System.out.println("Llamando al "+numero+"... ");
    }

    //Sobrecarga de argumentos
    public void llamar(String numero,String nombre){
        System.out.println("Llamando al "+numero+"... ");
    }


    public void mandarMensaje(String numero, String mensaje){
        System.out.println("Enviando : \n"+mensaje+"al numero: "+numero);
    }

    public void crearContacto(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del contacto: ");
        String nombreContacto = sc.nextLine();
        System.out.print("Ingrese el numero del contacto: ");
        String numeroContacto = sc.nextLine();
        System.out.println("Contacto guardado: "+nombreContacto+"["+numeroContacto+"]");
    }

    //Sobreescritura :Hacer lo mismo pero de distinta FORMA
    //Polimorfico p/e un metodo con diferente numero de argumentos

    /*
    Polimorfismo:
    formas de...

    --Sobrecarga de argumentos: Definir varios metodos con el mismo nombre pero distinta cantidad, orden y tipo de argumentos
    --Sobreescritura: Definir varios metodos en clases distintas, con el mismo nombre y resultado, pero con logicas diferentes

     */

    //Sobrecarga de argumentos : Creacion de varios metodos con el mismo nombre
    //pero distinta cantidad, tipo y orden de los argumentos (FORMA)




}
