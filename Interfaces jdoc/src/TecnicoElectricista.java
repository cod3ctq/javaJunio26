public class TecnicoElectricista extends Empleado implements IElectricidad {

    public TecnicoElectricista();


    public TecnicoElectricista(String nombre, String fechaNac, String domicilio) {
        super(nombre, fechaNac, domicilio);
    }

    @Override
    public String trabajar() {
        return "";
    }

    @Override
    public String leerDiagramas() {
        return "";
    }

    @Override
    public String medirVoltaje1() {
        return "";
    }
}
