public class BoletoCine {

    String tipoSala;
    int asirnto;
    String nombrePelicula;
    String nombreCine;

    public BoletoCine(String tipoSala, int asirnto, String nombrePelicula, String nombreCine) {
        this.tipoSala = tipoSala;
        this.asirnto = asirnto;
        this.nombrePelicula = nombrePelicula;
        this.nombreCine = nombreCine;
    }

    public String getTipoSala() {
        return tipoSala;
    }

    public void setTipoSala(String tipoSala) {
        this.tipoSala = tipoSala;
    }

    public int getAsirnto() {
        return asirnto;
    }

    public void setAsirnto(int asirnto) {
        this.asirnto = asirnto;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    public String getNombreCine() {
        return nombreCine;
    }

    public void setNombreCine(String nombreCine) {
        this.nombreCine = nombreCine;
    }

    @Override
    public String toString() {
        return "BoletoCine{" +
                "tipoSala='" + tipoSala + '\'' +
                ", asirnto=" + asirnto +
                ", nombrePelicula='" + nombrePelicula + '\'' +
                ", nombreCine='" + nombreCine + '\'' +
                '}';
    }
}

