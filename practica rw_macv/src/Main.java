import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String ruta = "C:\\Users\\migue\\Downloads\\ejercicio.txt"; //ejercicio
        String ruta2 = "C:\\Users\\migue\\Downloads\\ejercicio resuelto.txt";//doc del ejercicio resuelto
        File file = new File(ruta);
        File escritura = new File(ruta2);
        String linea="";
        String [] datos;
        String[] dias = {
                "uno", "dos", "tres", "cuatro", "cinco",
                "seis", "siete", "ocho", "nueve", "diez",
                "once", "doce", "trece", "catorce", "quince",
                "dieciséis", "diecisiete", "dieciocho", "diecinueve", "veinte",
                "veintiuno", "veintidós", "veintitrés", "veinticuatro", "veinticinco",
                "veintiséis", "veintisiete", "veintiocho", "veintinueve", "treinta",
                "treinta y uno"
        };
        String[] meses = {
                "Enero", "Febrero", "Marzo",
                "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Septiembre",
                "Octubre", "Noviembre", "Diciembre"
        };
        char[] letras = {
                'A', 'B', 'C', 'D', 'E', 'F', 'G',
                'H', 'I', 'J', 'K', 'L', 'M', 'N',
                'O', 'P', 'Q', 'R', 'S', 'T', 'U',
                'V', 'W', 'X', 'Y', 'Z'
        };


        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);//leer el caché
            FileWriter fw = new FileWriter(escritura);
            while ((linea = br.readLine()) != null) {

                datos=linea.split("/");

                //dias
                if(Integer.parseInt(datos[0])<31){
                    datos[0]= dias[Integer.parseInt(datos[0])-1];
                }
                //meses
                if (Integer.parseInt(datos[1])<13) {
                    datos[1] = meses[Integer.parseInt(datos[1])-1];

                }
                //fecha
                System.out.println(datos[0]+" de "+datos[1]+" de "+datos[2]);






            }
        }

        catch (Exception ex){
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }


    }
}