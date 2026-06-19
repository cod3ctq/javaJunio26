import javax.management.Attribute;
import java.util.Arrays;
import java.util.Scanner;

/*
Especializacion
Composicion
 */
public class Smartphone extends Celular implements IFuncionesInteligentes{
    // Attributes (ES UN)
    boolean spen;
    String sistemaOperativo;
    boolean cargaInalambrica;
    int almacenamiento;

    //Composicion (TIENE UN)
    Pantalla pantalla;
    String [] conectividad;
    Camara[] camara;

    //COMPOSICION: define una relacion 'TIENE UN'

    public Smartphone(String marca, String modelo, String gama, double precio, String mAh, boolean spen, boolean cargaInalambrica, int almacenamiento, String sistemaOperativo, Pantalla pantalla,String[] conectividad, Camara[] camara) {
        super(marca, modelo, gama, precio, mAh);
        this.spen = spen;
        this.cargaInalambrica = cargaInalambrica;
        this.almacenamiento = almacenamiento;
        this.sistemaOperativo = sistemaOperativo;
        this.pantalla = pantalla;
        this.conectividad = conectividad;
        this.camara = camara;
    }

    public boolean isSpen() {
        return spen;
    }

    public void setSpen(boolean spen) {
        this.spen = spen;
    }

    public String[] getConectividad() {
        return conectividad;
    }

    public void setConectividad(String[] conectividad) {
        this.conectividad = conectividad;
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

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
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
                ", pantalla=" + pantalla +
                ", conectividad=" + Arrays.toString(conectividad) +
                ", camara=" + Arrays.toString(camara) +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", gama='" + gama + '\'' +
                ", precio=" + precio +
                ", mAh='" + mAh + '\'' +
                '}';
    }

    //Polimorfismo: Esta compuesto de:
    //  SOBRECARGA DE ARGUMENTOS
    //SOBREESCRITURA: REDEFINIR LA LOGICA (LOS PASOS) DE UN METODO
    //DE TAL FORMA QUE LOGRAS EL MISMO RESULTADO PERO CON PROCEDIMIENTO DIFERENTE

    /*
    Metodo de la forma 2: heredado y sobreescrito
     */

    @Override // <-- Indica que es te metodo en esta clase esta siendosobreescrito
    public void llamar(String numero){
        Scanner sc = new Scanner(System.in);
        System.out.println("Selecciona como quieres hacer la llamada");
        System.out.println("1 = Red Celular");
        System.out.println("2 = Whatsapp");
        System.out.println("3 = Telegram");
        System.out.println("4 = Messanger");
        int select = sc.nextInt();

        switch(select){
            case 1:
                System.out.println("Llamanado al: "+numero+" por Red Celular");
                break;
            case 2:
                System.out.println("Llamanado al: "+numero+" por Whatsapp");
                break;
            case 3:
                System.out.println("Llamando al: "+numero+ "por Telegram");
                break;
            case 4:
                System.out.println("Llamando al: "+numero+ "por Messenger");
                break;
            default:
                System.out.println("Opcion invalida");
        };
    }

    @Override
    public void nuevoMetodo(String numero) {
    }

    @Override
    public void OtroMetodo(String numero) {
    }


    //metodos de la forma 3:Traidos de una interface
    @Override
    public void tomarFotos() {

    }

    @Override
    public void navegarInternet() {

    }

    @Override
    public void reproducirMusica() {

    }

    @Override
    public void reproducirVideo() {

    }

    @Override
    public void abrirAplicaciones() {

    }

    @Override
    public void descargarAplicacion() {

    }

    @Override
    public void leerDocumentos() {

    }

    @Override
    public void leerCorreos() {

    }


    /*
    Interfaces: es un contrato de acciones abstractas que deben ser implementadas. No tiene atributos, getters and setters
    constructores y demas metodos
     */
}
