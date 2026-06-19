import java.util.Arrays;
import java.util.Scanner;

public class SmartPhone extends Celulare implements IFuncionesInteligentes {


    boolean spen;
    String sistemaOperativo;
    boolean cargaInalambrica;
    int almacenamiento;

    //Atributos mas complejos que que los anteriores
    String[] conectividad;
    Pantalla pantalle;
    Camara[] camara;


    //COMPOSICION: Define una relacion 'TIENE UN'


    public SmartPhone(String marca, String modelo, double precio, String gamma, String mAh, String materiales, boolean spen, String sistemaOperativo, boolean cargaInalambrica, int almacenamiento, String[] conectividad, Pantalla pantalle, Camara[] camara) {
        super(marca, modelo, precio, gamma, mAh, materiales);
        this.spen = spen;
        this.sistemaOperativo = sistemaOperativo;
        this.cargaInalambrica = cargaInalambrica;
        this.almacenamiento = almacenamiento;
        this.conectividad = conectividad;
        this.pantalle = pantalle;
        this.camara = camara;
    }

    public boolean isSpen() {
        return spen;
    }

    public void setSpen(boolean spen) {
        this.spen = spen;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public boolean isCargaInalambrica() {
        return cargaInalambrica;
    }

    public void setCargaInalambrica(boolean cargaInalambrica) {
        this.cargaInalambrica = cargaInalambrica;
    }

    public int getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(int almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public String[] getConectividad() {
        return conectividad;
    }

    public void setConectividad(String[] conectividad) {
        this.conectividad = conectividad;
    }

    public Pantalla getPantalle() {
        return pantalle;
    }

    public void setPantalle(Pantalla pantalle) {
        this.pantalle = pantalle;
    }

    public Camara[] getCamara() {
        return camara;
    }

    public void setCamara(Camara[] camara) {
        this.camara = camara;
    }
    @Override
    public String toString() {
        return "SmartPhone{" +
                "spen=" + spen +
                ", sistemaOperativo='" + sistemaOperativo + '\'' +
                ", cargaInalambrica=" + cargaInalambrica +
                ", almacenamiento=" + almacenamiento +
                ", conectividad=" + Arrays.toString(conectividad) +
                ", pantalle=" + pantalle +
                ", camara=" + Arrays.toString(camara) +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", precio=" + precio +
                ", gamma='" + gamma + '\'' +
                ", mAh='" + mAh + '\'' +
                ", materiales='" + materiales + '\'' +
                '}';
    }

    //SOBREESCRITURA: REDEFINIR LA LOGICA (LOS PASOS) DE UN METODO
    //DE TAL FORMA QUE LOGRAS EL MISMO RESULTADO PERO CON PROCEDIMIENTO DIFERENTE



//Metodo de la forma 2: heredado y sobreescrito
@Override//<--Indica que este metodo en esta clase esta siendo sobreescrito
    public void llamar(String numero){

        Scanner sc = new Scanner(System.in);
        System.out.println("Seleccione como quieres hacer la llamada");
        System.out.println("1.- Red Celular");
        System.out.println("2.- Whatsapp");
        System.out.println("3.- Telegram");
        System.out.println("4.- Messenger");
        int select = sc.nextInt();

        switch (select){

            case 1:
                System.out.println("Llamando al: "+numero+ " por Red Celular");
                break;
            case 2:
                System.out.println("Llamando al: "+numero+ " por Whatsapp");
                break;
            case 3:
                System.out.println("Llamando al: "+numero+" por Telegram");
                break;
            case 4:
                System.out.println("Llamando al: "+numero+ " por Messenger");
                break;


            default:
                System.out.println("Opcion invalida");
        }
    }

    @Override
    public void mandarMensaje(String numero, String mensaje) {

    }

    @Override
    public void crearContacto() {

    }




//Metodos de la forma 3: Traidos de una interface
    @Override
    public void tomarfoto() {

    }

    @Override
    public void navegarPorInternet() {

    }

    @Override
    public void reproducirMusica() {

    }

    @Override
    public void reproducirVideos() {

    }

    @Override
    public void abrirAplicaciones() {

    }

    @Override
    public void leerDocumentos() {

    }

    @Override
    public void leerCorreos() {

    }
    //Si la clase abstracta tienen mas de 1 metodo abstracto
    //las clases hijas estan obligadas a implementar TODOS
    //los metodos abstractos



}
