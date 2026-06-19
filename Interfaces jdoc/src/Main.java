//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Caso simple: Debo contratar un VENDEDOR que realice funciones de ventas
        Vendedor v1 = new Vendedor();//Clase ob =new Constructor();
        v1.hacerPresupuestos();
        v1.captarClientes();
        v1.generarCotizaciones();

        IVentas v2 = new Vendedor();// Interface ob = new Sujeto espesifico();

        v2.captarClientes();
        v2.hacerPresupuestos();
        v2.generarCotizaciones();

        //cASO SIMPLE: Debo contratar un TECNICO ELECTRICISTA que realice funciones de electricidad

        TecnicoElectricista t1= new TecnicoElectricista();
        t1.leerDiagramas();
        t1.medirVoltaje1();
        t1.trabajar();

        IElectricidad t2= new TecnicoElectricista();// Interface ob = new Sujeto espesifico();
        t2.leerDiagramas();
        t2.medirVoltaje1();
        t2.trabajar();

        //Caso simple, debo contarar in INTENDENTE que realice funciones de limpieza

        Intendente it1= new Intendente();
        it1.podarPastor();
        it1.recolectarBasura1();
        it1.sanitizarSalon();

        //caso complejo: Debo contratar un EMPLEADO que realice funciones de venta

        //Acciones       // Sujeto (forma) espesifica
        //Que              //QUIEN

        IVentas v3 = new Intendente();
        IVentas V4 = new Vendedor();

        //caso complejo: Debo contratar un EMPLEADO que realice funciones de ELECTRICIDAD

        IElectricidad tr3= new Intendente();
        IElectricidad tr4= new TecnicoElectricista();


        //Una clase puede adoptar comportamiento de diferentes contextos ( interface)
        //








    }
}