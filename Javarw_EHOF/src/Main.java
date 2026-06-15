import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {

        String ruta = "C:\\Users\\100076715\\Downloads\\telefonos.txt";
        File file = new File(ruta);
        String linea = "";
        String[] datos;

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            while ((linea = br.readLine()) != null) {

                datos = linea.split("#");

                // Verificar que existan suficientes campos
                if (datos.length >= 4) {

                    // Imprimir el campo 3 (por ejemplo batería)
                    System.out.println("Batería: " + datos[3]);

                    // Si la batería es menor a 6000
                    if (Integer.parseInt(datos[3]) < 6000) {

                        System.out.println(
                                datos[0] + " " +  // Marca
                                        datos[1] + " " +  // Modelo
                                        datos[3]          // Batería
                        );
                    }
                }
            }

            br.close();
            fr.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}