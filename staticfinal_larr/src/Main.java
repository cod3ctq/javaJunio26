//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // static : Crea miembros de clase (convalores compartidos por todas sus instancias).
        // final : Aplica la inmutabilidad (define valores que no cambian).

        CajaCobro cc1 = new CajaCobro("A01","Carlos");
        CajaCobro cc2 = new CajaCobro("A02","Luis");
        CajaCobro cc3 = new CajaCobro("A03","Guillermo");
        CajaCobro cc4 = new CajaCobro("A04","Sara");


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
//        System.out.println("Total vendido caja 1: "+cc1.getVentaIndividual());
//        System.out.println("Total vendido caja 2: "+cc2.getVentaIndividual());
//        System.out.println("Total vendido caja 3: "+cc3.getVentaIndividual());
//        System.out.println("Total vendido caja 4: "+cc4.getVentaIndividual());
//
//        // Imprimir el total de las ventas
//        System.out.println("Total vendido: "+cc3.getVentaGlobal());
//        System.out.println("ventas realizadas: "+cc1.getNumVentas());
//
//
//        //Los miembros estáticos de una clase pueden ser accedidos sin crear una nueva instancia de la clase,
//        //Solamente llamando a la propia clase.
////        System.out.println(CajaCobro.getVentaGlobal()); // A traves del Getter
////        System.out.println(CajaCobro.ventaGlobal); // de manera directa al atributo

        //-----------------------------------------------------------------------------------------------------------

        Iphone i1 = new Iphone(150,"Blanco", 20000,"Huella");
        Iphone i2 = new Iphone(130,"Oro", 25000,"Face Id");
        Iphone i3 = new Iphone(110,"Azul", 18000,"Boton");
        Iphone i4 = new Iphone(160,"Rojo", 22000,"Huella");

        System.out.println("Fabricante es: "+Iphone.getFabricante()); // Acceso directamente desde la clase
        System.out.println("Fabricante: "+i1.getFabricante());
        System.out.println("Fabricante: "+i2.getFabricante());
        System.out.println("Fabricante: "+i3.getFabricante());
        System.out.println("Fabricante: "+i4.getFabricante());


        //Valores de instancia son distintos en cada instancia
        System.out.println("Color: "+i1.getColor());
        System.out.println("Color: "+i2.getColor());
        System.out.println("Color: "+i3.getColor());
        System.out.println("Color: "+i4.getColor());

//        //Si cambias el valor de un atributo estático, en cuencia todas susinstancias también reciben ese cambio
//        Iphone.SISTEMA_OPERATIVO = "Maemo"; // Al ser inmutable; no se puede reasignar.

        System.out.println("sistema operativo: "+i1.SISTEMA_OPERATIVO);
        System.out.println("sistema operativo: "+i2.SISTEMA_OPERATIVO);
        System.out.println("sistema operativo: "+i3.SISTEMA_OPERATIVO);
        System.out.println("sistema operativo: "+i4.SISTEMA_OPERATIVO);

        //Forma correcta de acceder a una constante

        System.out.println("Sistema operativo: "+Iphone.SISTEMA_OPERATIVO);


        // Static permite crear/establecer miembros de clase (que pertenecen al concepto de la clase)
        // definiendoles un valor/comportamiento inicial

        // final : impide que un miembro sea reasignado.
        // 1.- ATRIBUTO : Permite crear CONSTANTES.
        // 2.- METODO : Impide la SOBREESCRITURA.
        // 3.- CLASE : Bloquea la HERENCIA. // Puedes ccrear objetos, pero NO puedes especializarla


    }
}