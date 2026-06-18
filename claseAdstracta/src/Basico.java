import java.util.Arrays;

public class Basico extends Telefono {
    Camara[] camaras;

    public Basico(String marca, String modelo, Double precio, String gama, String materia, Camara[] camaras) {
        super();
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.gama = gama;
        this.materia = materia;
        this.camaras = camaras;
    }

    public Camara[] getCamaras() {
        return camaras;
    }

    public void setCamaras(Camara[] camaras) {
        this.camaras = camaras;
    }

    @Override
    public String toString() {
        return "Basico{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", precio=" + precio +
                ", gama='" + gama + '\'' +
                ", materia='" + materia + '\'' +
                ", camaras=" + Arrays.toString(camaras) +
                '}';
    }
}
