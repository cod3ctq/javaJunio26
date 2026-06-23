public class Persona {

    private String nombre;
    private String apellidoPat;
    private String apellidoMat;
    private String fechaNac;
    private String lugarOrigen;

    public Persona(String nombre, String apellidoPat, String apellidoMat, String fechaNac, String lugarOrigen) {
        this.nombre = nombre;
        this.apellidoPat = apellidoPat;
        this.apellidoMat = apellidoMat;
        this.fechaNac = fechaNac;
        this.lugarOrigen = lugarOrigen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPat() {
        return apellidoPat;
    }

    public void setApellidoPat(String apellidoPat) {
        this.apellidoPat = apellidoPat;
    }

    public String getApellidoMat() {
        return apellidoMat;
    }

    public void setApellidoMat(String apellidoMat) {
        this.apellidoMat = apellidoMat;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getLugarOrigen() {
        return lugarOrigen;
    }

    public void setLugarOrigen(String lugarOrigen) {
        this.lugarOrigen = lugarOrigen;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellidoPat='" + apellidoPat + '\'' +
                ", apellidoMat='" + apellidoMat + '\'' +
                ", fechaNac='" + fechaNac + '\'' +
                ", lugarOrigen='" + lugarOrigen + '\'' +
                '}';
    }
}
