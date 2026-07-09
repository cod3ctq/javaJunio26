import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Fechas {
    public static void main(String[] args) {


        String ruta = "C:\\Users\\forti\\Desktop\\java\\fechas.txt"; // Guarda la direccion del archivo que contiene las fechas
        String ruta2 = "C:\\Users\\forti\\Desktop\\java\\escritura.txt";  //Guarda la direccion donde se creara el nuevo archivo
        File file = new File(ruta);// ; // files archivos  File es es una clase de java que representa un archivo en memoria Crea un objeto que apunta en esa direccion crea un objeto file que representa el archivo en la ruta indicada
        File escritura = new File(ruta2); // archivo donde se guardaran los datos
        String linea = ""; // Aqui se almacenara cada linea del archivo
        String[] datos;

        try {    //  Voy a intentar generar este codigo pero puede fallar por eso se usa junto con cash

            FileReader fr = new FileReader(file);  // Abre el archi para leerlo fr es el objeto que lle caracteres del objeto


            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter(escritura);  //Abre o crea el archivo escritura para escribir en el


            while ((linea = br.readLine()) != null) {  // este ciclo lee el archivo linea por linea

                System.out.printf(linea);

            } catch(Exception ex){
                ex.printStackTrace();
            }

        }
    }}
