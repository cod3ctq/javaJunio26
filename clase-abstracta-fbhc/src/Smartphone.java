import java.util.Arrays;

public class Smartphone extends celular{


    //pantalla tactil
    //camara
    //spen
    //conectividad
    //sistema operativo
    //carga inalambrica

    boolean spen;
    String sistemaOperativo;
    boolean caargaInalambrica;
    int almacenamiento;

    //Atributos mas complejos que los anteriores
    String[] conectividad;
    Pantalla pantalla;
    Camara[] camaras;




    // pantalla : hz, resolucion, tipoPanel, certificacion, tamaño, ppi
    // camara: resolucion, nivelZom, tipoLente, valorISO,

    // COMPOSICION: Define una relacion tiene un


    public Smartphone(String marca, String modelo, int precio, String gama, String mAh, String materiales, boolean spen, String sistemaOperativo, boolean caargaInalambrica, int almacenamiento, String[] conectividad, Pantalla pantalla, Camara[] camaras) {
        super(marca, modelo, precio, gama, mAh, materiales);
        this.spen = spen;
        this.sistemaOperativo = sistemaOperativo;
        this.caargaInalambrica = caargaInalambrica;
        this.almacenamiento = almacenamiento;
        this.conectividad = conectividad;
        this.pantalla = pantalla;
        this.camaras = camaras;
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

    public boolean isCaargaInalambrica() {
        return caargaInalambrica;
    }

    public void setCaargaInalambrica(boolean caargaInalambrica) {
        this.caargaInalambrica = caargaInalambrica;
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

    public Camara[] getCamaras() {
        return camaras;
    }

    public void setCamaras(Camara[] camaras) {
        this.camaras = camaras;
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "spen=" + spen +
                ", sistemaOperativo='" + sistemaOperativo + '\'' +
                ", caargaInalambrica=" + caargaInalambrica +
                ", almacenamiento=" + almacenamiento +
                ", conectividad=" + Arrays.toString(conectividad) +
                ", pantalla=" + pantalla +
                ", camaras=" + Arrays.toString(camaras) +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", precio=" + precio +
                ", gama='" + gama + '\'' +
                ", mAh='" + mAh + '\'' +
                ", materiales='" + materiales + '\'' +
                '}';
    }
}
