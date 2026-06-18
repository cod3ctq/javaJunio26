import java.util.Arrays;

public class Smartphone extends Celular{

    boolean spen;
    String sistemaOperativo;
    boolean cargaInalambrica;
    int almacenamiento;


    //Atributos con composiciono : más complejos que los anteriores.

    String[] conectividad;
    Pantalla pantalla; //Declarar un objeto
    Camara[] camara;//camara : resolucion, nivelZoom, tipoLente, valorISO,

    //La composición define una relacion 'TIENE UN'


    //Constructor lleno
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


    //Getter y Setter
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

    //Metodo toString()
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
}
