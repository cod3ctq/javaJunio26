import java.time.LocalDate;

//Herencia: se aplica con extends
//Define una relacion ES UN
public class BoletoAutobus extends Boleto{

    //Parte 2: Especializacion
    //Agregar mas atributos que sean especificos/exclusivos del modelo
    String origen;
    String destino;
    String tipoServicio;
    int idAutobus;
    int asiento;

    //Dentro de una clase, SI NO SE LE GENERA NINGUN CONSTRUCTOR
    //Java otorga el CONSTRUCTOR VACIO POR DEFAULT
    //Pero si se genera alguno, entonces ya no se otorga el vacio
    public BoletoAutobus(String nombre, LocalDate fechaHora, double precio, String origen, String destino, String tipoServicio, int idAutobus, int asiento) {
        super(nombre, fechaHora, precio); //investigar
        this.origen = origen;
        this.destino = destino;
        this.tipoServicio = tipoServicio;
        this.idAutobus = idAutobus;
        this.asiento = asiento;
    }




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

    @Override
    public String toString() {
        return "BoletoAutobus{" +
                "origen='" + origen + '\'' +
                ", destino='" + destino + '\'' +
                ", tipoServicio='" + tipoServicio + '\'' +
                ", idAutobus=" + idAutobus +
                ", asiento=" + asiento +
                ", nombre='" + nombre + '\'' +
                ", fechaHora=" + fechaHora +
                ", precio=" + precio +
                '}';
    }

}
