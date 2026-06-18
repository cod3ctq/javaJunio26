public class BoletoCine {

    String tipoSala;
    int asiento;
    String NombrePelicula;
    String nombreSala;

    public String getTipoSala() {
        return tipoSala;
    }

    public int getAsiento() {
        return asiento;
    }

    public String getNombrePelicula() {
        return NombrePelicula;
    }

    public String getNombreSala() {
        return nombreSala;
    }

    public void setTipoSala(String tipoSala) {
        this.tipoSala = tipoSala;
    }

    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }

    public void setNombrePelicula(String nombrePelicula) {
        NombrePelicula = nombrePelicula;
    }

    @Override
    public String toString() {
        return "BoletoCine{" +
                "tipoSala='" + tipoSala + '\'' +
                ", asiento=" + asiento +
                ", NombrePelicula='" + NombrePelicula + '\'' +
                ", nombreSala='" + nombreSala + '\'' +
                '}';
    }

    public void setNombreSala(String nombreSala) {
        this.nombreSala = nombreSala;



    }

    public BoletoCine(String tipoSala, int asiento, String nombrePelicula, String nombreSala) {
        this.tipoSala = tipoSala;
        this.asiento = asiento;
        NombrePelicula = nombrePelicula;
        this.nombreSala = nombreSala;




    }
}
