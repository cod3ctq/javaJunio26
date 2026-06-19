public class Main {
    public static void main(String[] args) {
        //Caso simple: Debo contratar un Vendedor que realice funciones de ventas
        //Constructor
        Vendedor v1 = new Vendedor(); //Clase ob = nre Constructor();
        v1.asesoramiento();
        v1.captarClientes();
        v1.generarCotizacion();
        v1.generarPresupuestos();

        IVentas v2 = new Vendedor(); //Interface ob = new SujetoEspecifico();
        v2.asesoramiento();
        v2.captarClientes();
        v2.generarCotizacion();
        v2.generarPresupuestos();

        //Caso simple: Debo contratar un Tecnico Electricista que realice FUNCIONES DE ELECTRICIDAD
        TecnicoElectricista t1 = new TecnicoElectricista();
        t1.lecturaDiagramas();
        t1.colocarEnchufe();

        IElectricidad t2 = new TecnicoElectricista(); //Interface ob = new SujetoEspecifico
        t2.lecturaDiagramas();
        t2.colocarEnchufe();

        //Caso simple: Debo contratar un intendente que realice FUNCIONES DE LIMPIEZA
        Intendente it1 = new Intendente();//Clase ob = new contructor();
        it1.asesoramiento();


        //Caso Complejo: Debo contratar un EMPLEADO que relice FUNCIONES DE VENTA
        //Acciones Sujeto()  especifica
        //QUE           QUIEN
        IVentas v3 = new Vendedor();
        IVentas v4 = new Intendente();

        //Caso Complejo: Debo contratar un EMPLEADO que relice FUNCIONES DE ELECTRICIDAD
        //Acciones Sujeto()  especifica
        //QUE           QUIEN
        IElectricidad t3 = new TecnicoElectricista();
        IElectricidad t4 = new Intendente();

        /*
        polimorfismo:
        Mutacion de clases: Es cuando puedes una clase puede mas de una interface
        Una clase puede adoptar compormatiento de diferentes contextos (interfaces)
        Implementando multiples interfaces.
        De tal manera que dichos metodos puedes ser resueltos (implementados) y/o ejecutados por varias clases
        (cada clase lo resuelve (sobreescritura) a su propia manera)
         */
    }
}
