import java.util.Scanner;

public class celular {
    String marca;
    String modelo;
    int precio;
    String gama;
    String mAh;
    String materiales;

    public celular(String marca, String modelo, int precio, String gama, String mAh, String materiales) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.gama = gama;
        this.mAh = mAh;
        this.materiales = materiales;
    }

    public celular() {
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

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
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
        return "celular{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", precio=" + precio +
                ", gama='" + gama + '\'' +
                ", mAh='" + mAh + '\'' +
                ", materiales='" + materiales + '\'' +
                '}';
    }

    //Como: metodos, comportamiento

    //Las clases obtienen comportamiento de tres maneras
   // 1 ,metodos nativos (programados aqui directamente
    //2 metodos eredados (comunmente se sobrescriben)
    //3 Metodos implementados




    // llamar, mandarMensajes, guardaContactos,

    // Metodo 1 la forma : Nativo

    public  void llamar(String numero){

        System.out.println("Lamando al "+numero+".....");

    }


    public void llamar (String nombre, String compañia){

    }

    //Sobrecarga de argumentos
    public void llamar (String nombre, int saldo){

    }

    public void mandarMensaje (String numero, String mensaje){
        System.out.println("Enviando : "+mensaje+"al numero"+numero);
    }

    public void crearContacto(){
        Scanner sc = new Scanner(System.in);
        System.out.println("ingrese el nombre del contacto");
        String nombreContacto = sc.nextLine();
        System.out.println("Ingrese el numero");
        String  numeroContacto = sc.nextLine();
        System.out.println("Contacto guardado: "+nombreContacto+"["+numeroContacto+"]");

    }

    // Sobrecarga de argumentos
}


