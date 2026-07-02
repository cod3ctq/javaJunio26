import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class clasePrueba {


    Connection con = null; //Conexion a la base de datos
    PreparedStatement ps = null; //Entrada de instrucciones a la base
    ResultSet rs = null; //Sakida de resultados de la base

    public List<Movimiento> leerMovs() {

        //Leer os movimientos desde la db
        String query = "SELECT * FROM MOVIMIENTOS";
        List<Movimiento> movs = new ArrayList<Movimiento>();
        Movimiento m = null;

        try {
            Class.forName("oracle.jdbc.OracleDriver"); //Cargas el driver de conexion
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "db1", "admin"); //Inicializar la conexion a db con las credenciales del usuario
            ps = con.prepareStatement(query);// Precopila o interpert la sentencia
            rs = ps.executeQuery();//Ejecuta la sentencia , capturando los resultados
            while (rs.next()) {
                m = new Movimiento(rs.getInt("MOV_ID"), rs.getInt("CUENTA_ID"), rs.getString("TIPO"),
                        rs.getDate("FECHA"), rs.getDouble("MONTO"));

                //AÑADE A LA LIST
                movs.add(m);
            }//fin del while
        }//fin del try
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return movs;
    }//Fin list

    public void guardarMov(int movId, int cuentaId, String tipo, LocalDate fecha, double monto) {
        String query = "INSERT INTO MOVIMIENTOS(CUENTA_ID, TIPO, FECHA, MONTO)VALUES(?,?,?,?)";
        try {
            Class.forName("oracle.jdbc.OracleDriver"); //Cargas el driver de conexion
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "db1", "admin"); //Inicializar la conexion a db con las credenciales del usuario
            ps = con.prepareStatement(query);// Precopila o interpert la sentencia
            //En lugar de simplemente ejecutar la sentencia, ahora acomodamos los valores en los
            //marcadores de posicion
            ps.setInt(1, cuentaId);
            ps.setString(2, tipo);
            ps.setDate(3, Date.valueOf(fecha));//transforma de LocalDate -> Date
            ps.setDouble(4, monto);

            int x = ps.executeUpdate(); //Devuelve el conteo de filas que fueron afectadas por la sentencia
            if (x > 0) {
                System.out.println("Insector OK");
            } else {
                System.out.println("ERROR");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }//FIN guardarMov




    public void actualizarMov(int movId, int cuentaId, String tipo, LocalDate fecha, double monto){
        String query = "UPDATE MOVIMIENTOS SET CUENTA_ID=?, TIPO=?, FECHA=?,MONTO=? WHERE MOV_ID = ?";
        try {
            Class.forName("oracle.jdbc.OracleDriver"); //Cargas el driver de conexion
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "db1", "admin"); //Inicializar la conexion a db con las credenciales del usuario
            ps = con.prepareStatement(query);// Precopila o interpert la sentencia
            //En lugar de simplemente ejecutar la sentencia, ahora acomodamos los valores en los
            //marcadores de posicion
            ps.setInt(1, cuentaId);
            ps.setString(2, tipo);
            ps.setDate(3, Date.valueOf(fecha));//transforma de LocalDate -> Date
            ps.setDouble(4, monto);
            ps.setInt(5,movId);

            int x = ps.executeUpdate(); //Devuelve el conteo de filas que fueron afectadas por la sentencia
            if (x > 0) {
                System.out.println("Actualizacion OK");
            } else {
                System.out.println("ERROR");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }//FIN actualizarMov

    public void eliminarMov(int movID){
        String query="DELETE FROM MOVIMIENTOS WHERE MOV_ID ="+movID;
        try{
            Class.forName("oracle.jdbc.OracleDriver"); //Cargas el driver de conexion
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "db1", "admin"); //Inicializar la conexion a db con las credenciales del usuario
            ps = con.prepareStatement(query);// Precopila o interpert la sentencia
            int x = ps.executeUpdate();
            if(x>0){
                System.out.println("Eliminación OK");
            }else {
                System.out.println("ERROR");
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }//FIN eliminarMov






}





