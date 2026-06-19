//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Caso simple : Debo contratar un VENDEDOR que realice FUNCIONES DE VENTA
        Vendedor v1 = new Vendedor();  //Clase ob = new Constructor();
        v1.asesorarVenta();
        v1.captarClientes();
        v1.generaCotizacion();
        v1.generarPresupuesto();

        IVentas v2 = new Vendedor(); //Interface ob = new SujetoEspecifico();
	v2.asesorarVenta();
        v2.captarClientes();
        v2.generaCotizacion();
        v2.generarPresupuesto();

        //Caso simple : Debo contratar un TECNICO ELECTRICISTA que realice FUNCIONES DE ELECTRICIDAD
        TecnicoElectricista t1 = new TecnicoElectricista();
        t1.leerDiagramas();
        t1.colocarEnchufe();

        IElectricidad t2 = new TecnicoElectricista(); //Interface ob = new SujetoEspecifico(); 
        t2.leerDiagramas();
        t2.colocarEnchufe();

        //Caso simple : Debo contratar un INTENDENTE que realice FUNCIONES DE LIMPIEZA
	Intendente it1 = new Intendente(); //Clase ob = new Constructor();
	it1.recolectarBasura();
	it1.podarPasto();

        //Caso complejo : Debo contratar un EMPLEADO(?) que realice FUNCIONES DE VENTA
        //Acciones      Sujeto(forma) especifica
        //QUE            QUIEN
        IVenta v3 = new Vendedor();
        IVenta v4 = new Intendente();

        //Caso complejo : Debo contratar un EMPLEADO(?) que realice FUNCIONES DE ELECTRICIDAD
        //Acciones      Sujeto(forma) especifica
        //QUE            QUIEN
        IElectricidad t3 = new TecnicoElectricista();
        IElectricidad t4 = new Intendente();


//Una clase puede adoptar comportamiento de diferentes contextos (interfaces)
//implementando multiples interfaces.
//De tal manera que dichos metodos pueden ser resueltos (implementados) y/o ejecutados
//por varias clases (cada clase lo resuelve (sobreescribe) a su propia manera )





        

        
        

         

        












    }
}