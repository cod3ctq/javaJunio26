import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LecturaMapas {
    public static void main(String[] args) {

        File file = new File("C:\\Users\\migue\\Downloads\\autos.txt");
        String linea="";
        Map<String, List<Automovil>> categorias = new HashMap<String, List<Automovil>>();
        Automovil auto = null;
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String[] datos;
            while ((linea = br.readLine()) != null) {
                datos = linea.split("-");
                //crea el objeto del tipo personalizado
                auto = new Automovil(datos[0], datos[1], Integer.parseInt(datos[2]),
                        Double.parseDouble(datos[3]), datos[4], datos[5], datos[6]);

                //Organizo el mapa por tipos de autos, (SEDAN, SUV, HATCHBACK, COUPE)

                //chechar si ya existe la llave (categoria) en el mapa
                if (!categorias.containsKey(auto.getTipo())) {
                    //aggregar la llave y su lista asociada ( nueva , vacia )
                    categorias.put(auto.getTipo(), new ArrayList<Automovil>());
                    categorias.get(auto.getTipo()).add(auto);//añade el objeto a la lista correcta
                }//fin del if
                else {
                    //En este punto ya existe la categorita (key)
                    //entonces accedo a la lista asociada para añadr el objeto auto
                    categorias.get(auto.getTipo()).add(auto);

                    //ORGANIZAR UN MAPA POR COLORES
                    //ORGANIZAR UN MAPA POR MARCAS
                    //ORGANIZAR UN MAPA POR TRANSMISION
                    //ORGANIZAR UN MAPA POR COLORES
                    //ORGANIZAR UN MAPA POR MARCA Y CATEGORIA 


                }//fin del else
            }//fin del while
        }//fin del try
        catch (Exception ex){
            ex.printStackTrace();
        }//ffn del catch

        //Imprime los datos de los autos, separados por categorias
        for(String key : categorias.keySet()){
            System.out.println("Categorias: "+key);
            for(Automovil au : categorias.get(key)){
                System.out.println(au);
            }
        }



    }
}
