import java.time.LocalDate;

//Herencia: se aplica con extends
//Define una relación ES UN
public class BoletoAutobus extends Boleto{


    //Parte 2: Especialización
    //Agregar más atributos que sean especificos/exclusivos del modelo
    String origen;
    String destino;
    String tipoServicio;
    int idAutobus;
    int asiento;

    //Dentro de una clase, SI NO SE LE GENERA NINGUN CONSTRUCTOR
    //Java otorga el CONSTRUCTOR VACIO POR DEFAULT
    //Pero si se genera alguno, entonces ya no se otorga el vacio.

    //Constructor lleno

    public BoletoAutobus(String nombre, LocalDate fechaHoraSalida, double precio, String origen, String destino, String tipoServicio, int idAutobus, int asiento) {
        super(nombre, fechaHoraSalida, precio); // Investigar
        this.origen = origen;
        this.destino = destino;
        this.tipoServicio = tipoServicio;
        this.idAutobus = idAutobus;
        this.asiento = asiento;
    }

    //Getter y Setter

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public int getIdAutobus() {
        return idAutobus;
    }

    public void setIdAutobus(int idAutobus) {
        this.idAutobus = idAutobus;
    }

    public int getAsiento() {
        return asiento;
    }

    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }

    //metodo toString()

    @Override
    public String toString() {
        return "BoletoAutobus{" +
                "origen='" + origen + '\'' +
                ", destino='" + destino + '\'' +
                ", tipoServicio='" + tipoServicio + '\'' +
                ", idAutobus=" + idAutobus +
                ", asiento=" + asiento +
                ", nombre='" + nombre + '\'' +
                ", fechaHoraSalida=" + fechaHoraSalida +
                ", precio=" + precio +
                '}';
    }
}
