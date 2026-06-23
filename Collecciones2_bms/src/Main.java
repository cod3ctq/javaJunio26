import java.io.ObjectOutput;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    /*
    Listas --> .add() .get() .remove() .size() .contains() .indexOf() .lastindexOf() .toArray() .clear() .isEmpty() .set()
    Son dinamicas: Crecen y/o reducirse en tiempo de ejecucion. Permiten valores duplicados
    * List vs ArrayList : List es una interface, Arraylist es una clase
    # ArrayList es un tipo especifico de lista, una clase que implementa la interface List
    # Las listas son parametrizables: Necesita que definas el tipo de dato que los objetos que almacenara
     */

        //Declaracion del array
        List<String> lista = new ArrayList<String>(); //Lista de objetos personalizados
        List<Ciudad> ciudades = new ArrayList<Ciudad>(); //Lista de objetos personalizados
        //anade elementos personalizados a la lista
        ciudades.add(new Ciudad("Villa Allende", "Veracruz",827882,"industria",3456,87654));

        Ciudad c1 = new Ciudad("Puebla", "Puebla", 1692181, "Industria Automotriz", 850.5, 534.32);
        Ciudad c2 = new Ciudad("Guadalajara", "Jalisco", 1385621, "Tecnologia", 1200.8, 151.42);
        Ciudad c3 = new Ciudad("Monterrey", "Nuevo Leon", 1142994, "Industria Manufacturera", 1800.3, 324.80);
        Ciudad c4 = new Ciudad("Tijuana", "Baja California", 1922523, "Comercio Internacional", 920.7, 637.00);
        Ciudad c5 = new Ciudad("Leon", "Guanajuato", 1721215, "Calzado", 610.2, 1219.67);
        Ciudad c6 = new Ciudad("Merida", "Yucatan", 995129, "Turismo", 430.9, 858.41);
        Ciudad c7 = new Ciudad("Queretaro", "Queretaro", 1045035, "Aeroespacial", 710.4, 363.90);
        Ciudad c8 = new Ciudad("Cancun", "Quintana Roo", 934189, "Turismo", 690.1, 1978.75);
        Ciudad c9 = new Ciudad("Toluca", "Estado de Mexico", 910608, "Industria", 560.3, 452.37);
        Ciudad c10 = new Ciudad("Chihuahua", "Chihuahua", 925762, "Manufactura", 670.8, 879.21);

        Ciudad c11 = new Ciudad("Aguascalientes", "Aguascalientes", 948990, "Automotriz", 520.7, 385.60);
        Ciudad c12 = new Ciudad("Saltillo", "Coahuila", 879958, "Automotriz", 610.4, 837.16);
        Ciudad c13 = new Ciudad("Hermosillo", "Sonora", 936263, "Mineria", 590.6, 168.30);
        Ciudad c14 = new Ciudad("Morelia", "Michoacan", 849053, "Servicios", 350.2, 78.10);
        Ciudad c15 = new Ciudad("Veracruz", "Veracruz", 607209, "Actividad Portuaria", 410.5, 241.00);
        Ciudad c16 = new Ciudad("Tuxtla Gutierrez", "Chiapas", 604147, "Comercio", 260.4, 412.40);
        Ciudad c17 = new Ciudad("Villahermosa", "Tabasco", 833907, "Petroleo", 730.9, 61.18);
        Ciudad c18 = new Ciudad("Culiacan", "Sinaloa", 808416, "Agricultura", 480.1, 475.00);
        Ciudad c19 = new Ciudad("Mazatlan", "Sinaloa", 501441, "Turismo", 290.8, 3068.50);
        Ciudad c20 = new Ciudad("Tepic", "Nayarit", 425924, "Comercio", 180.7, 167.00);

        Ciudad c21 = new Ciudad("Oaxaca", "Oaxaca", 715183, "Turismo", 275.4, 85.48);
        Ciudad c22 = new Ciudad("Durango", "Durango", 654876, "Mineria", 330.2, 342.00);
        Ciudad c23 = new Ciudad("Pachuca", "Hidalgo", 314331, "Servicios", 190.6, 195.30);
        Ciudad c24 = new Ciudad("Colima", "Colima", 157048, "Comercio", 110.8, 668.20);
        Ciudad c25 = new Ciudad("La Paz", "Baja California Sur", 292241, "Turismo", 210.9, 203.30);
        Ciudad c26 = new Ciudad("Campeche", "Campeche", 249623, "Petroleo", 230.4, 382.00);
        Ciudad c27 = new Ciudad("Zacatecas", "Zacatecas", 149607, "Mineria", 145.2, 255.60);
        Ciudad c28 = new Ciudad("Tlaxcala", "Tlaxcala", 98905, "Servicios", 85.7, 41.61);
        Ciudad c29 = new Ciudad("Cuernavaca", "Morelos", 378476, "Turismo", 220.3, 207.90);
        Ciudad c30 = new Ciudad("San Luis Potosi", "San Luis Potosi", 911908, "Industria Automotriz", 780.5, 1443.14);


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
        ciudades.add(c26);
        ciudades.add(c27);
        ciudades.add(c28);
        ciudades.add(c29);
        ciudades.add(c30);

        //tamano de la lista
//        System.out.println("Ciudades en la lista: "+ciudades.size());

        //Obtener un elemento en una posicion especifica
//        System.out.println(ciudades.get(10));

        //Eliminar un elemento
//        ciudades.remove(15);

        //eliminar por referencia
//        ciudades.remove(c16);

        //Comprobar si un elemento se encuentra dentro de la lista
//        System.out.println("Existe ? : "+ciudades.contains(c5));

        //devuelve la posicion donde encuentra eel elemento por 1ra vez
//        System.out.println(ciudades.indexOf(c20));

        //devuelve la posicion de donde se encuentra el elemento la ultima vez
//        System.out.println(ciudades.lastIndexOf(c20));

        //toArray devuelve un array con los elementos de la lista
//        Object[] arr1 = lista.toArray();

        //casteo
//        System.out.println(Arrays.toString(arr1));
//
//        Object[] arr2 = ciudades.toArray();
//        System.out.println(Arrays.toString(arr2));

        //Vacia la lista
//        lista.clear();  //vacia la lista
//        System.out.println(lista.isEmpty());    //devuelve true si esta vacia la lista

        //#############################################################################

        Ciudad c =  null;
        //iterar sobre los elementos de la lista
//        for (int i = 0; i < ciudades.size(); i++) {
//            c = ciudades.get(i);
//            System.out.println(c);
            //System.out.println(ciudades.get(i).getNombre()+" : "+ ciudades.get(i).getActEco());

            //buscar las ciudades o una poblacion >= 15000
//            if(c.getHabitantes()>=900000){
//                System.out.println(c);
//            }

            //buscar las ciudades donde la actEco sea Manufactura
//            if(c.getActEco().equals("Manufactura")){
//                System.out.println(c);
//            }
//        }


        /*        for each           */
        //iteracion sobre los elementos de la lista
        for(Ciudad aux : ciudades) { //Por cada elemento(aux) dentro de ciudades (la lista)
            if(aux.getActEco().equals("Manufactura"))
                System.out.println(aux);
        }
    }
}