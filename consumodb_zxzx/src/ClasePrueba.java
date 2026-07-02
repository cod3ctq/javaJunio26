import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClasePrueba {

    Connection con = null; //La conexion a la base, (puerta)
    PreparedStatement ps = null; //Entrada de instrucciones a la base
    ResultSet rs = null; //Salida de resultados de la base

    public List<Movimiento> leerMovs(){
        //Leer los movs desde la db
        String query = "SELECT * FROM MOVIMIENTOS";
        List<Movimiento> movs = new ArrayList<Movimiento>();
        Movimiento m = null;
        try{
            Class.forName("oracle.jdbc.OracleDriver"); //Cargar el driver de conexion
            //Inicializar la conexion a db con las credenciales del usuario
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","db4","admin");
            ps= con.prepareStatement(query); //Precompila o interpreta la sentencia
            rs = ps.executeQuery(); //Ejecuta la sentencia, capturando los resultados
            while(rs.next()){
                m = new Movimiento(rs.getInt("MOV_ID"),rs.getInt("CUENTA_ID"),
                        rs.getString("TIPO"),rs.getDate("FECHA"),
                        rs.getDouble("MONTO"));
                //AÑADE A LA LISTA
                movs.add(m);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return movs;
    }

    public void guardarMov(int movId, int cuentaId, String tipo, LocalDate fecha, double monto){
        String query="INSERT INTO MOVIMIENTOS(CUENTA_ID, TIPO, FECHA, MONTO)VALUES(?,?,?,?)";
        try{
            Class.forName("oracle.jdbc.OracleDriver"); //Cargar el driver de conexion
            //Inicializar la conexion a db con las credenciales del usuario
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","db4","admin");
            ps= con.prepareStatement(query); //Precompila o interpreta la sentencia
            //En lugar de simplemente ejecutar la sentencia, ahora acomoda los valores en los
            //marcadores de posicion
            ps.setInt(1, cuentaId);
            ps.setString(2,tipo);
            ps.setDate(3, Date.valueOf(fecha)); //Transforma de LocalDate -> Date
            ps.setDouble(4, monto);
            // "INSERT INTO MOVIMIENTOS(CUENTA_ID, TIPO, FECHA, MONTO)VALUES(2,DEPOSITO,FECHA,350)"
            int x = ps.executeUpdate();  // Devuelve el conteo de filas que fueron afectadas por la sentencia
            if (x>0) {
                System.out.println("Insercion OK");
            }else{
                System.out.println("Error");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void actualizarMov(int movId, int cuentaId, String tipo, LocalDate fecha, double monto){
        String query="UPDATE MOVIMIENTOS SET CUENTA_ID=?, TIPO=?, FECHA=?, MONTO=? WHERE MOV_ID = ?";
        try{
            Class.forName("oracle.jdbc.OracleDriver"); //Cargar el driver de conexion
            //Inicializar la conexion a db con las credenciales del usuario
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","db4","admin");
            ps= con.prepareStatement(query); //Precompila o interpreta la sentencia
            //En lugar de simplemente ejecutar la sentencia, ahora acomoda los valores en los
            //marcadores de posicion
            ps.setInt(1, cuentaId);
            ps.setString(2,tipo);
            ps.setDate(3, Date.valueOf(fecha)); //Transforma de LocalDate -> Date
            ps.setDouble(4, monto);
            ps.setInt(5,movId);
            // "INSERT INTO MOVIMIENTOS(CUENTA_ID, TIPO, FECHA, MONTO)VALUES(2,DEPOSITO,FECHA,350)"
            int x = ps.executeUpdate();  // Devuelve el conteo de filas que fueron afectadas por la sentencia
            if (x>0) {
                System.out.println("Actualizacion OK");
            }else{
                System.out.println("Error");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }

    }


    public void eliminarMovs(int movId){
        String query="DELETE FROM MOVIMIENTOS WHERE MOV_ID ="+movId;
        try{
            Class.forName("oracle.jdbc.OracleDriver"); //Cargar el driver de conexion
            //Inicializar la conexion a db con las credenciales del usuario
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","db4","admin");
            ps= con.prepareStatement(query); //Precompila o interpreta la sentencia
            int x = ps.executeUpdate();

            if(x>0){
                System.out.println("Eliminacion OK");
            }else{
                System.out.println("Error");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }





}
