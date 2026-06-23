import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        //listas
        // list vs ArrayList: list es una interface, ArrayList es una clase
        //Arraylist es un tipo especifico de lista, una clase que implementa la interface list
        //Parametrizable : Necsita que definas el tipo de dato de los objetos que almacenara
        List<String> lista = new ArrayList<String>();
        List<ciudad> ciudades = new ArrayList<ciudad>(); //Lista de objetos personalizados

        //TIP añade elementos a la lista
        lista.add("Hermosillo Sonora 243473 Industria Textil 9287748.00 238.5");
        lista.add("texto");
        lista.add("Java");
        lista.add("mensaje");
        lista.add("Java");
        lista.add("texto");
        lista.add("numeros");
        lista.add("puebla");
        lista.add("String");

        //TIP añade elementos personalizados a la lista
        ciudades.add(new ciudad("Villa Allende","Veracruz",827882,
                "Industria",354585,88734));


        ciudad c1 = new ciudad("Puebla", "Puebla", 1692181, "Industria Automotriz", 850.5, 534.32);
        ciudad c2 = new ciudad("Guadalajara", "Jalisco", 1385621, "Tecnologia", 1200.8, 151.42);
        ciudad c3 = new ciudad("Monterrey", "Nuevo Leon", 1142994, "Industria Manufacturera", 1800.3, 324.80);
        ciudad c4 = new ciudad("Tijuana", "Baja California", 1922523, "Comercio Internacional", 920.7, 637.00);
        ciudad c5 = new ciudad("Leon", "Guanajuato", 1721215, "Calzado", 610.2, 1219.67);
        ciudad c6 = new ciudad("Merida", "Yucatan", 995129, "Turismo", 430.9, 858.41);
        ciudad c7 = new ciudad("Queretaro", "Queretaro", 1045035, "Aeroespacial", 710.4, 363.90);
        ciudad c8 = new ciudad("Cancun", "Quintana Roo", 934189, "Turismo", 690.1, 1978.75);
        ciudad c9 = new ciudad("Toluca", "Estado de Mexico", 910608, "Industria", 560.3, 452.37);
        ciudad c10 = new ciudad("Chihuahua", "Chihuahua", 925762, "Manufactura", 670.8, 879.21);

        ciudad c11 = new ciudad("Aguascalientes", "Aguascalientes", 948990, "Automotriz", 520.7, 385.60);
        ciudad c12 = new ciudad("Saltillo", "Coahuila", 879958, "Automotriz", 610.4, 837.16);
        ciudad c13 = new ciudad("Hermosillo", "Sonora", 936263, "Mineria", 590.6, 168.30);
        ciudad c14 = new ciudad("Morelia", "Michoacan", 849053, "Servicios", 350.2, 78.10);
        ciudad c15 = new ciudad("Veracruz", "Veracruz", 607209, "Actividad Portuaria", 410.5, 241.00);
        ciudad c16 = new ciudad("Tuxtla Gutierrez", "Chiapas", 604147, "Comercio", 260.4, 412.40);
        ciudad c17 = new ciudad("Villahermosa", "Tabasco", 833907, "Petroleo", 730.9, 61.18);
        ciudad c18 = new ciudad("Culiacan", "Sinaloa", 808416, "Agricultura", 480.1, 475.00);
        ciudad c19 = new ciudad("Mazatlan", "Sinaloa", 501441, "Turismo", 290.8, 3068.50);
        ciudad c20 = new ciudad("Tepic", "Nayarit", 425924, "Comercio", 180.7, 167.00);

        ciudad c21 = new ciudad("Oaxaca", "Oaxaca", 715183, "Turismo", 275.4, 85.48);
        ciudad c22 = new ciudad("Durango", "Durango", 654876, "Mineria", 330.2, 342.00);
        ciudad c23 = new ciudad("Pachuca", "Hidalgo", 314331, "Servicios", 190.6, 195.30);
        ciudad c24 = new ciudad("Colima", "Colima", 157048, "Comercio", 110.8, 668.20);
        ciudad c25 = new ciudad("La Paz", "Baja California Sur", 292241, "Turismo", 210.9, 203.30);
        ciudad c26 = new ciudad("Campeche", "Campeche", 249623, "Petroleo", 230.4, 382.00);
        ciudad c27 = new ciudad("Zacatecas", "Zacatecas", 149607, "Mineria", 145.2, 255.60);
        ciudad c28 = new ciudad("Tlaxcala", "Tlaxcala", 98905, "Servicios", 85.7, 41.61);
        ciudad c29 = new ciudad("Cuernavaca", "Morelos", 378476, "Turismo", 220.3, 207.90);
        ciudad c30 = new ciudad("San Luis Potosi", "San Luis Potosi", 911908, "Industria Automotriz", 780.5, 1443.14);


        ciudades.add(c1);
        ciudades.add(c2);
        ciudades.add(c3);
        ciudades.add(c4);
        ciudades.add(c5);
        ciudades.add(c6);
        ciudades.add(c7);
        ciudades.add(c8);
        ciudades.add(c9);
        ciudades.add(c10);
        ciudades.add(c11);
        ciudades.add(c12);
        ciudades.add(c13);
        ciudades.add(c14);
        ciudades.add(c15);
        ciudades.add(c16);
        ciudades.add(c17);
        ciudades.add(c18);
        ciudades.add(c19);
        ciudades.add(c20);
        ciudades.add(c21);
        ciudades.add(c22);
        ciudades.add(c23);
        ciudades.add(c24);
        ciudades.add(c25);
        ciudades.add(c20);
        ciudades.add(c26);
        ciudades.add(c27);
        ciudades.add(c28);
        ciudades.add(c29);
        ciudades.add(c20);
        ciudades.add(c30);


        /// tamaño de la lista
