import java.util.Arrays;
import java.util.Scanner;

public class Smartphone extends Celular implements IFuncionesInteligentes{

    boolean spen;
    String sistemaOperativo;
    boolean cargaInalambrica;
    int almacenamiento;

    //Atributos con composicion: mas complejos que los anteriores
    String[] conectividad;
    Pantalla pantalla;
    Camara[] camara;


    //COMPOSICION: Define una relacion 'TIENE UN'
    public Smartphone(String marca, String modelo, double precio, String gama, String mAh, String materiales, boolean spen, String sistemaOperativo, boolean cargaInalambrica, int almacenamiento, String[] conectividad, Pantalla pantalla, Camara[] camara) {
        super(marca, modelo, precio, gama, mAh, materiales);
        this.spen = spen;
        this.sistemaOperativo = sistemaOperativo;
        this.cargaInalambrica = cargaInalambrica;
        this.almacenamiento = almacenamiento;
        this.conectividad = conectividad;
        this.pantalla = pantalla;
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

    public Pantalla getPantalla() {
        return pantalla;
    }

    public void setPantalla(Pantalla pantalla) {
        this.pantalla = pantalla;
    }

    public Camara[] getCamara() {
        return camara;
    }

    public void setCamara(Camara[] camara) {
        this.camara = camara;
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "spen=" + spen +
                ", sistemaOperativo='" + sistemaOperativo + '\'' +
                ", cargaInalambrica=" + cargaInalambrica +
                ", almacenamiento=" + almacenamiento +
                ", conectividad=" + Arrays.toString(conectividad) +
                ", pantalla=" + pantalla +
                ", camara=" + Arrays.toString(camara) +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", precio=" + precio +
                ", gama='" + gama + '\'' +
                ", mAh='" + mAh + '\'' +
                ", materiales='" + materiales + '\'' +
                '}';
    }

    //Metodo de la forma 2: heredado y sobreescrito

    //SOBREESCRITURA: REDEFINIR LA LOGICA (LOS PASOS) DE UN METODO
    //DE TAL FORMA QUE LOGRAS EL MISMO RESULTADO PERO CON PROCEDIMIENTO DIFERENTE
    @Override //<-- indica que este metodo en esta clase esta siendo sobreescrito
    public void llamar(String numero){
        Scanner sc = new Scanner(System.in);
        System.out.println("Selecciona como quieres hacer la llamada");
        System.out.println("1 - Red Celular");
        System.out.println("2 - Whatsapp");
        System.out.println("3 - Telegram");
        System.out.println("4 - Messenger");
        int selec = sc.nextInt();
        switch(selec){
            case 1:
                System.out.println("Llamando al: "+numero + " por Red Celular");
                break;
            case 2:
                System.out.println("Llamando al: "+numero + " por Whatsapp");
                break;
            case 3:
                System.out.println("Llamando al: "+numero + " por Telegram");
                break;
            case 4:
                System.out.println("Llamando al: "+numero + " por Messenger");
                break;
            default:
                System.out.println("Opcion invalida");
        }
    }

    //Si la clase abstracta tiene mas de 1 metodo abstracto
    //las clases hijas estan obligadas a implementar TODOS
    //los metodos abstractos
    @Override
    public void nuevoMetodo() {

    }

    @Override
    public void otroMetodo() {

    }

    //Metodos de la forma 3: Traidos de una interface
    @Override
    public void tomarFotos() {

    }

    @Override
    public void navegarPorInternet() {

    }

    @Override
    public void reproducirMusica() {

    }

    @Override
    public void reproducirVideo() {

    }

    @Override
    public void abrirAplicacion() {

    }

    @Override
    public void leerCorreos() {

    }

    @Override
    public void leerDocumentos() {

    }
}
