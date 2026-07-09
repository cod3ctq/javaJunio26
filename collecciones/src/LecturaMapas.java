import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LecturaMapas {
    public static void main(String[] args){
        File file = new File("C:\\Users\\erik2\\Downloads");
        String linea ="";
        Map<String, List<Automovil>> categorias = new HashMap<String, List<Automovil>>();
        Automovil auto= null;
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String[] datos;
            while ((linea=br.readLine()) != null){
            datos = linea.split("-");
            //crea el onjeto de tipo personalizado
            auto = new Automovil(datos[0],datos[1],Integer.parseInt(datos[2]),
                    Double.parseDouble(datos[3]),datos[4],datos[5],datos[6]);
            //checar si ya existe (categoria) en el mapa
                if (! categorias.containsKey(auto.getTipo())) {
                    categorias.put(auto.getTipo(), new ArrayList<Automovil>());
                    categorias.get(auto.getTipo()).add(auto);//añade el objeto ala lista correxta


                }else{
                    categorias.get(auto.getTipo()).add(auto);
                }

            }
        }catch (Exception ex){
          ex.printStackTrace();
        }
        //imprime los datos delos autos, separados por ccategorias
        for (String key:categorias.keySet()){
            System.out.println("categoriaa : "+key);
            for (Automovil au : categorias.get(key)){
                System.out.println(au);
            }
        }
    }
}
