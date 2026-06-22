//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // static: crea miembros de clase(con valores compartidos por todas sus instancias)
        // final: Aplica la inmutabilidad (define valores que no cambian)

//
//        //Cada instancia decide los valores para los atributos de instancia
//        CajaCobro cc1 = new CajaCobro("A01","Carlos");
//        CajaCobro cc2 = new CajaCobro("A02","Luis");
//        CajaCobro cc3 = new CajaCobro("A03","Guillermo");
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
//
//        System.out.println("Total vendido caja 1 : "+cc1.getVentaIndividual());
//        System.out.println("Total vendido caja 1 : "+cc2.getVentaIndividual());
//        System.out.println("Total vendido caja 1 : "+cc3.getVentaIndividual());
//        System.out.println("Total vendido caja 1 : "+cc4.getVentaIndividual());
//
//        //Imprimir el total de las ventas ($$)
//        System.out.println("Total vendido : "+cc3.getventaGlobal());
//        System.out.println("Ventas realizadas : "+cc1.getNumVentas());
//
//        //TIP Los miembros estaticos de una clase pueden ser accedidos
//        //sin crear una nueva instancia de la clse llamando
//        //a la propia clase
//
//
//        System.out.println(CajaCobro.getventaGlobal()); //a traces del getter
//        System.out.println(CajaCobro.ventaGlobal); //de manera directa del atributo


        //----------------------------------------------------------------------------------------

        Iphone i1 = new Iphone(150.00,"Blanco",20000,"huella");
        Iphone i2 = new Iphone(130,"oro",25000,"face ID");
        Iphone i3 = new Iphone(110,"azul",18000,"Boton");
        Iphone i4 = new Iphone(160,"rojo",22000,"huella");

        System.out.println(Iphone.getFabricante());//acceso directamente desde la clase
        System.out.println("Fabricante : "+i1.getFabricante());
        System.out.println("Fabricante : "+i2.getFabricante());
        System.out.println("Fabricante : "+i3.getFabricante());
        System.out.println("Fabricante : "+i4.getFabricante());


        //VALORES DE LA INSTANCIA SON DISTINTOS EN CADA INSTANCIS
        System.out.println("Color : "+i1.getColor());
        System.out.println("Color : "+i2.getColor());
        System.out.println("Color : "+i3.getColor());
        System.out.println("Color : "+i4.getColor());

        System.out.println("Sistema Operativo : "+i1.SISTEMA_OPERATIVO);
        System.out.println("Sistema Operativo : "+i2.SISTEMA_OPERATIVO);
        System.out.println("Sistema Operativo : "+i3.SISTEMA_OPERATIVO);
        System.out.println("Sistema Operativo : "+i4.SISTEMA_OPERATIVO);


        //Forma correcta de acceder a una constante
        System.out.println("Sistema Operativo : " + Iphone.SISTEMA_OPERATIVO);


        //SI CAMBIAS EL VALOR DE UN ATRIBUTO ESTATICO, EN CONSECUENCIA
        //TODAS SUS INSTANCIAS TAMBIEN RECIBEN EL CAMBIO
        // Iphone.SISTEMA_OPERATIVO= "MAEMO"; al ser inmutabe no se puede reasignar

//        System.out.println("Fabricante : "+i1.getSistemaOperativo());
//        System.out.println("Fabricante : "+i2.getSistemaOperativo());
//        System.out.println("Fabricante : "+i3.getSistemaOperativo());
//        System.out.println("Fabricante : "+i4.getSistemaOperativo());

        // Static permite crear/establecer miembros de clase (que pertenecen al concepto de la clase)
        //definiendoles un valor inicial

        //final: impide que un miembro sea reasignado
        //1.-Atributo : crear constantes
        //2.-Metodo : Impide la sobreescritura
        //3.-Clase : Bloquea la herencia 




    }
}