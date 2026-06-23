import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LecturaMapas {
    public static void main(String[] args) {

        File file = new File("C:\\Users\\luis_\\OneDrive\\Desktop\\Mapas\\autos.txt");
        String linea="";
        Map<String, List<Automovil>> categorias = new HashMap<String, List<Automovil>>();
        Automovil auto = null;

        try{
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String[] datos;

            while((linea = br.readLine()) != null){
                datos = linea.split("-");
                auto = new Automovil(datos[0],datos[1],Integer.parseInt(datos[2]),
                        Double.parseDouble(datos[3]),datos[4],datos[5],datos[6]);

                // Organizo el mapa por los tipos de auto (SEDAN, SUV, SEDAN, COUPE, HATCHBACK)


                // Verificar si ya existe la llave (categoria) en el mapa
                if(  ! categorias.containsKey(auto.getTipo())  ){

                    // Agregar la llave y su lista asociada (nueva, vacia)
                    categorias.put(auto.getTipo(), new ArrayList<Automovil>());
                    categorias.get(auto.getTipo()).add(auto); // Añadir el objeto a la lista correcta
                }else{
                    // En este punto ya existe la categoría (key) entonces accedo a la lista asociada para
                    // añadir el objeto auto.
                    categorias.get(auto.getTipo()).add(auto);

                } // Fin del if

                // Organizar un mapa por COLORES
                // Organizar un mapa por MARCAS
                // Organizar un mapa por TRANSMISION
                // Organizar un mapa por MARCA Y CATEGORIA

            } // Fin del While

        }catch(Exception ex){
            ex.printStackTrace();

        } // Fin del try

        // Imprime los datos de los autos, separados por categorias

        for(String key:categorias.keySet()){
            System.out.println("Categoria: "+key);
            for(Automovil au:categorias.get(key)){
                System.out.println(au);
            }
        }



    }
}