//        System.out.println(lista.size());
        System.out.println("Ciudades en la lista: "+ciudades.size());


        /// obtener un elemento en una posicion en especifica
//        System.out.println(lista.get(6));
        System.out.println(ciudades.get(10));

        /// eliminar un elemento (POR INDICE)
//        lista.remove(3);
        ciudades.remove(15);

        /// eliminar un elemento (por referencia)
        //lista.remove("puebla");
        ciudades.remove(c16);
        System.out.println(ciudades.size());
        //System.out.println(ciudades.get(16));

        /// comprobar si existe un elemento dentro de la lista

        //System.out.println(lista.contains("java"));
        System.out.println("¿Existe? :"+ciudades.contains(c5));

        ///devuelve true o false dependiendo si se cumple o no

        /// devuelve la posicion donde se encuentra el elemento por 1era vez

        //System.out.println(lista.indexOf("Java"));
        System.out.println(ciudades.indexOf(c20));
        ///este solo devuelve el indice en donde aparece por primera vez

        ///.lastIndexOf te devuelve en donde aparece de nuevo la palabra o elemento que se busca
//        System.out.println(lista.lastIndexOf("Java"));
        System.out.println(ciudades.lastIndexOf(c20));

        ///metodo clear vacia la listq
        lista.clear();

        System.out.println(lista.isEmpty());
        ///is.Empty sirve para corroborar si realmente esta vaca la listo o no (arroja true o false)


        ///Devuelve un array con los elementos d ela lista
       Object[] arr1= lista.toArray();
        System.out.println(Arrays.toString(arr1));
       Object[] arr2 = ciudades.toArray();
        System.out.println(Arrays.toString(arr2));



        //------------------------------------------------------------------------------------------------------------------------------------------------

        //iterar sobre los elementos de la lista

        ciudad c = null;
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------");

        for (ciudad aux : ciudades){ //Por cada elemento (aux) dentro de ciudades (la lista)
            //c=ciudades.get(i);

            //System.out.println(c.getNombre()+" : "+c.getActEco());

            //Buscar las ciudades con una poblacion >=850000

//            if(c.getHabitantes()>=850000){
//                System.out.println(c);
//            }
            //Buscar las ciudades donde la actividad economica sea Manufactura

            if(aux.getActEco().equals("Manufactura")) {
                System.out.println(aux);
            }







        }
    }
}