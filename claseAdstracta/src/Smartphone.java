import java.util.Arrays;
import java.util.Scanner;

public class Smartphone  extends Telefono implements IFuncionesInteligentes {

    boolean spem;
    String sustemaOperativo;
    boolean cargaInalambrica;
    int almacenamiento;
    String[] conectividad;
    Pantalla pamtalla;
    Camara[] camaras;

    //define una relacion tiene un

    


    //camara resolucion nivel tipo lente+

    public Smartphone(String marca, String modelo, Double precio, String gama, String materia, boolean spem, String sustemaOperativo, boolean cargaInalambrica, int almacenamiento, Camara[] camaras, Pantalla pantalla) {
        super();
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.gama = gama;
        this.materia = materia;
        this.spem = spem;
        this.sustemaOperativo = sustemaOperativo;
        this.cargaInalambrica = cargaInalambrica;
        this.almacenamiento = almacenamiento;
        this.camaras = camaras;
        this.pamtalla = pantalla;
    }


    //metodo de la forma 2 metodo adstracto
    //metodo sin implementacion, solo con la firma del metodo

    public void llamar(String numero){
        System.out.println("Por donde quieres marcar?");
        Scanner sc = new Scanner(System.in);
        int tempOpcion = Integer.parseInt(sc.nextLine());
        switch (tempOpcion){
            case 1:
                System.out.println("Llamando por el whatsapp a" +
                        numero);
                break;
            case 2:
                System.out.println("Llamando por el instagram a" +
                    numero);
                break;
            case 3:
                System.out.println("Llamando por el telefono a" +
                        numero);
                break;
            default:
                System.out.println("Opcion no valida");
        }


    }


    public boolean isSpem() {
        return spem;
    }

    public void setSpem(boolean spem) {
        this.spem = spem;
    }

    public String getSustemaOperativo() {
        return sustemaOperativo;
    }

    public void setSustemaOperativo(String sustemaOperativo) {
        this.sustemaOperativo = sustemaOperativo;
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
    //pantalla hz, resolucion ,tipoPanel, certificacion,tamli,pp1


    @Override
    public String toString() {
        return "Smartphone{" +
                "materia='" + materia + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", precio=" + precio +
                ", gama='" + gama + '\'' +
                ", camaras=" + Arrays.toString(camaras) +
                ", pamtalla=" + pamtalla +
                ", conectividad=" + Arrays.toString(conectividad) +
                ", almacenamiento=" + almacenamiento +
                ", cargaInalambrica=" + cargaInalambrica +
                ", sustemaOperativo='" + sustemaOperativo + '\'' +
                ", spem=" + spem +
                '}';
    }


    //traido de una interface una de las 3 formas interfaces
    @Override
    public void tomarFoto() {

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
    public void abririAplicacion() {

    }

    @Override
    public void leerCorreo() {

    }

    @Override
    public void leerDoucuementos() {

    }
}
