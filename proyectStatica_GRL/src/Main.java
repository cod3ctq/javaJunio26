//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Iphone i2= new Iphone(150,"blanco",222222,"huella");
        Iphone i3= new Iphone(130,"blanco",252222,"huella");
        Iphone i4= new Iphone(110,"negro",223332,"boton");
        Iphone i5= new Iphone(111,"azul",30000,"huella");

        System.out.println(Iphone.getFabricante());// forma correcta de declarar esto
        System.out.println(i3.getFabricante());
        System.out.println(i4.getFabricante());
        System.out.println(i5.getFabricante());

        System.out.println(Iphone.getFabricante());
        System.out.println(i3.getFabricante());
        System.out.println(i4.getFabricante());
        System.out.println(i5.getFabricante());
    }

    public void supermercado(){
        cajaCobro cc3 = new cajaCobro("ane","Guillermo");
        cajaCobro cc2= new cajaCobro("abd","luis");
        cajaCobro cc1 =new cajaCobro("abc","carlod");
        cajaCobro cc4 = new cajaCobro("A04","Sara");

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

        System.out.println("totoal caja 1: "+cc1.ventaIndividual);
        System.out.println("totoal caja 2: "+cc2.ventaIndividual);
        System.out.println("totoal caja 3: "+cc3.ventaIndividual);
        System.out.println("totoal caja 4: "+cc4.ventaIndividual);

        System.out.println(cajaCobro.getNumVenta());
        System.out.println(cajaCobro.getVentaTotal());
    }
}


