import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ejempol();
    }


    public  static void ejempol(){
        //Lectura y escritura  de archivos con java
        String ruta="C:\\Users\\DELL\\Downloads\\telefonos.txt"; // path hacia a es archivo
        String ruta2="C:\\Users\\DELL\\Downloads\\Escritura.txt";
        File file= new File(ruta);//representacion del archivo en memeoria
        String linea="";// temporal, guardar 1 linea  del archivo a la vez
        String[] datos;
        File escritura=new File(ruta2) ;

           try{
               FileReader fr = new FileReader(file);
               FileWriter fw= new FileWriter(escritura);
               BufferedReader br = new BufferedReader(fr);// cargar una copia dek contenido (cache)


               while((linea=br.readLine())!=null) {// leer de la propia  linea

                   //linea.substring('samsumg');
                   //linea.substring('0,10')
                   //linea.startsWith("s")
                   //linea.endsWith("0")
                   //linea.split("#");
                   datos = linea.split("#");


//                   if (datos[2].equals("Alta") || datos[2].equals("Media-Alta")) {
//                       System.out.println(datos[0] + " " + datos[1] + " $" + datos[3]);
//
//                   }
                   //lineas que no terminen con 0}
//                   if(Integer.parseInt(datos[3])>=1000 && datos[4].contains("Snapdragon")){
//                       System.out.println(datos[3]+" "+datos[5]+" "+datos[7].toUpperCase());
//                   }

//                   if(Integer.parseInt(datos[3])<=3000){
//                       System.out.println(Arrays.deepToString(datos));
//                   }

                   if(Integer.parseInt(datos[3])<6000 || Character.getNumericValue(datos[5].charAt(0))<=6){
                       fw.write(datos[0]+" "+datos[2]+" "+datos[8]);
                       System.out.println();
                   }

                   fw.close();
               }

           }catch (Exception ex){
               System.out.println(ex.getMessage());
           }
    }
}