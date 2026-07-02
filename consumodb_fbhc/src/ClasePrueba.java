import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClasePrueba {

    Connection con = null;   // la conexion
    PreparedStatement ps = null;  //Entrada de instrucciones a la bae
    ResultSet rs = null;    // salida de resultados a lanbase

    public List<Movimientos> leerMovs(){





        // leer los mov desde la db
        String query = "SELECT * FROM MOVIMIENTOS";
        List<Movimientos> movs = new ArrayList<Movimientos>();
        Movimientos m= null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");//Cargar el driver de conexion
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "db1", "admin"); //inicializar la conexion a db con las credenciales del usuario
            ps = con.prepareStatement(query);// precompilar o interpretar la sentancia
            rs = ps.executeQuery();// ejecutar la sentencia, capturando los resultados


            while (rs.next()) { // ejecutar la sentencia , capturando los resultados
                m = new Movimientos(rs.getInt("MOV_ID"),rs.getInt("CUENTA_ID"),rs.getString("TIPO"),rs.getDate("FECHA"),rs.getDouble("MONTO"));

                //AÑADE A LA LISTA
                movs.add(m);
            }


        }catch (Exception ex){
            ex.printStackTrace();
        }

        return movs;

    }


public  void guardarMov(int movId, int cuentId, String  tipo, LocalDate fecha, double monto){
        String query = "INSERT INTO MOVIMIENTOS(CUENTA_ID, TIPO, FECHA, MONTO)VALUES(?,?,?,?)";

        try {

            Class.forName("oracle.jdbc.OracleDriver");//Cargar el driver de conexion
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "db1", "admin"); //inicializar la conexion a db con las credenciales del usuario
            ps = con.prepareStatement(query);// precompilar o interpretar la sentancia en lugar de
            //simplemente ejecutar la sentencia ahora acomoda los valores
            //marcadores de posicion
             ps.setInt(1,cuentId);
             ps.setString(2,tipo);
             ps.setDate(3, Date.valueOf(fecha));
             ps.setDouble(4, monto);


             // insertar into

            int x = ps.executeUpdate();  // Devuelve el conteo de filas que fueron afectadas por la sentencia

            if(x>0){
                System.out.println("Insercion OK");

            }else{
                System.out.println("Error");
            }

        }catch (Exception ex){
            ex.printStackTrace();

        }


    }


    public  void actualizarMov(int movId, int cuentId, String  tipo, LocalDate fecha, double monto) {
        String query = "UPDATE MOVIMIENTOS SET CUENTA_ID=?, TIPO=?, FECHA=?, MONTO=? WHERE MOV_ID = ?";

        try {

            Class.forName("oracle.jdbc.OracleDriver");//Cargar el driver de conexion
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "db1", "admin"); //inicializar la conexion a db con las credenciales del usuario
            ps = con.prepareStatement(query);// precompilar o interpretar la sentancia en lugar de
            //simplemente ejecutar la sentencia ahora acomoda los valores
            //marcadores de posicion
            ps.setInt(1, cuentId);
            ps.setString(2, tipo);
            ps.setDate(3, Date.valueOf(fecha));
            ps.setDouble(4, monto);
            ps.setInt(5, movId);


            // insertar into

            int x = ps.executeUpdate();  // Devuelve el conteo de filas que fueron afectadas por la sentencia

            if (x > 0) {
                System.out.println("Actualizacion OK");

            } else {
                System.out.println("Error");
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }


    }

    public void eliminarMov(int movId){
        String query ="DELETE FROM MOVIMIENTOS WHERE MOV_ID="+movId;



        try {


            Class.forName("oracle.jdbc.OracleDriver");//Cargar el driver de conexion
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "db1", "admin"); //inicializar la conexion a db con las credenciales del usuario
            ps = con.prepareStatement(query);// precompilar o interpretar la sentancia en lugar de
            //simplemente ejecutar la sentencia ahora acomoda los valores
            //marcadores de posicion


            int x = ps.executeUpdate();

            if(x>0){
                System.out.println("Eliminacion OK");
            }else{
                System.out.println("Error");
            }


        }catch (Exception ex){
            ex.printStackTrace();
        }



    }



    }
