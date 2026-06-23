import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LecturaMapas {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\ThinkPad\\Documents\\Intellij\\CETEQ\\ProyectosJDK17\\Collecciones2_bms\\autos.txt");
        String linea="";
        Map<String, List<DasAuto>> categoria = new HashMap<String, List<DasAuto>>();
        DasAuto auto = null;
        try{
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String[] datos;
            while ((linea=br.readLine())!= null){
                datos = linea.split("-");
                auto = new DasAuto(datos[0],datos[1],Integer.parseInt(datos[2]),Double.parseDouble(datos[3]),datos[4],datos[5],datos[6]);

                //Se organizo los mapas por los tipos de autos

                //checar si ya existe la llave (categoria) en el mapa
                if(! categoria.containsKey(auto.getTipo())){
                    //agregar la llave y su lista asociada
                    categoria.put(auto.getTipo(), new ArrayList<DasAuto>());
                    categoria.get(auto.getTipo()).add(auto); //anade el objeto a la lista correcta
                } else{
                    //en este punto ya existe la categoria (key)
                    //entonces accedo a la lista asociada para anadir el objeto auto
                    categoria.get(auto.getTipo()).add(auto);
                }

                //organizar un mapa por COLORES
                //Organizar un mapa por MARCA
                //Organizar un mapa por transmision
                //Organizar un mapa por COLORES
                //Organizar un mapa por MARCAS Y CATEGORIAS
            }
        } catch(Exception ex){
            ex.printStackTrace();
        }

        //Imprime los datos de los autos, separados por categorias
        for(String key : categoria.keySet()){
            System.out.println("Categoria : "+ key);
            for (DasAuto au : categoria.get(key)){
                System.out.println(au);
            }
        }
    }

}
