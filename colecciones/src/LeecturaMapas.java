import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeecturaMapas {

    public static void main(String[] args) {


        File file = new File("C:\\Users\\forti\\Downloads\\autos.txt");
        String linea="";
        Map<String, List<Automovil>> categorias = new HashMap<String,List<Automovil>>();
        Automovil auto =null;


        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String[] datos;



            while( (linea=br.readLine()) != null){

                datos = linea.split("-");
                      //Crear el objeto de tipo personalizado
                auto = new Automovil(datos[0],datos[1],Integer.parseInt(datos[2]),
                Double.parseDouble(datos[3]),datos[4],datos[5],datos[6]);



                //organizo por tipos de autos (SEDAN SUV HATCHABCK, COOUPE

                     //Checar si ya existe la llave (categoria ) en el mapa
                if(!categorias.containsKey(auto.getTipo())) {
                    //agregar la llave y su lista asociada


                    categorias.put(auto.getTipo(), new ArrayList<Automovil>());
                    categorias.get(auto.getTipo()).add(auto);//añade el objeto a la lista correcta


                    }else{
                    //En este punto ya existe lacategoria (key)
                    //entonces accede a la lista asociada para añadir el objeto auto
                    categorias.get(auto.getTipo()).add(auto);

                }


            }
        }catch (Exception ex){
            ex.printStackTrace();

        }
        //Imprime los datos de los autos, separados por categorias
        for (String key:categorias.keySet()){
            System.out.println("Categoria: "+key+"<<<<");
            for (Automovil au : categorias.get(key)){
                System.out.println(au);
            }
        }


    }

}
