import java.util.Arrays;
import java.util.Scanner;

public class Sartphone  extends Celular implements IFuncionesInteligentes{

    boolean spen;
    String[] conectividad;
    String sistemaOperativo;
    boolean cargaInalambrica;
    int almacenamineto;
    Pantalla pantalla; // hz, resolucion, tiposPanel, certificacion, tamaño, ppi
    Camara[] camaras; //resolucion, nivelZoom, tipoLente, valorISO,

    public Sartphone(String marca, String modelo, double precio, String gama, String mAh, String materiales, boolean spen, String[] conectividad, String sistemaOperativo, boolean cargaInalambrica, int almacenamineto, Pantalla pantalla, Camara[] camaras) {
        super(marca, modelo, precio, gama, mAh, materiales);
        this.spen = spen;
        this.conectividad = conectividad;
        this.sistemaOperativo = sistemaOperativo;
        this.cargaInalambrica = cargaInalambrica;
        this.almacenamineto = almacenamineto;
        this.pantalla = pantalla;
        this.camaras = camaras;
    }


    //  COMPOSICION: define una relacion 'TIENE UN'


    public boolean isSpen() {
        return spen;
    }

    public String[] getConectividad() {
        return conectividad;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public boolean isCargaInalambrica() {
        return cargaInalambrica;
    }

    public int getAlmacenamineto() {
        return almacenamineto;
    }

    public Pantalla getPantalla() {
        return pantalla;
    }

    public Camara[] getCamaras() {
        return camaras;
    }

    public void setSpen(boolean spen) {
        this.spen = spen;
    }

    public void setConectividad(String[] conectividad) {
        this.conectividad = conectividad;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public void setCargaInalambrica(boolean cargaInalambrica) {
        this.cargaInalambrica = cargaInalambrica;
    }

    public void setAlmacenamineto(int almacenamineto) {
        this.almacenamineto = almacenamineto;
    }

    public void setPantalla(Pantalla pantalla) {
        this.pantalla = pantalla;
    }

    public void setCamaras(Camara[] camaras) {
        this.camaras = camaras;
    }

    @Override
    public String toString() {
        return "Sartphone{" +
                "materiales='" + materiales + '\'' +
                ", mAh='" + mAh + '\'' +
                ", gama='" + gama + '\'' +
                ", precio=" + precio +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", camaras=" + Arrays.toString(camaras) +
                ", pantalla=" + pantalla +
                ", almacenamineto=" + almacenamineto +
                ", cargaInalambrica=" + cargaInalambrica +
                ", sistemaOperativo='" + sistemaOperativo + '\'' +
                ", conectividad=" + Arrays.toString(conectividad) +
                ", spen=" + spen +
                '}';


    }
    //Metodo de la forma 2: heredado y sobreescrito

    //SOBREESCRITURA: REDEFINIR LA LOGICA( LOS PASOS DE UN METODO
    //DE TAL FORMA QUE LOGRAS EL MISMO RESULTADO PERO CON PROCEDIMIENTO DIFERENTE
    @Override//--- iNDICA QUE ESTE METODO EN ESAT CLASE ESTA CIENDO SOBREESCRITO
    public void llamar(String numero){//sobrecarga
        //Sobreeswcritura
        Scanner sc = new Scanner(System.in);
        System.out.println("selecciona como quieres hacer la llamada");
        System.out.println("1- Red Celular");
        System.out.println("2- Whatsaap");
        System.out.println("3- telegram");
        System.out.println("4- Messenger");
        int selec = sc.nextInt();


        switch (selec){
            case 1:
                System.out.println("llamando al: "+numero+ "por Red Celular");
                break;
            case 2:
                System.out.println("llamando al: "+numero+ "por Whatssapp");
                break;
            case 3:
                System.out.println("llamando al: "+numero+ "pornTelegram");
                break;
            case 4:
                System.out.println("llamando al: "+numero+ "por Messenger");
                break;

            default:
                System.out.println("Opcion invalida");
        }
    }


    // Metodos de la forma 3: traidos de una interface


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
    public void reprodicirVideos() {

    }

    @Override
    public void abrirAplicacion() {

    }

    @Override
    public void abrirCorreps() {

    }

    @Override
    public void leerDocumento() {

    }
}

