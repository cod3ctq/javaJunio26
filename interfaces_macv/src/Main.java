//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Caso simple: Debo contratar un VENDEDOR que realice FUNCIONES DE VENTAS
        Vendedor v1 = new Vendedor(); //Clase ob = new constructor();
        v1.asesorar();
        v1.captatCliente();
        v1.generarCotizacion();
        v1.generarPresupuesto();
        v1.tramitarPedido();

        IVentas v2= new Vendedor(); //Interfacd ob = new SujetoEspecifico();


        //TIP Caso simple: Debo llamar a un TECNICO ELECTRICISTA que realice FUNCIONES DE ELECTRICIDAD
        Electricista t1 = new Electricista();
        t1.medirVoltaje();
        t1.colocarContacto();
        t1.lecturaDiagrama();

        IElectricidad t2 = new Electricista(); //Interface ob = new SujetoEspecifico



        //TIP Caso simple: Debo llamar a un INTENDENTE que realice FUNCIONES DE LIMPIEA

        Intendente it1 = new Intendente();//clase ob = new constructor();

        //TIP Debo contratr a un empleado (?)que ralice funciones de ventas

        //ACCIONES       Sujeto(forma) especifica
        // Acciones            QQUIEN

        IVentas v3 = new Vendedor();
        IVentas v4 = new Intendente();

        //TIP Debo contratr a un empleado (?)que ralice funciones de electricidad

        //ACCIONES       Sujeto(forma) especifica
        // Acciones            QQUIEN

        IElectricidad E3 = new Electricista();
        IVentas E4 = new Intendente();

        //TIP UNA CLASE PUEDE ADOPTAR COMPORTAMIENTOS DE DIFERENTES CONTEXTOS (INTERFACES) IMPLEMENTANDO MULTIPLES INTERFACES
        //TIP DE TAL MANERA QUE DICHOS METODOS PUEDEN SER RESUELTOS (IMPLEMENTOS) Y/O EJECUTADOS POR VARIAS CLASES (CADA CLASE LO RESUELTE (SOBREESCRIBE) A SU PROPIA MANERA)
    }
}