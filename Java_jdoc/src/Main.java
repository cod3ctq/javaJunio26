import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Lectura y escritura de archivos con java
        String ruta="C:\\Users\\Abis1\\Downloads\\telefonos.txt";// path o ruta hacia el archivo
        String ruta2="C:\\Users\\Abis1\\OneDrive\\Desktop\\Escritura.txt";
        File file = new File(ruta); // reprecentacion del archivo en memoria
        File Escritura = new File(ruta2);
        String linea=""; // temporal, guardar una linea del archivo a la vez
        String datos="";
        FileWriter FW =new FileWriter(Escritura);
        try {
            FileReader fr = new FileReader(file); //cargar una copia del contenido (cache)
            BufferedReader br = new BufferedReader(fr);// leer el cache
            FileWriter FW =new FileWriter(Escritura);

            while ( (linea=br.readLine())!=null){ // lectura linea por linea


//                System.out.println(linea.toUpperCase()); // UpperCase () conviergte todo a mayusculas
//                // System.out.println(linea.toUpperCase());
//                if(Integer.parseInt(
//                        fw.write(datos[0]+""+datos[1]+""+datos[3]+""+datos[8]+"\n");
//
//

            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}