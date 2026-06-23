import java.util.HashMap;
import java.util.Map;

public class PracticaMapas {
    public static void main(String[] args) {
        //Maps es unaestructura de asociacion llave: valor
        //Maps vs HashMap
        //Map es unainterface
        //HashMap es una clase

        //    k        v
//        Map<String, String> registro = new HashMap<String,String>();
        //agregar registro(key:value) al mapa
//        registro.put("00001111ABC","Juanito Perez Jhonson 12/03/1990 Toluca");
//        registro.put("00001111ABD","Juanito2 Perez2 Jhonson2 12/03/1990 Toluca");
//        registro.put("00001112ABC","Juanito3 Perez3 Jhonson3 12/03/1990 Toluca");
//        registro.put("00001113ABC","Juanito4 Perez4 Jhonson3 12/03/1990 Toluca");
//        registro.put("00001114ABC","Juanito5 Perez5 Jhonson3 12/03/1990 Toluca");
//
//        registro.put("00001112ABC","Kelly Martinez Luna 19/10/2005 Tijuana");
//        registro.put("00001113DEF","Carlos Alberto Ruiz 05/03/1998 Puebla");
//        registro.put("00001114GHI","Mariana Lopez Torres 22/07/2001 Monterrey");
//        registro.put("00001115JKL","Fernando Diaz Perez 14/11/1995 Guadalajara");
//        registro.put("00001116MNO","Sofia Hernandez Cruz 30/01/2003 Merida");
//        registro.put("00001117PQR","Luis Antonio Garcia 18/08/1997 Veracruz");
//        registro.put("00001118STU","Ana Patricia Mendoza 09/05/2000 Toluca");
//        registro.put("00001119VWX","Ricardo Flores Soto 27/12/1992 Leon");
//        registro.put("00001120YZA","Valeria Jimenez Rios 11/06/2004 Cancun");
//        registro.put("00001121BCD","Jorge Manuel Vega 02/09/1996 Chihuahua");
//        registro.put("00001122EFG","Daniela Ramirez Luna 15/04/1999 Queretaro");
//        registro.put("00001123HIJ","Miguel Angel Torres 28/10/1993 Aguascalientes");
//        registro.put("00001124KLM","Paola Sanchez Ortiz 19/02/2002 Cuernavaca");
//        registro.put("00001125NOP","Eduardo Castillo Reyes 07/07/1994 Saltillo");
//        registro.put("00001126QRS","Fernanda Morales Diaz 24/03/2005 Oaxaca");
//        registro.put("00001127TUV","Alejandro Navarro Ruiz 16/12/1991 Morelia");
//        registro.put("00001128WXY","Camila Vargas Luna 13/08/2000 Pachuca");
//        registro.put("00001129ZAB","Roberto Herrera Flores 21/05/1998 Culiacan");
//        registro.put("00001130CDE","Gabriela Mendoza Cruz 10/01/2003 Villahermosa");
//        registro.put("00001131FGH","Hector Salazar Perez 04/11/1990 Durango");
//        registro.put("00001132IJK","Natalia Romero Soto 17/06/2001 Tepic");
//        registro.put("00001133LMN","Ivan Gutierrez Torres 25/09/1997 Colima");
//        registro.put("00001134OPQ","Andrea Cabrera Ruiz 08/02/2004 Zacatecas");
//        registro.put("00001135RST","Oscar Aguilar Lopez 29/07/1995 Reynosa");
//        registro.put("00001136UVW","Monica Fuentes Hernandez 12/12/1999 Matamoros");
//        registro.put("00001137XYZ","Raul Ortega Garcia 06/04/1993 Ensenada");
//        registro.put("00001138ABC","Patricia Rojas Diaz 20/10/2002 LaPaz");
//        registro.put("00001139DEF","Diego Martinez Vega 03/03/1996 Campeche");
//        registro.put("00001140GHI","Lucia Castillo Luna 26/08/2005 TuxtlaGutierrez");
//        registro.put("00001141JKL","Victor Moreno Perez 14/01/1992 Celaya");
//        registro.put("00001142MNO","Elena Chavez Ruiz 09/06/1998 Irapuato");
//        registro.put("00001143PQR","Arturo Santos Flores 31/05/1994 Uruapan");
//        registro.put("00001144STU","Beatriz Jimenez Cruz 22/11/2000 Orizaba");
//        registro.put("00001145VWX","Ruben Ramirez Torres 18/02/1997 Cordoba");
//        registro.put("00001146YZA","Karla Mendoza Perez 11/09/2003 Coatzacoalcos");
//        registro.put("00001147BCD","Sergio Vega Luna 05/12/1991 Tapachula");
//        registro.put("00001148EFG","Veronica Herrera Diaz 28/04/1999 CiudadVictoria");
//        registro.put("00001149HIJ","Julio Cesar Rios 16/07/1995 Nogales");
//        registro.put("00001150KLM","Diana Morales Soto 23/03/2001 LosCabos");
//        registro.put("00001151NOP","Martin Ortega Ruiz 08/10/1996 Mazatlan");
//        registro.put("00001152QRS","Claudia Flores Perez 01/05/2004 PuertoVallarta");
//        registro.put("00001153TUV","Alberto Navarro Diaz 13/08/1992 Manzanillo");
//        registro.put("00001154WXY","Jessica Torres Luna 27/01/1998 SanLuisPotosi");
//        registro.put("00001155ZAB","Francisco Castillo Cruz 19/06/1993 Ecatepec");
//        registro.put("00001156CDE","Yadira Hernandez Flores 07/11/2000 Nezahualcoyotl");
//        registro.put("00001157FGH","Gerardo Mendoza Ruiz 30/09/1997 Tlalnepantla");
//        registro.put("00001158IJK","Silvia Romero Perez 15/04/2002 Chimalhuacan");
//        registro.put("00001159LMN","Mauricio Salazar Luna 24/12/1994 Mexicali");
//        registro.put("00001160OPQ","Lorena Gutierrez Diaz 02/07/2005 Hermosillo");
//        registro.put("00001161RST","Adrian Cabrera Flores 17/03/1999 Torreon");

        //IMPRIMIR
//        System.out.println(registro.size());
        //valor del mapa
//        System.out.println(registro.get("00001111ABC"));
        //Eliminar un alemento
//        registro.remove("00001113ABC");
//        System.out.println("Elemento despues de la primer eliminacion : "+registro.size());

        //eliminar un elemento mediante solo si la llave esta asociada a ese valor
//        registro.remove("00001114ABC","Juanito Perez Jhonson 12/03/1990 Toluca");
//        System.out.println("Elemento despues de la primer eliminacion : "+registro.size());

        //eliminar un elemento mediante solo si la llave esta asociada a ese valor
//        registro.remove("00001114ABC","Juanito5 Perez5 Jhonson3 12/03/1990 Toluca");
//        System.out.println("Elemento despues de la primer eliminacion : "+registro.size());

        //Existe la llave?
//        System.out.println(registro.containsKey("00001111ABD"));

        //existe el valor
//        System.out.println(registro.containsValue("Juanito3 Perez3 Jhonson3 12/03/1990 Toluca"));

        Map<String, Persona> registro = new HashMap<String, Persona>();

        //data
        registro.put("00001112ABC", new Persona("Kelly", "Martinez", "Luna", "19/10/2005", "Tijuana"));
        registro.put("00001113DEF", new Persona("Carlos", "Ruiz", "Alberto", "05/03/1998", "Puebla"));
        registro.put("00001114GHI", new Persona("Mariana", "Lopez", "Torres", "22/07/2001", "Monterrey"));
        registro.put("00001115JKL", new Persona("Fernando", "Diaz", "Perez", "14/11/1995", "Guadalajara"));
        registro.put("00001116MNO", new Persona("Sofia", "Hernandez", "Cruz", "30/01/2003", "Merida"));
        registro.put("00001117PQR", new Persona("Luis", "Garcia", "Antonio", "18/08/1997", "Veracruz"));
        registro.put("00001118STU", new Persona("Ana", "Mendoza", "Patricia", "09/05/2000", "Toluca"));
        registro.put("00001119VWX", new Persona("Ricardo", "Flores", "Soto", "27/12/1992", "Leon"));
        registro.put("00001120YZA", new Persona("Valeria", "Jimenez", "Rios", "11/06/2004", "Cancun"));
        registro.put("00001121BCD", new Persona("Jorge", "Vega", "Manuel", "02/09/1996", "Chihuahua"));

        registro.put("00001122EFG", new Persona("Daniela", "Ramirez", "Luna", "15/04/1999", "Queretaro"));
        registro.put("00001123HIJ", new Persona("Miguel", "Torres", "Angel", "28/10/1993", "Aguascalientes"));
        registro.put("00001124KLM", new Persona("Paola", "Sanchez", "Ortiz", "19/02/2002", "Cuernavaca"));
        registro.put("00001125NOP", new Persona("Eduardo", "Castillo", "Reyes", "07/07/1994", "Saltillo"));
        registro.put("00001126QRS", new Persona("Fernanda", "Morales", "Diaz", "24/03/2005", "Oaxaca"));
        registro.put("00001127TUV", new Persona("Alejandro", "Navarro", "Ruiz", "16/12/1991", "Morelia"));
        registro.put("00001128WXY", new Persona("Camila", "Vargas", "Luna", "13/08/2000", "Pachuca"));
        registro.put("00001129ZAB", new Persona("Roberto", "Herrera", "Flores", "21/05/1998", "Culiacan"));
        registro.put("00001130CDE", new Persona("Gabriela", "Mendoza", "Cruz", "10/01/2003", "Villahermosa"));
        registro.put("00001131FGH", new Persona("Hector", "Salazar", "Perez", "04/11/1990", "Durango"));

        registro.put("00001132IJK", new Persona("Natalia", "Romero", "Soto", "17/06/2001", "Tepic"));
        registro.put("00001133LMN", new Persona("Ivan", "Gutierrez", "Torres", "25/09/1997", "Colima"));
        registro.put("00001134OPQ", new Persona("Andrea", "Cabrera", "Ruiz", "08/02/2004", "Zacatecas"));
        registro.put("00001135RST", new Persona("Oscar", "Aguilar", "Lopez", "29/07/1995", "Reynosa"));
        registro.put("00001136UVW", new Persona("Monica", "Fuentes", "Hernandez", "12/12/1999", "Matamoros"));
        registro.put("00001137XYZ", new Persona("Raul", "Ortega", "Garcia", "06/04/1993", "Ensenada"));
        registro.put("00001138ABC", new Persona("Patricia", "Rojas", "Diaz", "20/10/2002", "La Paz"));
        registro.put("00001139DEF", new Persona("Diego", "Martinez", "Vega", "03/03/1996", "Campeche"));
        registro.put("00001140GHI", new Persona("Lucia", "Castillo", "Luna", "26/08/2005", "Tuxtla Gutierrez"));
        registro.put("00001141JKL", new Persona("Victor", "Moreno", "Perez", "14/01/1992", "Celaya"));

        registro.put("00001142MNO", new Persona("Elena", "Chavez", "Ruiz", "09/06/1998", "Irapuato"));
        registro.put("00001143PQR", new Persona("Arturo", "Santos", "Flores", "31/05/1994", "Uruapan"));
        registro.put("00001144STU", new Persona("Beatriz", "Jimenez", "Cruz", "22/11/2000", "Orizaba"));
        registro.put("00001145VWX", new Persona("Ruben", "Ramirez", "Torres", "18/02/1997", "Cordoba"));
        registro.put("00001146YZA", new Persona("Karla", "Mendoza", "Perez", "11/09/2003", "Coatzacoalcos"));
        registro.put("00001147BCD", new Persona("Sergio", "Vega", "Luna", "05/12/1991", "Tapachula"));
        registro.put("00001148EFG", new Persona("Veronica", "Herrera", "Diaz", "28/04/1999", "Ciudad Victoria"));
        registro.put("00001149HIJ", new Persona("Julio", "Rios", "Cesar", "16/07/1995", "Nogales"));
        registro.put("00001150KLM", new Persona("Diana", "Morales", "Soto", "23/03/2001", "Los Cabos"));
        registro.put("00001151NOP", new Persona("Martin", "Ortega", "Ruiz", "08/10/1996", "Mazatlan"));

        registro.put("00001152QRS", new Persona("Claudia", "Flores", "Perez", "01/05/2004", "Puerto Vallarta"));
        registro.put("00001153TUV", new Persona("Alberto", "Navarro", "Diaz", "13/08/1992", "Manzanillo"));
        registro.put("00001154WXY", new Persona("Jessica", "Torres", "Luna", "27/01/1998", "San Luis Potosi"));
        registro.put("00001155ZAB", new Persona("Francisco", "Castillo", "Cruz", "19/06/1993", "Ecatepec"));
        registro.put("00001156CDE", new Persona("Yadira", "Hernandez", "Flores", "07/11/2000", "Nezahualcoyotl"));
        registro.put("00001157FGH", new Persona("Gerardo", "Mendoza", "Ruiz", "30/09/1997", "Tlalnepantla"));
        registro.put("00001158IJK", new Persona("Silvia", "Romero", "Perez", "15/04/2002", "Chimalhuacan"));
        registro.put("00001159LMN", new Persona("Mauricio", "Salazar", "Luna", "24/12/1994", "Mexicali"));
        registro.put("00001160OPQ", new Persona("Lorena", "Gutierrez", "Diaz", "02/07/2005", "Hermosillo"));
        registro.put("00001161RST", new Persona("Adrian", "Cabrera", "Flores", "17/03/1999", "Torreon"));


        //Itera sobre el conjunto de llaves
//        for(String key:registro.keySet()){

        //imprime el valor asociado a la llave actualmente iterada
//            System.out.println(registro.get(key));

        //Imprimir las personas que su apellido paterno perminen con 'ez'
//            if(registro.get(key).getApellidoPat().endsWith("ez")){
//                System.out.println(registro.get(key));
//            }

        //Imprime las personas que su lugar de origen inicie con C
//            if(registro.get(key).getLugarOrigen().startsWith("C")){
//                System.out.println(registro.get(key));
//            }

        //Las ainteriores pero unidas
//            if(registro.get(key).getApellidoPat().endsWith("ez") && registro.get(key).getLugarOrigen().startsWith("C")){
//                System.out.println(registro.get(key));
//            }
//    }

        //Itera sobre el conjunto de llaves
        for(Persona p:registro.values()) { //value() devuelve el conjunto de valores asociados
            //imprime el valor asociado a la llave actualmente iterada
//          System.out.println(registro.values(p));

            //Imprimir las personas que su apellido paterno perminen con 'ez'
            if (p.getApellidoPat().endsWith("ez") && p.getLugarOrigen().startsWith("C")) {
                System.out.println(p);
            }

            //imprimir las personas nacidas en el 2000 o despues
//            if(p.getFechaNac().substring()){
//            }
//            System.out.println(p.getFechaNac().substring(6,10));
            System.out.println(p.getFechaNac().substring(6,p.getFechaNac().length()).startsWith("2"));
            System.out.println(p);

        } //end for each
    } //end main
} //end class
