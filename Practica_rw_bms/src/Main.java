import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Lectura y escritura de archivos con Java
        //Debe contener las diagonales dobles
        String ruta = "C:\\Users\\ThinkPad\\Desktop\\git\\numeros.txt";

        File file = new File(ruta); // Representación del archivo en memoria.
        String linea = ""; // temporal, guardar 1 línea del archivo a la vez
        String texto = "";           // Variable para contener la fecha en letras
        String [] datos;        // Variable para extraer los datos de forma individual
        String [] resul = new String[3];    //Array para almacenar numeros como letras
        char caracter;
        int contador;


        String[] dias = {
                "Uno", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "Ocho", "Nueve", "Diez",
                "Once", "Doce", "Trece", "Catorce", "Quince", "Dieciséis", "Diecisiete", "Dieciocho",
                "Diecinueve", "Veinte", "Veintiuno", "Veintidós", "Veintitrés", "Veinticuatro",
                "Veinticinco", "Veintiséis", "Veintissiete", "Veintiocho", "Veintinueve", "Treinta",
                "Treinta y uno"
        };

        String[] meses = {
                "Enero",
                "Febrero",
                "Marzo",
                "Abril",
                "Mayo",
                "Junio",
                "Julio",
                "Agosto",
                "Septiembre",
                "Octubre",
                "Noviembre",
                "Diciembre"
        };

        String abecedario = "abcdefghijklmnopqrstuvwxyz";
//        String[] abecedario = {
//                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
//                "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
//                "U", "V", "W", "X", "Y", "Z"
//        };

//        char[] abecedario = {
//                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
//                'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
//        };

        try{
            FileReader fr = new FileReader(file); // Cargar una copia del contenido (caché)
            BufferedReader br = new BufferedReader(fr); // Leer el caché
            while ((linea=br.readLine()) != null) { //lectura linea por línea
                //Se declaro una variable para el array
                datos = linea.split("/");//Extrae los datos individuales  y los guarda en un array
                //Asignacion del dia en letra
                resul[0] = dias[Integer.parseInt(datos[0])-1];
                //Asignacion del mes en letra
                resul[1] = meses[Integer.parseInt(datos[1])-1];
                //Delimitacion del texto
                texto = resul[0]+" de "+resul[1]+" de "+datos[2];


                //Codificacion de la fecha
                for (int i = 0; i < 1; i++) {
                    caracter= texto.toLowerCase().charAt(i);
                    System.out.println(caracter);
                   if(abecedario.indexOf(caracter)>=0){     //Si es la letra
                       contador = abecedario.indexOf(caracter);
                       contador++;
                       System.out.println(contador);

                   }
                }

                //Impresion de los resultados
//                System.out.print(datos[0]+datos[1]+datos[2]+" --> ");
//                System.out.println(texto+"  -->  ");



            } //Fin del while
//            fw.close();//guarda y cierra el flujo de datos hacia el archivo

        }catch(Exception ex){
            ex.printStackTrace(); //Indica cuales son los errores sin parar el programa
            System.out.println(ex.getMessage());//Excribir cual es el error
        }


    }
}
