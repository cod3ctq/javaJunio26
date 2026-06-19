import java.util.Scanner;

public abstract class Celular {
// QUE
    String marca;
    String modelo;
    double precio;
    String gama;
    String mAh; // aolo poe ser un dato demostrativo, no hare matematicas con el
    String materiales;

    //Clase abstracta

    public Celular(String marca, String modelo, double precio, String gama, String mAh, String materiales) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.gama = gama;
        this.mAh = mAh;
        this.materiales = materiales;
    }
    public Celular(){}

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public String getGama() {
        return gama;
    }

    public String getmAh() {
        return mAh;
    }

    public String getMateriales() {
        return materiales;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setGama(String gama) {
        this.gama = gama;
    }

    public void setmAh(String mAh) {
        this.mAh = mAh;
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

    //COMO: Metodos, COMPORTAMIENTO
    /*
    Las clases obtienen comportamiento de 3 maneras:
    1.- Metodos nativos (programados aqui directamente)
    2.- Metodos heredados (comunmente se sobreescriben)
    3.-Metodos implementados (traido d einterfaces)
     */

    // 1.-METODOS NATIVOS: llamar, mandarMesajes, guardaContactos,
    //Metodo abstarcto: Metodo que no tiene logica definida ( sin implementacion )
    public abstract void llamar(String numero);




//    public void llamar(String numero, String compañia){
//        System.out.println("lalmando al"+numero+"....");
//
//    }
//    public void llamar(String numero, String compañia, int saldo){
//        System.out.println("lalmando al"+numero+"....");
//
//    }
    public void mandarMensaje(String numero, String mensaje){
        System.out.println("Enviando :"+ mensaje+"al numero:"+numero);

    }
    public void crearContacto (){
        Scanner sc = new Scanner(System.in);
        System.out.println("ingrese el nombre del contacto");
        String nombreContacto = sc.nextLine();
        System.out.println("Ingrese el numero");
        String numeroContacto = sc.nextLine();
        System.out.println("Contacto guardado:" + numeroContacto+"["+numeroContacto+"]");

        //Sobreescritura : hacer lo mismo, pero de sitita Forma

        //Sobrecarga de argumentos :Creacion de varios metodoa con el mismo nombre
        // pero distinta cantidad, tipo y orden de los argumentos (FORMA)



    }


}
