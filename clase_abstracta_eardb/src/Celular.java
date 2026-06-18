import java.util.Scanner;

public class Celular {
    String marca;
    String modelo;
    double precio;
    String gama;
    String mAh;
    String materiales;
    public  Celular(){

    }
    public Celular(String marca, double precio, String modelo, String gama, String mAh, String materiales) {
        this.marca = marca;
        this.precio = precio;
        this.modelo = modelo;
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
    //COMO : METODOS, COMPORTAMIENTO
    /*
    LAS CLASES OBTIENEN COMPORTAMIENTO DE 3 MANERAS
    1-> METODOS NATIVOS(PROGRAMAS AQUI DIRECTAMENTE)
    2-> METODOS HEREDADOS(COMUNMNETE SE SOBREESCRIBREN)
    3-> METODOS IMPLEMENTADOS(TRAIDOS DE INTERFACES)
    */
    // LLAMAR, MANDAR_MENSAJE, GUARDA_CONTACTOS
    // METODOS DE LA FORMA 1
    public void llamar(String numero){
        System.out.println("llmando al "+numero+"----");
    }
    //SOBRE CARGA DE ARGUMENTO
    public void llamar(String nombre, String compañia){

    }

    public void mandarMensaje(String numero, String mensaje){
        System.out.println("enviando"+mensaje+"al numero"+numero);
    }
    public void crearContacto(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Ingresa el nombre del contacto");
        String nombreContacto = sc.nextLine();
        System.out.println("Ingrese el numero");
        String numeroContacto = sc.nextLine();
        System.out.println("Contacto Guardado: "+nombreContacto+ "["+numeroContacto+"]");

    }
    //SOBRE ESCRITURA HACER LO MISMO, PERO DE DISTINTA FOMRA

    //SOBRECARGA DE ARGUMENTOS : CREACION DE VARIOS METODOS CON EL MISMO NOMBRE
    //PERO DISTINTA, TIPO Y ORDEN DE ARGUMENTOS (FORMA)






}
