public class Persona {
    private String persona;
    private String apellidoPat;
    private String ApellidoMat;
    private String FechaNac;
    private String lugarOringen;

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public String getApellidoPat() {
        return apellidoPat;
    }

    public void setApellidoPat(String apellidoPat) {
        this.apellidoPat = apellidoPat;
    }

    public String getApellidoMat() {
        return ApellidoMat;
    }

    public void setApellidoMat(String apellidoMat) {
        ApellidoMat = apellidoMat;
    }

    public String getFechaNac() {
        return FechaNac;
    }

    public void setFechaNac(String fechaNac) {
        FechaNac = fechaNac;
    }

    public String getLugarOringen() {
        return lugarOringen;
    }

    public void setLugarOringen(String lugarOringen) {
        this.lugarOringen = lugarOringen;
    }

    public Persona(String persona, String apellidoPat, String apellidoMat, String fechaNac, String lugarOringen) {
        this.persona = persona;
        this.apellidoPat = apellidoPat;
        ApellidoMat = apellidoMat;
        FechaNac = fechaNac;
        this.lugarOringen = lugarOringen;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "persona='" + persona + '\'' +
                ", apellidoPat='" + apellidoPat + '\'' +
                ", ApellidoMat='" + ApellidoMat + '\'' +
                ", FechaNac='" + FechaNac + '\'' +
                ", lugarOringen='" + lugarOringen + '\'' +
                '}';
    }
}
