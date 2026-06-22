//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Static: Crea miembros de clase (con valores compartidos por todas sus instancias)
        //final: Aplica la inmutabilidad (define valores que no cambian)

//        //Cajainstancia decide los valores para los atributos de instancia
//        CajaCobro cc1 = new CajaCobro("A01","Carlos");
//        CajaCobro cc2 = new CajaCobro("A02","Luis");
//        CajaCobro cc3 = new CajaCobro("A03","Guillermo");
//        CajaCobro cc4 = new CajaCobro("A03","Sara");
//
//        cc1.registrarVenta(50);
//        cc2.registrarVenta(30);
//        cc3.registrarVenta(450);
//        cc1.registrarVenta(645);
//        cc2.registrarVenta(345);
//        cc2.registrarVenta(5345);
//        cc2.registrarVenta(3456);
//        cc1.registrarVenta(345764);
//        cc3.registrarVenta(3245);
//        cc1.registrarVenta(2345);
//        cc1.registrarVenta(2345);
//        cc3.registrarVenta(123);
//        cc2.registrarVenta(536);
//        cc3.registrarVenta(785);
//        cc1.registrarVenta(5454);
//        cc3.registrarVenta(547);
//        cc2.registrarVenta(342);
//        cc1.registrarVenta(456);
//
//        //Total vendido caja 1
//        System.out.println("Total vendido caja 1: "+cc1.getVentaIndividual());
//        System.out.println("Total vendido caja 2: "+cc2.getVentaIndividual());
//        System.out.println("Total vendido caja 3: "+cc3.getVentaIndividual());
//        System.out.println("Total vendido caja 4: "+cc4.getVentaIndividual());
//
//
//        //Imprimir el total de las ventas
//        System.out.println("Total vendido : "+cc3.getVentaGlobal());
//        System.out.println("Ventas realizadas : "+cc1.getNumVentas());
//
//
//        //Los miembros estaticos de una clase pueden ser accedidos sin crear una nueva instancia de la clase, solamente llamando a la propia clase
//        System.out.println(CajaCobro.getVentaGlobal());//Atraves de los getters
//        System.out.println(CajaCobro.getNumVentas());// de manera directa al atributo

        IPhone i1 = new IPhone(150,"White",20000,"Huella");
        IPhone i2 = new IPhone(150,"Brown",20000,"Face Id");
        IPhone i3 = new IPhone(150,"Red",22000,"Huella");
        IPhone i4 = new IPhone(150,"Green",30000,"Huella");

        //VAlores de clase son siempre los mismos en todas sus instancias
        System.out.println(IPhone.getFabricante());//Acceso directamente desde a clase
        System.out.println("Fabricante : "+i1.SISTEMA_OPERATIVO);
        System.out.println("Fabricante : "+i2.SISTEMA_OPERATIVO);
        System.out.println("Fabricante : "+i3.SISTEMA_OPERATIVO);
        System.out.println("Fabricante : "+i4.SISTEMA_OPERATIVO);

        //Forma correcta de acceder a una constante
        System.out.println("Fabricante : "+IPhone.SISTEMA_OPERATIVO);

        /*
        Si cambias el valor de un atributo estatico, en consecuencia todas sus instancias tambian reciben ese cambio

        Al ser inmutable no se puede cambiar
         */

        //Valores de instancia son distintos en cada instancia
        System.out.println("Color : "+i1.getColor());
        System.out.println("Color : "+i2.getColor());
        System.out.println("Color : "+i3.getColor());
        System.out.println("Color : "+i4.getColor());

        /*
        Static --> permite crear miembros de clase (que pertenecen al concepto de la clase)
        definiendoles un valor inicial

        final: impide que un miembro sea reasignado
        //1: attribute : permite crear constantes
        //2: metodo : impide la sobreescritura
        //3: Clase : no puedes especializarla o heredarla. Bloqueas la clase.
         */
    }
}