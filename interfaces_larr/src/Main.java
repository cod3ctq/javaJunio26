//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Caso simple : Debo contratar un VENDEDOR que realice FUNCIONES DE VENTA

        Vendedor v1 = new Vendedor(); // Clase ob = new Constructor();
        v1.asesorarVentas();
        v1.captarClientes();
        v1.generarCotizacion();
        v1.generarPresupuestos();
        v1.trabajar();

        IVentas v2 = new Vendedor(); // Interface ob = new SujetoEspecifico();

        v2.asesorarVentas();
        v2.tramitarPedido();
        v2.captarClientes();


        // Caso simple : Debo contratar un TECNICO ELECTRICISTA que realice FUNCIONES DE ELECTRICIDAD

        TecnicoElectricista t1 = new TecnicoElectricista(); // Clase ob = new Constructor();
        t1.lecturaDiagramas();
        t1.colocarEnchufe();
        t1.medirVoltajes();

        IElectricidad t2 = new TecnicoElectricista(); // Interface ob = new SujetoEspecifico();


        // Caso simple : Debo contratar un INTENDENTE que realice FUNCIONES DE LIMPIEZA

        Intendente it1 = new Intendente(); // Clase ob = new Constructor();
        it1.podarPasto();
        it1.recolectarBasura();


        // Caso complejo : Debo contratar un EMPLEADO que realice FUNCIONES DE VENTAS

        // Acciones       Sujeto(forma) específica.
        // QUÉ            QUIÉN
        IVentas v3 = new Vendedor();
        IVentas v4 = new Intendente();


        // Caso complejo : Debo contratar un EMPLEADO que realice FUNCIONES DE ELECTRICIDAD

        // Acciones       Sujeto(forma) específica.
        // QUÉ            QUIÉN
        IElectricidad t3 = new TecnicoElectricista();
        IElectricidad t4 = new Intendente();

        // Mutación de clases : Una clase puede adoptar comportamiento de diferentes contextos (Interfaces)
        // implementando multiples interfases, de tal manera que, dichos metodos pueden ser resueltos (implementados) y/o
        // ejecutados por varias clases (cada clase lo resuelve (sobreescribe) a su propia manera)


    }
}