import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Lectura y escritura de archivos con Java

        String ruta = "C:\\Users\\luis_\\Downloads\\telefonos.txt"; // path o ruta hacia el archivo
        String ruta2 = "C:\\Users\\luis_\\Downloads\\Escritura.txt"; //
        File file = new File(ruta); // Representación del archivo en memoria.
        File escritura = new File(ruta2);
        String linea = ""; // temporal, guardar 1 línea del archivo a la vez
        String[] datos;

        try{
            FileReader fr = new FileReader(file); // Cargar una copia del contenido (caché)
            BufferedReader br = new BufferedReader(fr); // Leer el caché
            FileWriter fw = new FileWriter(escritura);


            while ((linea=br.readLine()) != null){ //lectura linea por línea

                // System.out.println(linea.toUpperCase());// upperCase convierte todo en mayusculas

                // Imprimir solo los teléfonos con procesador Snapdragon
//                if(linea.contains("Snapdragon")){ // contains devuelve true|false
//                    System.out.println(linea);
//                }

                // Imprimir la marca y modelo de cada teléfono.

                //System.out.println(linea.substring(0,24)); // Devuelve una subcadena señalada entre los indices

                // imprimir desde el procesador hacia adelante
                //System.out.println(linea.substring(36));// Devuelve una subcadena desde el indice deseado

                // Imprimir los teléfonos que la marca comienza con una "S"
//                if(linea.startsWith("S")){ //Devuelve true cuando la linea empieza con "S"
//                    System.out.println(linea);
//                }

                // Imprimir las lineas que NO teminen con 0.
//                if(!(linea.endsWith("0"))){ // Devuelve true cuando la linea no termina con "0"
//                    System.out.println(linea);
//                }

                datos = linea.split("#"); // Extrae los datos individuales y los gusrda en un array.
//                System.out.println(datos[3]); // Siempre devuelve el dato en la 3er posición dentro del array (precio).
//                System.out.println(datos[7]); // Siempre devuelve el dato en la 7ma posición del array (sist. op.).


                // Celulares donde la gamma sea alta o media alta, imprimir solamente

                if(datos[2].equals("Alta") || datos[2].equals("Media-Alta")){
                    System.out.println(datos[0]+" "+datos[1]+" $"+datos[3]);

                    fw.write(datos[0]+" "+datos[1]+" $"+datos[3]+"\n");
                }

                // Filtro por precio mayor o igual a $10,000 y procesador Snapdragon

//                if(Integer.parseInt(datos[3]) >= 10000 && datos[4].contains("Snapdragon")){
//                    System.out.println(datos[2]+" "+datos[5]+" "+datos[7].toUpperCase());
//                }


                // Celulares economicos
                // ram <= 6gb o el precio este por debajo de $6,000
                // Imprimir: marca, modelo, precio mAh
//                if(Integer.parseInt(datos[3]) < 6000 || Character.getNumericValue(datos[5].charAt(0)) <= 6){
//                    System.out.println(datos[0]+" "+datos[1]+" $"+datos[3]+" "+datos[8]);
//
//                    //Escribe los datos en el nuevo archivo pensado para la escritura
//                    fw.write(datos[0]+" "+datos[1]+" $"+datos[3]+" "+datos[8]+"\n");
//
//                }
            } // fin del While.

            fw.close(); // Guarda y cierra el flujo de datos hacia el archivo.

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}