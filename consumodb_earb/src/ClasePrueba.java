import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClasePrueba {

    //leer los movimiento de la bd
    Connection con = null;//conexion ala BD
    PreparedStatement ps = null;//entrada de instrucciones ala bsae
    ResultSet rs = null;//salida de resultado de bd
    public List<Movimiento> leerMovs(){
        //Leer los movs desde la db
        String query = "SELECT * FROM MOVIMIENTOS";
        List<Movimiento> movs = new ArrayList<Movimiento>();
        Movimiento m = null;
        try {
            Class.forName( "oracle.jdbc.OracleDriver");//cargar el driver de conexion
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "db1",  "admin");//inicializar la conexion a bd con las credenciales del usuario
            ps = con.prepareStatement(query);//precompila e interpreta la sentencia
            rs = ps.executeQuery();//ejecuta la sentencia, capturando los resultados

            while(rs.next()){
                m = new Movimiento(rs.getInt("MOV_ID"),rs.getInt("CUENTA_ID"),
                        rs.getString("TIPO"), rs.getDate("FECHA"),
                        rs.getDouble("MONTO"));

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
         Class.forName( "oracle.jdbc.OracleDriver");//cargar el driver de conexion
         con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "db1",  "admin");//inicializar la conexion a bd con las credenciales del usuario
         ps = con.prepareStatement(query);//precompila e interpreta la sentencia
         ps.setInt(1, cuentaId);
         ps.setString(2, tipo);
         ps.setDate(3, Date.valueOf(fecha));
         ps.setDouble(4, monto);
         //INSERT INTO MOVIMIENTOS(CUENTA_ID, TIPO, FECHA, MONTO)VALUES(2,deposito,fehca,monto)"
         int x = ps.executeUpdate(); // devuelve el conteo de filas que fuerin afectdas por la sentencia
         if (x>0){
             System.out.println("Insercion OK");
         }else {
             System.out.println("ERORr");
         }

     } catch (Exception ex) {
         ex.printStackTrace();
     }
    }
    public  void actualizarMov(int movId, int cuentaId, String tipo, LocalDate fecha, double monto){
        String query="UPDATE MOVIMIENTOS SET CUENTA_ID=?, TIPO=?, FECHA=?, MONTO=? WHERE MOV_ID =?";
        try{
            Class.forName( "oracle.jdbc.OracleDriver");//cargar el driver de conexion
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "db1",  "admin");//inicializar la conexion a bd con las credenciales del usuario
            ps = con.prepareStatement(query);//precompila e interpreta la sentencia
            ps.setInt(1, cuentaId);
            ps.setString(2, tipo);
            ps.setDate(3, Date.valueOf(fecha));
            ps.setDouble(4, monto);
            ps.setInt(5, movId);
            //INSERT INTO MOVIMIENTOS(CUENTA_ID, TIPO, FECHA, MONTO)VALUES(2,deposito,fehca,monto)"
            int x = ps.executeUpdate(); // devuelve el conteo de filas que fuerin afectdas por la sentencia
            if (x>0){
                System.out.println("Actualizacion OK");
            }else {
                System.out.println("ERROR");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void eliminarMovs(int movId){
        String query ="DELETE FROM MOVIMIENTOS WHERE MOV_ID ="+movId;

        try {
            Class.forName( "oracle.jdbc.OracleDriver");//cargar el driver de conexion
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "db1",  "admin");//inicializar la conexion a bd con las credenciales del usuario
            ps = con.prepareStatement(query);
            int x = ps.executeUpdate();


            if (x>0){
                System.out.println("Eliminacion OK");
            }else {
                System.out.println("ERROR");
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
