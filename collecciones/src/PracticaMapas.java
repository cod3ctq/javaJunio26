import java.util.HashMap;
import java.util.Map;

public class PracticaMapas {
    public static void main(String[] args){
        //Map es una estructura de asociacion llave:valor
        //Map vs HashMap
        //Mao es una interface
        //HasMap es una clase

        Map<String, Personas> registro = new HashMap<String, Personas>();

        registro.put("00001112ABC", new Personas("Kelly", "Martinez", "Luna", "19/10/2005", "Tijuana"));
        registro.put("00001113DEF", new Personas("Carlos", "Ruiz", "Alberto", "05/03/1998", "Puebla"));
        registro.put("00001114GHI", new Personas("Mariana", "Lopez", "Torres", "22/07/2001", "Monterrey"));
        registro.put("00001115JKL", new Personas("Fernando", "Diaz", "Perez", "14/11/1995", "Guadalajara"));
        registro.put("00001116MNO", new Personas("Sofia", "Hernandez", "Cruz", "30/01/2003", "Merida"));
        registro.put("00001117PQR", new Personas("Luis", "Garcia", "Antonio", "18/08/1997", "Veracruz"));
        registro.put("00001118STU", new Personas("Ana", "Mendoza", "Patricia", "09/05/2000", "Toluca"));
        registro.put("00001119VWX", new Personas("Ricardo", "Flores", "Soto", "27/12/1992", "Leon"));
        registro.put("00001120YZA", new Personas("Valeria", "Jimenez", "Rios", "11/06/2004", "Cancun"));
        registro.put("00001121BCD", new Personas("Jorge", "Vega", "Manuel", "02/09/1996", "Chihuahua"));

        registro.put("00001122EFG", new Personas("Daniela", "Ramirez", "Luna", "15/04/1999", "Queretaro"));
        registro.put("00001123HIJ", new Personas("Miguel", "Torres", "Angel", "28/10/1993", "Aguascalientes"));
        registro.put("00001124KLM", new Personas("Paola", "Sanchez", "Ortiz", "19/02/2002", "Cuernavaca"));
        registro.put("00001125NOP", new Personas("Eduardo", "Castillo", "Reyes", "07/07/1994", "Saltillo"));
        registro.put("00001126QRS", new Personas("Fernanda", "Morales", "Diaz", "24/03/2005", "Oaxaca"));
        registro.put("00001127TUV", new Personas("Alejandro", "Navarro", "Ruiz", "16/12/1991", "Morelia"));
        registro.put("00001128WXY", new Personas("Camila", "Vargas", "Luna", "13/08/2000", "Pachuca"));
        registro.put("00001129ZAB", new Personas("Roberto", "Herrera", "Flores", "21/05/1998", "Culiacan"));
        registro.put("00001130CDE", new Personas("Gabriela", "Mendoza", "Cruz", "10/01/2003", "Villahermosa"));
        registro.put("00001131FGH", new Personas("Hector", "Salazar", "Perez", "04/11/1990", "Durango"));

        registro.put("00001132IJK", new Personas("Natalia", "Romero", "Soto", "17/06/2001", "Tepic"));
        registro.put("00001133LMN", new Personas("Ivan", "Gutierrez", "Torres", "25/09/1997", "Colima"));
        registro.put("00001134OPQ", new Personas("Andrea", "Cabrera", "Ruiz", "08/02/2004", "Zacatecas"));
        registro.put("00001135RST", new Personas("Oscar", "Aguilar", "Lopez", "29/07/1995", "Reynosa"));
        registro.put("00001136UVW", new Personas("Monica", "Fuentes", "Hernandez", "12/12/1999", "Matamoros"));
        registro.put("00001137XYZ", new Personas("Raul", "Ortega", "Garcia", "06/04/1993", "Ensenada"));
        registro.put("00001138ABC", new Personas("Patricia", "Rojas", "Diaz", "20/10/2002", "La Paz"));
        registro.put("00001139DEF", new Personas("Diego", "Martinez", "Vega", "03/03/1996", "Campeche"));
        registro.put("00001140GHI", new Personas("Lucia", "Castillo", "Luna", "26/08/2005", "Tuxtla Gutierrez"));
        registro.put("00001141JKL", new Personas("Victor", "Moreno", "Perez", "14/01/1992", "Celaya"));

        registro.put("00001142MNO", new Personas("Elena", "Chavez", "Ruiz", "09/06/1998", "Irapuato"));
        registro.put("00001143PQR", new Personas("Arturo", "Santos", "Flores", "31/05/1994", "Uruapan"));
        registro.put("00001144STU", new Personas("Beatriz", "Jimenez", "Cruz", "22/11/2000", "Orizaba"));
        registro.put("00001145VWX", new Personas("Ruben", "Ramirez", "Torres", "18/02/1997", "Cordoba"));
        registro.put("00001146YZA", new Personas("Karla", "Mendoza", "Perez", "11/09/2003", "Coatzacoalcos"));
        registro.put("00001147BCD", new Personas("Sergio", "Vega", "Luna", "05/12/1991", "Tapachula"));
        registro.put("00001148EFG", new Personas("Veronica", "Herrera", "Diaz", "28/04/1999", "Ciudad Victoria"));
        registro.put("00001149HIJ", new Personas("Julio", "Rios", "Cesar", "16/07/1995", "Nogales"));
        registro.put("00001150KLM", new Personas("Diana", "Morales", "Soto", "23/03/2001", "Los Cabos"));
        registro.put("00001151NOP", new Personas("Martin", "Ortega", "Ruiz", "08/10/1996", "Mazatlan"));

        registro.put("00001152QRS", new Personas("Claudia", "Flores", "Perez", "01/05/2004", "Puerto Vallarta"));
        registro.put("00001153TUV", new Personas("Alberto", "Navarro", "Diaz",
                "13/08/1992", "Manzanillo"));
        registro.put("00001154WXY", new Personas("Jessica", "Torres", "Luna", "27/01/1998", "San Luis Potosi"));
        registro.put("00001155ZAB", new Personas("Francisco", "Castillo", "Cruz", "19/06/1993", "Ecatepec"));
        registro.put("00001156CDE", new Personas("Yadira", "Hernandez", "Flores", "07/11/2000", "Nezahualcoyotl"));
        registro.put("00001157FGH", new Personas("Gerardo", "Mendoza", "Ruiz", "30/09/1997", "Tlalnepantla"));
        registro.put("00001158IJK", new Personas("Silvia", "Romero", "Perez", "15/04/2002", "Chimalhuacan"));
        registro.put("00001159LMN", new Personas("Mauricio", "Salazar", "Luna", "24/12/1994", "Mexicali"));
        registro.put("00001160OPQ", new Personas("Lorena", "Gutierrez", "Diaz", "02/07/2005", "Hermosillo"));
        registro.put("00001161RST", new Personas("Adrian", "Cabrera", "Flores", "17/03/1999", "Torreon"));
        //imprimir tamaño de un mapa
        System.out.println(registro.size());

        //obtener un valor del mapa
        System.out.println(registro.get("0001"));//"0001","juanito pistolas"

        //eliminar elemento d'mediante ka kkave
        registro.remove("0003");
       // System.out.println("elemtos despues de la primera eliinacion: "+ registro.size());
        //eliminar un elemento mediante solo si la llave esta asociada a un valor
        registro.remove("0002","juanito pistolas2");


        //exiate llave?
        System.out.println(registro.containsKey("0001"));

        //exite valor?
        //System.out.println(registro.containsValue("00001160OPQ"));

        System.out.println("---------------------------------");
        //itera sobree ek conjunto de llaves
        for (String key:registro.keySet()){
            //imprime el valor asociado ala llave actualmente iterada
            //System.out.println(registro.get(key));
            for(Personas p:registro.values()){
            //imprimir las personas que su appellido paterno termine con ez
            //y su ligar de origen comienze cin una C
//            if (registro.get(key).getApellidoPat().endsWith("ez")) &&
//            (registro.get(key).getLugarOrigen().startsWith("c"))){
//                System.out.println(p);
//            }
        //    {
               // System.out.println(registro.get(key));

                System.out.println(p.getFechaNac().substring(6, p.getFechaNac().length()-1));
                if(p.getFechaNac().substring(6, p.getFechaNac().length()).startsWith("2")){
                    System.out.println(p);
                }

            }

        }

//imprimir las personas nacidas den el 2000 o despues



    }
}
