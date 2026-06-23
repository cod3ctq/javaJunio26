public class Persona {
    //Attributes

    private String nombre;
    private String apellidoPat;
    private String getApellidoMat;
    private String fechaNac;
    private String lugarOrigen;

    public Persona() {
    }

    public Persona(String nombre, String apellidoPat, String getApellidoMat, String fechaNac, String lugarOrigen) {
        this.nombre = nombre;
        this.apellidoPat = apellidoPat;
        this.getApellidoMat = getApellidoMat;
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

    public String getGetApellidoMat() {
        return getApellidoMat;
    }

    public void setGetApellidoMat(String getApellidoMat) {
        this.getApellidoMat = getApellidoMat;
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
                ", getApellidoMat='" + getApellidoMat + '\'' +
                ", fechaNac='" + fechaNac + '\'' +
                ", lugarOrigen='" + lugarOrigen + '\'' +
                '}';
    }
}
