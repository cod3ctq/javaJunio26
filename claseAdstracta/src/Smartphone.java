import java.util.Arrays;

public class Smartphone  extends Telefono {

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
}
