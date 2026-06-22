import jdk.swing.interop.SwingInterOpUtils;

public class Main {
    public static void main(String[] args) {
        //static : crea miembros de clase ( con valores compartidos por todas sus instancias )
        //final : Aplica la inmutabilidad (define valores que no cambian)


        // Cada instancia decide los valores para los atributos de istancia
        CajaCobro cc1 = new CajaCobro("A01","Carlos");
        CajaCobro cc2 = new CajaCobro("A02","Luis");
        CajaCobro cc3 = new CajaCobro("A03","Guillermo");
        CajaCobro cc4 = new CajaCobro("A04","Sara");


        cc1.registrarVenta(50);
        cc2.registrarVenta(30);
        cc3.registrarVenta(450);
        cc1.registrarVenta(645);
        cc2.registrarVenta(345);
        cc2.registrarVenta(5345);
        cc2.registrarVenta(3456);
        cc1.registrarVenta(345764);
        cc3.registrarVenta(3245);
        cc1.registrarVenta(2345);
        cc1.registrarVenta(2345);
        cc3.registrarVenta(123);
        cc2.registrarVenta(536);
        cc3.registrarVenta(785);
        cc1.registrarVenta(5454);
        cc3.registrarVenta(547);
        cc2.registrarVenta(342);
        cc1.registrarVenta(456);




        System.out.println("Total vendido caja1 : "+ cc1.getVentaIndividual());
        System.out.println("Total vendido caja2 : "+ cc2.getVentaIndividual());
        System.out.println("Total vendido caja3 : "+ cc3.getVentaIndividual());
        System.out.println("Total vendido caja4 : "+ cc4.getVentaIndividual());


        //Imprime el total de las ventas
        System.out.println("Total vendido caja1 : "+ cc4.getVentaGlobal());
        System.out.println("Ventas realizadas  : " +cc4.getVentaIndividual());
        System.out.println("Ventas realizadas  : " +cc1.getNumVentas());


        //Los miembros estaticos de una clase pueden ser accedidos
        //sin crear una nueva instancia de la clase, solamete llamando
        //a la propia clase


        System.out.println(CajaCobro.getVentaGlobal());// a traves del getter
        System.out.println(CajaCobro.ventaGlobal);//  de manera direct al atributo



//-----------------------------------------------------------------------------------------------------


        Iphone i1 = new Iphone("Blanco", 150, 20000, "Huella");
        Iphone i2 = new Iphone("rojo", 170, 25000, "fid");
        Iphone i3 = new Iphone("verde", 180, 29000, "Huella");
        Iphone i4= new Iphone("plata", 190, 30000, "faceid");

        System.out.println(Iphone.getFabricante()); //acceso directo desde la clase
        System.out.println("Fabricante : "+i1.getFabricante());
        System.out.println("Fabricante : "+i2.getFabricante());
        System.out.println("Fabricante : "+i3.getFabricante());
        System.out.println("Fabricante : "+i4.getFabricante());


        System.out.println("Fabricante : "+i1.getColor());
        System.out.println("Fabricante : "+i2.getColor());
        System.out.println("Fabricante : "+i3.getColor());
        System.out.println("Fabricante : "+i4.getColor());




        System.out.println("Sitema Operativo : "+i1.SISTEMA_OPERATIVO);
        System.out.println("Sitema Operativo : "+i2.SISTEMA_OPERATIVO);
        System.out.println("Sitema Operativo : "+i3.SISTEMA_OPERATIVO);
        System.out.println("Sitema Operativo : "+i4.SISTEMA_OPERATIVO);


        //Forma correcta de acceder a una constante
        System.out.println("Sistema operativo :" +Iphone.SISTEMA_OPERATIVO);

        // si cambias el valor de un atributo estatico en consecuencia
        //todas sus instancias tambien recibiran ese cambio
        //Iphone.SISTEMA_OPERATIVO = "Maemo"; al ser inmutable no se puede reasignar

//
//        Iphone.SISTEMA_OPERATIVO = "maemo";
//
//        System.out.println("Sitema Operativo : "+i1.SISTEMA_OPERATIVO);
//        System.out.println("Sitema Operativo : "+i2.SISTEMA_OPERATIVO);
//        System.out.println("Sitema Operativo : "+i3.SISTEMA_OPERATIVO);
//        System.out.println("Sitema Operativo : "+i4.SISTEMA_OPERATIVO);
        // Static permite crear /establecer miembros de clase (que pertenecen al concepto de clase
        //definiendoles un valor inicial


        // final : impide que un miembro sea reasignado

        //1- Atributo : crear constantes
        //2- Metodo : impide la sobrescritura
        //3- Clase : Bloque la herencia 


//







    }
}
