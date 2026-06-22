//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //static : Crea mienbros de clase (con valores comprometidos por todas sus instancias)
        //final: Aplica la inmutabilidad (define valores que no cambian)

//
//        CajaCobro cc1 = new CajaCobro("A01","Carlos");
//        CajaCobro cc2 = new CajaCobro("A02","Luis");
//        CajaCobro cc3 = new CajaCobro("A03","Guillermo");
//        CajaCobro cc4 = new CajaCobro("A04","Baruc");
//
//        //
//        cc1.registrarVentas(50);
//        cc2.registrarVentas(30);
//        cc3.registrarVentas(450);
//        cc1.registrarVentas(645);
//        cc2.registrarVentas(345);
//        cc2.registrarVentas(5345);
//        cc2.registrarVentas(3456);
//        cc1.registrarVentas(345764);
//        cc3.registrarVentas(3245);
//        cc1.registrarVentas(2345);
//        cc1.registrarVentas(2345);
//        cc3.registrarVentas(123);
//        cc2.registrarVentas(536);
//        cc3.registrarVentas(785);
//        cc1.registrarVentas(5454);
//        cc3.registrarVentas(547);
//        cc2.registrarVentas(342);
//        cc1.registrarVentas(456);
//
//        System.out.println("Total vendido caja 1 : "+cc1.getventaIndividual());
//        System.out.println("Total vendido caja 2 : "+cc2.getventaIndividual());
//        System.out.println("Total vendido caja 3 : "+cc3.getventaIndividual());
//        System.out.println("Total vendido caja 4 : "+cc4.getventaIndividual());
//
//        // Imprimir el total de las ventas ($$)
//        System.out.println("Total vendido : "+cc3.getVentaGlobal());
//
//        System.out.println("Ventas realizadas : "+cc1.getNumVentas());
//
//        //Los miembros estaticoas de una clase pueden ser accedidos
//        // sin crear una nueva instancia de la calse, solamente llamando
//        //a la propia clase
//        System.out.println(CajaCobro.ventaGlobal);//de manera directa al atributo
//        System.out.println(CajaCobro.getVentaGlobal());// a traves del getters
//
        iphone i1 = new iphone(150,"blanco",20000,"Huella");
        iphone i2 = new iphone(130,"Oro",25000,"FAace Id");
        iphone i3 = new iphone(110,"Azul",18000,"Boton");
        iphone i4 = new iphone(160,"Rojo",22000,"Huella");

        System.out.println(iphone.getFabricante());// acceso directamente desde la clase
        System.out.println(" Fabricante : "+i1.getFabricante());
        System.out.println(" Fabricante : "+i2.getFabricante());
        System.out.println(" Fabricante : "+i3.getFabricante());
        System.out.println(" Fabricante : "+i4.getFabricante());

        //Valores de instancia son distintos en cada instancia

        System.out.println("Ssitema operativo :"+i1.SISTEMA_OPERATIVO);
        System.out.println("Ssitema operativo :"+i2.SISTEMA_OPERATIVO);
        System.out.println("Ssitema operativo :"+i3.SISTEMA_OPERATIVO);
        System.out.println("Ssitema operativo :"+i4.SISTEMA_OPERATIVO);

        //la forma correctade acceder a una constante
        System.out.println("Ssitema operativo :"+iphone.SISTEMA_OPERATIVO);

        //Si cambias el valor de un atributo, en consecuencia
        //todas sus instancias tambien reciben ese cambio
//        iphone.sistemaOperativo = "Maemo";
//
//        System.out.println("Ssitema operativo :"+i1.getSistemaOperativo());
//        System.out.println("Ssitema operativo :"+i2.getSistemaOperativo());
//        System.out.println("Ssitema operativo :"+i3.getSistemaOperativo());
//        System.out.println("Ssitema operativo :"+i4.getSistemaOperativo());
        //Static permite crear/establecer miembros de una clase (que pertenecen al concepto de la clase)
        //definiendoles valores/comportamniento inicial

        //final : Impide que un miembro sea reasignado
        //1.-Atributo : crear CONSTANTES
        //2.-Metodo : impide la sobreescritura
        //3.-Clase :Bloquea la herencia







    }
}