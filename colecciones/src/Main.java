import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        // Listas
        // .add
        //.remove
        //size

        // Listas
        // list vs arrayList : List es una interfase, ArrayList es una clase
        //ArrayList es un tipo especifico de lista, una clase que implementa la interfase list
        //Parametrizable : necesita que definas el tipo de dato de los objetos que almacena


        List<String> lista = new ArrayList<String>();
        List<Ciudad> ciudades = new ArrayList<Ciudad>(); //lista de objetos personalizados


        // añade elementos a la lista

        lista.add("Hermosilo Sonora 243474 Industria Textil 97287748.00 238.9");
        lista.add("texto");
        lista.add("Java");
        lista.add("mensaje");
        lista.add("Java");
        lista.add("texto");
        lista.add("numero");
        lista.add("puebla");
        lista.add("Java");
        lista.add("String");

        //añade elementos personalizados a la lista

        ciudades.add(new Ciudad("Villa Allende","Veracruz",554095,"Industri",43434,4343));
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
        ciudades.add(c20);
        ciudades.add(c28);
        ciudades.add(c29);
        ciudades.add(c30);


        // tamaño de la lista

        System.out.println(lista.size());

        //obtener un elemnto de una lista especifica
        System.out.println(lista.get(6));


        //Eliminar un elemento (por indice)
        lista.remove(3);
        ciudades.remove(15);

        System.out.println(lista.size());

        //Eliminar un objeto por referncia

//        lista.remove("puebla");
        ciudades.remove(c16);
        System.out.println(ciudades.size());

        System.out.println(ciudades.get(16));

        //Comprobamos si existen elementos dentro de la lista
        //
        System.out.println("Existe?  "+ciudades.contains(c5));

        //comprobar si existe un elemento dentro de la lista
        System.out.println(lista.contains("texto"));



        // devuelve la posicion donde encuentra el elemento por 1ra vez
        System.out.println(ciudades.indexOf("c20"));



        //devuelve la posicion donde encuentra el elemento por ultima vez
        System.out.println(lista.lastIndexOf("Java"));

        lista.clear(); //vacia la lista

        System.out.println(lista.isEmpty());

        //devuelve un array con los elemtos de la lista

        Object[] arr1 = lista.toArray();


        System.out.println(Arrays.toString(arr1));


        Object[] arr2 = ciudades.toArray();
        System.out.println(Arrays.toString(arr2));



        //-----------------------------------------------------------------------------------------
        //Iterar sobre los elementos de la lista

        Ciudad c = null;


        System.out.println("-------------------------------------------------------------------------------------------------------------------");

        for (Ciudad aux : ciudades){ //Por cada elemento aux dentro de cudades (la lista)

//            c = ciudades.get(i);


//            System.out.println(c.getNombre()+":"+c.getActEco());
// buscar ls ciudades con una poblacion  >=850000
//            if (c.getHabitantes()>=850000){
//                System.out.println(c);
//            }
             // Buscar las ciudades donde la acEco sea Manofactura
            if (aux.getNombre().equals("Manufactura")){
                System.out.println(aux);
            }



        }



    }
}
