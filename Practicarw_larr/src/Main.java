import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Lectura y escritura de fechas de fechas.

        String ruta = "C:\\EjercicioFechas\\LecturaFechas.txt";
        String ruta2 = "C:\\EjercicioFechas\\FechasConLetras.txt";
        File file = new File(ruta);
        String linea = "";
        int pos, num;
        String[] dias = {"uno","dos","tres","cuatro","cinco","seis","siete","ocho","nueve",
                         "diez","once","doce","trece","catorce","quince","dieciséis","diecisiete", "dieciocho", "diecinueve", "veinte",
                         "veintiuno","veintidós","veintitrés","veinticuatro","veinticinco","veintiséis","veintisiete","veintiocho",
                         "veintinueve","treinta","treinta y uno"};
        String[] meses = {"enero", "febrero","marzo","abril","mayo","junio","julio","agosto","septiembre","octubre","noviembre",
                          "diciembre"};

        String abecedario = "abcdefghijklmnopqrstuvwxyz";

        String[] datos;
        String[] fecha = new String[2];
        String letras, texto;
        char caracter;
        String cifrado="";


        try{
            FileReader fr = new FileReader(file);
            BufferedReader br =new BufferedReader(fr);

            while((linea = br.readLine()) != null){ //Lectura linea por linea


                // Impresión de la fecha con palabras.

                datos = linea.split("-");
                System.out.print(datos[0]+datos[1]+datos[2]+" --->");

                fecha[0] = dias[Integer.parseInt(datos[0])-1];

                fecha[1] = meses[Integer.parseInt(datos[1])-1];


                System.out.println(" "+fecha[0]+" de "+fecha[1]+" de "+datos[2]+" --->");

                letras = fecha[0]+" de "+fecha[1]+" de "+datos[2];
                letras = letras.replace(" ","");
                System.out.println(letras);

                for(int i=0; i<letras.length()-1; i++){
                    caracter = letras.charAt(i);

                    if(abecedario.indexOf(caracter) >= 0){ //Si es una letra
                        if(caracter == 'z'){
                            cifrado = cifrado + 'a';
                        } else {
                            cifrado = cifrado + abecedario.charAt(abecedario.indexOf(caracter)+1);
                        }


                    }else{
//                        if(abecedario.indexOf(caracter) < 0){
//                            num = Character.valueOf(caracter);
//                            System.out.println(num);
//                        }
                    }


                }
                System.out.println(cifrado);
                cifrado = "";
            } // Fin del while


        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}