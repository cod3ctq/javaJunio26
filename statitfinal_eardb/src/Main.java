//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //static: crea miembros de clases (con valores compoartidos por todas sus instancias)
        //final : Aplica la inmutabilidad (define valores que no cambian)
//
//        CajaCobro cc1=new CajaCobro("A01","Carlos");
//        CajaCobro cc2=new CajaCobro("A02","Luis");
//        CajaCobro cc3=new CajaCobro("A03","Guillermo");
//        CajaCobro cc4 = new CajaCobro("A04","Sara");
//
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
//        System.out.println("Total Vendido caja 1"+cc1.getVentaIndividual());
//        System.out.println("Total Vendido caja 2"+cc2.getVentaIndividual());
//        System.out.println("Total Vendido caja 3"+cc3.getVentaIndividual());
//        System.out.println("Total Vendido caja 4"+cc4.getVentaIndividual());
//        //imprimir el tota de ventas
//        System.out.println("Total vendido: " +cc4.getVentaGlobal());
//        System.out.println("Vetas Realizadas: "+ cc1.getNumVentas());
//
//        //los miembros estatcos de una clase pueden ser accedidos
//        //sin crear una nueva instancia de la clase, solamente llamando
//        //ala propia clase
//        System.out.println(CajaCobro.getVentaGlobal());//atraves del getter
//        System.out.println(CajaCobro.ventaGlobal);// de manera directa al atributo
//

//--------------------------------------------------------
        iphone i1 = new iphone(150,"blanco",20000,"huella");
        iphone i2 = new iphone(130,"oro",18000,"face ID");
        iphone i3 = new iphone(120,"azul",27000,"Boton");
        iphone i4 = new iphone(170,"rojo",25000,"huella");
        System.out.println( iphone.getFabricante());//accedo desde la clase
        System.out.println("Fabricante : "+ i1.getFabricante());
        System.out.println("Fabricante : "+ i2.getFabricante());
        System.out.println("Fabricante : "+ i3.getFabricante());
        System.out.println("Fabricante : "+ i4.getFabricante());

        System.out.println("Fabricante : "+ i1.getColor());
        System.out.println("Fabricante : "+ i2.getColor());
        System.out.println("Fabricante : "+ i3.getColor());
        System.out.println("Fabricante : "+ i4.getColor());
    }
}