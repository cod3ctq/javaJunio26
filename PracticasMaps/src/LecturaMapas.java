import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class LecturaMapas {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\DELL\\IdeaProjects\\PracticasMaps\\file\\autos.txt");

        Map<String, List<Automovil>> categoria = new HashMap<String, List<Automovil>>();
        Automovil auto = null;

    

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            String[] datos;
            while ((line = br.readLine()) != null) {
                datos = line.split("-");
                // Process the data as needed
                auto = new Automovil(datos[0], datos[1], Integer.parseInt(datos[2]), Double.parseDouble(datos[3]), datos[4], datos[5], datos[6]);

                if (!categoria.containsKey(auto.getMarca())) {
                    categoria.put(auto.getMarca(), new ArrayList<Automovil>());
                }
                //para este punto ya exite la categoria get

                categoria.get(auto.getMarca()).add(auto);
            }

            for (String key : categoria.keySet()){
                System.out.println("Categoria: "+key);
                for (Automovil au : categoria.get(key)){
                    System.out.println(au);
                }
            }


            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
