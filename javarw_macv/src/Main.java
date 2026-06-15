import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //lectura y escritura de archivos en Java

        String ruta = "C:\\Users\\migue\\Downloads\\telefonos.txt"; //path hacia el archivo
        String ruta2 = "C:\\Users\\migue\\Downloads\\escritura.txt";
        File file = new File(ruta);//representacion del archivo ne memoria
        File escritura = new File(ruta2);
        String linea="";// temporal, guardar una linea del archivo a la vez
        String [] datos;
        try{
            FileReader fr = new FileReader(file);//cargar una copia del contenido (caché)
            BufferedReader br = new BufferedReader(fr);//leer el caché
            FileWriter fw = new FileWriter(escritura);
            while ((linea=br.readLine())!= null){//lectura linea por linea

                //System.out.println(linea.toUpperCase()); //convierte todo a mayuscula

                //imprimir solo los telefenos con procesador Snapdragon
//                //if(linea.contains("Snapdragon")){
//                    System.out.println(linea);
//                }

                //imprimir la marca y modelo de cada telefono
                //System.out.println(linea.substring(0, 24));//devuelve uan subcadena entre los indices


                //imprimir desde el procesador hacia adelante
                //System.out.println(linea.substring(36));//vuelve una subcadena desde el indice deseado

                //Imprimir los telefonos que la marcar comienza con una "S"
//                if (linea.startsWith("S")){//develve true cuando la linea emieza con 'S'
//                    System.out.println(linea);
//                }

                //imprimir las lineas que no terminen con cero
//                if ( !(linea.endsWith("0"))){//devuelve true cuando la linea termna con '0'
//                    System.out.println(linea);
//                }

                datos=linea.split("#");//extra los datos individuales y los extrae en arrays


//                System.out.println(datos[0]);//siempre devuelve el dato en la 3er posicion del array
//                System.out.println(datos[1]);//siempre devuelve el dato en la 7ma posicion del array (s.o)

                //celulares gama alta o media alta
                if (datos[2].equals("Alta") || datos[2].equals("Media-Alta")) {
                    System.out.println(datos[0] + " " + datos[1] + " $" + datos[3]);
                    fw.write(datos[0] + " " + datos[1] + "$" +datos[3]  +"\n");

                }
                //filtro por precio>= 1000 y procesador Snapdragon
//                if (Integer.parseInt(datos[3])>=1000 && datos[4].contains("Snapdragon")){
//                    System.out.println(datos[2]+" "+datos[5]+" "+ datos[7].toUpperCase());
//                }

                //celulares <=6gb o el precio este por debajo de $6000
                //imprimir: marca, modelo, precio, mAh
//                if(Integer.parseInt(datos[3])<6000 && Character.getNumericValue(datos[5].charAt(0))<=6) {
//                    System.out.println(datos[0] + " " + datos[1] + " " + datos[3] + " " + datos[8]);
//
//
//                    //Escribe los datos en el nuevo archivo pensado para la escritura
//                    fw.write(datos[0] + " " + datos[1] + " " + datos[3] + " " + datos[8]+"\n");
//
//                }
            }//fin del while
            fw.close();//guarda y cierra el flujo de datos hacia el archivo
        }
        catch (Exception ex){
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
    }
}