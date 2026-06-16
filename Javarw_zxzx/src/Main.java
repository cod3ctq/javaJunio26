import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Lectura y escritura de archivos con Java
        String ruta="C:\\Users\\César\\Desktop\\escritorio\\telefonos.txt"; //path hacia el archivo
        String ruta2 = "C:\\Users\\César\\Desktop\\escritorio\\escritura.txt";
        File file = new File(ruta); //representacion del archivo en memoria
        File escritura = new File(ruta2);
        String linea=""; // temporal, guardar 1 linea del archivo a la vez
        String[] datos;
        try{
            FileReader fr = new FileReader(file); //carga una copia del contenido (caché)
            BufferedReader br = new BufferedReader(fr); //leer el caché
            FileWriter fw = new FileWriter(escritura);

            while( (linea=br.readLine())!=null){ //lectura linea por linea
                //System.out.println(linea.toUpperCase()); //upperCase() convierte todo a mayuscula
                //Imprimir solo los telefonos con procesador Snapdragon
//                if (linea.contains("Snapdragon")) { //contains devuelve true|false
//                    System.out.println(linea);
//                }
                //Imprimir la marca y modelo de cada telefono
                //System.out.println(linea.substring(0, 24)); //devuelve una subcadena señalada entre los indices

                //Imprimir desde el procesador hacia adelante
                //System.out.println(linea.substring(36)); //devuelve una subcadena desde el indice deseado

                //Imprimir los telefonos que la marca comienza con una 'S'
//                if(linea.startsWith("S")){ //devuelve true cuando la linea empieza con 'S'
//                    System.out.println(linea);
//                }
                //Imprime las lineas que NO terminen con cero
//                if( ! (linea.endsWith("0"))){ //devuelve true cuando la linea termina con '0'
//                    System.out.println(linea);
//                }
                datos = linea.split("#"); //extra los datos individuales y los guarda en un array
                //System.out.println(datos[3]); //siempre devuelve el dato en la 3er posicion del array (precio)
                //System.out.println(datos[7]); //siempre devuelve el dato en la 7ma posicion del array (s.o.)

                //celulares gama: Alta o media alta, imprimir solamente marca, modelo y precio
                if(datos[2].equals("Alta") || datos[2].equals("Media-Alta")){
                    System.out.println(datos[0]+" "+datos[1]+" $"+datos[3]);
                    fw.write(datos[0]+" "+datos[1]+" $"+datos[3]+"\n");
                }

                //filtro por precio >=1000 y procesador snapdragon, imprime gama, ram y sistema operativo
//                if(Integer.parseInt(datos[3])>=1000 && datos[4].contains("Snapdragon")){
//                    System.out.println(datos[2]+" "+datos[5]+" "+datos[7].toUpperCase());
//                }

                //Celulares economicos
                //ram <=6gb o el precio este por debajo de 6000
                //imprimir: Marca, modelo, precio mAh
//                if(Integer.parseInt(datos[3])<6000 || Character.getNumericValue(datos[5].charAt(0))<=6){
//                    System.out.println(datos[0]+" "+datos[1]+" "+datos[3]+" "+datos[8]);
//
//                    //Escribe los datos en el nuevo archivo pensado para la escritura
//                    fw.write(datos[0]+" "+datos[1]+" "+datos[3]+" "+datos[8]+"\n");
//
//                }
            }// fin del while
            fw.close(); //guarda y cierra el flujo de datos hacia el archivo
        }catch (Exception ex){
            //ex.printStackTrace();
            System.out.println(ex.getMessage());
        }

    }
}