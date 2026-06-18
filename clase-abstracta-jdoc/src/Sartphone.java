import java.util.Arrays;

public class Sartphone  extends Celular{

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


}

