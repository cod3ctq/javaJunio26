import javax.management.Attribute;
import java.util.Arrays;

/*
Especializacion
Composicion
 */
public class Smartphone extends Celular{
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
}
