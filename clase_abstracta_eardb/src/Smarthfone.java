import java.util.Arrays;

public class Smarthfone extends Celular{


    boolean spen;
    String sistemaOperativo;
    boolean cargaInalamnbrica;
    int almacenamiento;

    //atributos con composicion: mas complejos que los anteriores
    String[] conectividad;
    Pantalla pantalla;
    Camara[] camara;

    //COMPOSICION: define un relacion 'tiene un'


    public Smarthfone(String marca, double precio, String modelo, String gama, String mAh, String materiales, boolean spen, String sistemaOperativo, boolean cargaInalamnbrica, int almacenamiento, String[] conectividad, Pantalla pantalla, Camara[] camara) {
        super(marca, precio, modelo, gama, mAh, materiales);
        this.spen = spen;
        this.sistemaOperativo = sistemaOperativo;
        this.cargaInalamnbrica = cargaInalamnbrica;
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

    public boolean isCargaInalamnbrica() {
        return cargaInalamnbrica;
    }

    public void setCargaInalamnbrica(boolean cargaInalamnbrica) {
        this.cargaInalamnbrica = cargaInalamnbrica;
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
        return "Smarthfone{" +
                "spen=" + spen +
                ", sistemaOperativo='" + sistemaOperativo + '\'' +
                ", cargaInalamnbrica=" + cargaInalamnbrica +
                ", almacenamiento=" + almacenamiento +
                ", conectividad=" + Arrays.toString(conectividad) +
                ", pantalla=" + pantalla +
                ", camara=" + Arrays.toString(camara) +
                '}';
    }
}
