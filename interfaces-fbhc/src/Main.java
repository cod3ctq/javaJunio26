public class Main {
    public static void main(String[] args) {

        //Caso simple: debo de contratar a un vendedor  que realice funciones de venta
        Vendedor v1 = new Vendedor(); //Clase ob = new Constructor();
        v1.asesorarVenta();
        v1.caoturarCliente();
        v1.generarCotizacion();
        v1.generarCotizacion();

        IVentas v2 = new Vendedor();//Interfase ob = new SujetoConstructorEspecifico


        //Caso simple : debo contratar a un Electricista  que realice funciones de electricidad

        TecnicoElectricista t1 = new TecnicoElectricista();
        t1.leerDiagramas();
        t1.colocarEnchufe();

        IElectricidad t2 = new TecnicoElectricista(); //Interface ob = new SujetoEspecifico
        t2.leerDiagramas();
        t2.colocarEnchufe();

        //Caso simple : debo contratar a un Intendnte   que realice funciones de electricidad
        Intendente int1 = new Intendente(); // Clase ob = new Constructor();
        it1.recolectarBasura();
        it1.podarPasto();

        //Caso complejo: Debo contratar a un empleado que realice funciones de venta

        //Acciones     Sujeto(forma) especidica
        IVentas v3 = new Vendedor();
        IVentas v4 = new Intendente();

        //Caso complejo: Debo contratar a un empleado que realice funciones de electricidad

        //Acciones     Sujeto(forma) especidica
        IElectricidad t3 = new TecnicoElectricista();
        IElectricidad t4 = new Intendente();

        //Una clase puede adoptar comportamiento de varios contextos (interfases)
        //implementando multiples interfaces
        //por varias clases  (cada clase lo resuelve a su propia manera)



    }





}
