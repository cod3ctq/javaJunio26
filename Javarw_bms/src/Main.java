import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {
        // Lectura y escritura de archivos con Java
        //Debe contener las diagonales dobles
        String ruta = "C:\\Users\\ThinkPad\\Desktop\\git\\telefonos.txt"; // path o ruta hacia el archivo
        String ruta2 = "C:\\Users\\ThinkPad\\Desktop\\git\\escritura.txt"; // path o ruta hacia el archivo
        File file = new File(ruta); // Representación del archivo en memoria.
        File escritura = new File(ruta2); // Representación del archivo en memoria.
        String linea = ""; // temporal, guardar 1 línea del archivo a la vez
        String [] datos;
        try{
            FileReader fr = new FileReader(file); // Cargar una copia del contenido (caché)
            BufferedReader br = new BufferedReader(fr); // Leer el caché
            FileWriter fw = new FileWriter(escritura);
            while ((linea=br.readLine()) != null) { //lectura linea por línea
//                System.out.println(linea.toUpperCase());//Convierte todo a mayusculas
                //Imprimir solo los telefonos con procesador SnapDragon
//                if (linea.contains("Snapdragon")) {
                    // substring es para colocar solo una parte de la cadena (Es un metodo polimorfico)
                    //Se ocupa para metodos que no van a cambiar de lenght
//                    System.out.println(linea.substring(0,24));
//                }

                    //System.out.println(linea.substring(35)); //devuelve unasubcadena desde el indice deceado

                    //Split():
//                    String frase = "Java es muy divertido";
//                    String[] palabras = frase.split(" ");
//
//                    // Resultado: ["Java", "es", "muy", "divertido"]

                //Imprimir los telefonos que la marca comienza con una 's'

//                if (linea.startsWith("S")) {
//                    System.out.println(linea);
//                }

                //Imprime las lineas que no terminan con cero
//                if (!(linea.endsWith("0"))) { //devuelve true cuando la linea termina con '0'
//                    System.out.println(linea);
//                }
                //Se declaro una variable para el array
                datos = linea.split("#");//Extrae los datos individuales  y los guarda en un array
//                System.out.println(datos[3]); //Siempre devuelve uel dato den la 3er posicion del array
//                System.out.println(datos[7]); //Siempre devuelve el dato en la 7ma posicion del array(s.0.)

                //Celulares gama: Altura o media alta
                if(datos[2].equals("Alta")||(datos[2].equals("Media-Alta")));
                System.out.println(datos[0]+" "+datos[1]+" $ "+datos[3]);
                //Escribe los datos en el nuevo archivo pensado para la escritura
                fw.write(datos[0]+" "+datos[1]+" $ "+datos[3]+"\n");

                //Filtro por precio >= 10000 y procesador snapDragon
//                if(Integer.parseInt(datos[3]) >= 1000 && datos[4].contains("Snapdragon")){
//                    System.out.println(datos[2]+" "+datos[5]+" $ "+datos[7].toUpperCase());

//            }

                //Celulares economicos
                //ram <=6gb o el precio este por debajo de 6000
                //imprimir:Marca, modelo, precio en mAh
//                if(Integer.parseInt(datos[3])<6000 || Character.getNumericValue(datos[5].charAt(0))<=6){
//                    System.out.println(datos[0]+" "+datos[3]+" "+datos[8]);
//
//                //Escribe los datos en el nuevo archivo pensado para la escritura
//                fw.write(datos[0]+" "+datos[3]+" "+datos[8]+"\n");
//                }

            }//Fin del while
            fw.close();//guarda y cierra el flujo de datos hacia el archivo
        }catch(Exception ex){
            ex.printStackTrace(); //Indica cuales son los errores sin parar el programa
            System.out.println(ex.getMessage());//Excribir cual es el error
        }
    }
}
