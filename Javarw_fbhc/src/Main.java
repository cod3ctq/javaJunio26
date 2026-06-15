import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {


        // Lectura y ecritura de archivos con java

        String ruta = "C:\\Users\\forti\\Downloads\\telefonos.txt"; // pat hacia el archivo
        String ruta2 = "C:\\Users\\forti\\Desktop\\escritura.txt";
        File file = new File(ruta);// representacion del archivo en memoria
        File escritura = new File(ruta2); // representacion del archivo en memoria
        String linea = "";// temporal guardar 1 linea del archivo a la vez
        String[] datos;
        try {
            FileReader fr = new FileReader(file);// carga una copia del contenido (cache)
            BufferedReader br  = new BufferedReader(fr);// leer el cache
            FileWriter fw = new FileWriter(escritura);

            while ((linea=br.readLine())!=null) {  // lectura linea por linea
//                System.out.printf(linea);

//                System.out.println(linea.toUpperCase());   //upperCase convierte todo a mayusculas
//                //Imprimir solon los telefonos Snapdragon

//                if (linea.contains("Snapdragon")){
//                    System.out.println("Snapdragon");
//                }


                // imprimir la marca y modelo de cada telefono

//                System.out.println(linea.substring(0,24));  // devuelve una subcadena señalada entre los indices


                // Imprime desde el procesador hacia adelante
//                System.out.println(linea.substring(36));    // devuelve una subcadena desde el indice

//                if (linea.startsWith("S")){
//                    System.out.println(linea);
//                }
// Imprime las lineas que no terminan con cero
//                if ( linea.endsWith("0")) {// devuelve trua cuando la linea termine con 0
//                    System.out.println(linea);
//                }

                datos = linea.split("#");// Extrae los datos individuales y los guarda en un array
//                System.out.println(datos[3]);  // siempre devuelve el dato en la tercera posicion
//                System.out.printf(datos[7]);  // siempre devuelve el dato en la 7ma posicion del araay

//                // filtro velulares gama : Alta o media alta
//                if (datos[2].equals("Alta")||datos[2].equals("Media-Alta"));
//                System.out.printf(datos[0] +" "+ datos[1]+"$"+datos[3]);

                // filtro por precio >= 10000ny procesador Snapdragon

//                if (Integer.parseInt(datos[3])>=1000 && datos[4].contains("Snapdragon")){
//                    System.out.println(datos[2]+" "+datos[5]+" "+datos[7].toUpperCase());
            //}

                if (Integer.parseInt(datos[3])<6000 || Character.getNumericValue(datos[5].charAt(0))<=6){
                    System.out.println(datos[0]+" "+datos[1]+" "+ datos[5]+" "+datos[8]);

                    // Escribe los datos en el nuevo archivo pensado para la escritura
                    fw.write(datos[0]+" "+datos[1]+" "+datos[3]+" "+datos[8]);
                }
               }
// celulares economicos
                // ram <= 6gb o el precio este ddebajo de 6000
                // imprimir : Marca, modelo, precio mAh




        }catch ( Exception ex){
            ex.printStackTrace();
        }
    }
}
