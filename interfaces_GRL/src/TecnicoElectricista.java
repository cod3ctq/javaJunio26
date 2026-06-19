public class TecnicoElectricista extends Empleado implements IElecticidad {

    @Override
    public void trabajar(){
        System.out.println("estoy trabajando como Electricista");
    }

    @Override
    public void lecturaDiagrama() {

    }

    @Override
    public void medirVoltaje() {

    }

    @Override
    public void colocarEnchufe() {

    }
}
