//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    //TIP conlas interfaces tienes libertad de implementat solo aquellas
    // interfaces que contegan los methods necesriot al estar desacoplado delm comportamiento de atributos
    //evitando un problema del diamante y se sila de los atributos

    //plantilla de métodos esttractos/>
    public static void main(String[] args) {

        //TIP clase ob = new conrructor();
        Vendedor v1= new Vendedor();
        v1.generarCotizacion();
        v1.captarCliente();
        v1.generarCotizacion();
        v1.generarPresupuesto();

        //TIP Interface ob = new SujetEspecifico();
        IVentas v2= new Vendedor();

        //TIP Caso simple: Debo conectar un EMPLEADO que realice FUNCIONES DE ELECTRICIDAD
        TecnicoElectricista t1 = new TecnicoElectricista();
        t1.lecturaDiagrama();
        t1.colocarEnchufe();

        //TIP caso simple: debo contratar  un tecnivo Elctricisata que realice Funciones de Eelectricidad
        IElecticidad t2 = new TecnicoElectricista();
        v2.generarCotizacion();
        v2.captarCliente();
        v2.generarCotizacion();
        v2.generarPresupuesto();

        //TIP caso simple:Debo contratar  un intendente que realice fuinciones de un intendente
        Intendente it1 = new Intendente(); //clase object simple

        //TIP caso complejo: Debo contratar un empoleado que realice FUNCIONES DE VENta
        // ACCION subjeto(forma) Especifica
        //           "quien"

        IVentas v3 = new Intendente();
        v3.ascesorar();

        //TIP debo contratar un empleado? que realice  Funciones electricas

        IElecticidad v4 = new TecnicoElectricista();
        IElecticidad v5 = new Intendente();
        v5.colocarEnchufe();
        v4.colocarEnchufe();

        //TIP 3 Formas declaracion:

        //TIP Polimorfismo:
        //TIP una clase puede adoptar comportamiento de diferentes contexto (Interface) implementando
        // multiples interface de dicaha forma que puede ser resuletos e ejecutados por varias clases;(cada clase se
        // resuelve de diferente manera)

    }

}