import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class clasePrueba {
    public List<Movimientos> leerMovs(){
        Connection con = null; //la conexion a la base
        PreparedStatement ps= null; //entrada de instrucciones a la base de datos
        ResultSet rs= null; // Salida de resultados de la base

        //leer los movs  desde la db
        String query ="SELECT * FROM MOVIMIENTOS";
        List<Movimientos> mos = new ArrayList<Movimientos>();
        Movimientos m=null;
        //TIP  De donde saco los parametros
        try{
            Class.forName("oracle.jdbc.OracleDriver" );//intentar cargar el driver de conexion
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","db1","admin");// Inicializar la conexion a la base de datos con las credenciales
            ps= con.prepareStatement(query);//precompila o interpreta las sentencia, capturando los resultados
            rs = ps.executeQuery();//ejecuta la sentencia y captura los resultados

            while (rs.next()){
                m= new  Movimientos(rs.getInt("MOV_ID"), rs.getInt("CUENTA_ID"),
                        rs.getString("TIPO"), rs.getDate("FECHA").toLocalDate(), rs. getDouble("MONTO"));
                mos.add(m);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return mos;
    }

    public List<Object> retirar(String numTarjeta, String Nip, double monto){
        // buscar la cuneta

        // verificar nip
        //validar que monto a retirar sea menot al saldo disponible
        //validar qu el saldo disponible - monto > se amayor al saldo minimo
        //actualizar saldo
        return List.of();

    }

    public void insertarMov(int Movid, int cuentaId, String tipo, LocalDate fecha, double monto){
        Connection con = null; //la conexion a la base
        PreparedStatement ps= null; //entrada de instrucciones a la base de datos
        String query ="INSERT INTO MOVIMIENTOS(MOV_ID, CUENTA_ID, TIPO, FECHA, MONTO) VALUES (?, ?, ?, ?, ?)";

        try{
            //una librería se refiere al código(clases, métodos que constantes) del que hacemos uso
            // en algún punto de proyecto, ya contiene funcionalidad de resulta y a menudo es integrada
            // desde el extender

            Class.forName("oracle.jdbc.OracleDriver" );//intentar cargar el driver de conexion
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","db1","admin");// Inicializar la conexion a la base de datos con las credenciales
            ps= con.prepareStatement(query);//precompila o interpreta las sentencia, capturando los resultados
            ps.setInt(1, Movid);
            ps.setInt(2, cuentaId);
            ps.setString(3, tipo);
            ps.setDate(4, java.sql.Date.valueOf(fecha));
            ps.setDouble(5, monto);
            int x= ps.executeUpdate();// Devuelve el contero de filas que fueron afectadas por la centencia

            if(x>=0){
                System.out.println("Insercion ok");
            }else{
                System.out.println("Error");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void actualizarRegistri(int Movid, int cuentaId, String tipo, LocalDate fecha, double monto){
        Connection con = null; //la conexion a la base
        PreparedStatement ps= null; //entrada de instrucciones a la base de datos

        //leer los movs  desde la db
        String query ="DELETE FROM MOVIMIENTOS WHERE MOV_ID = ?";

        //TIP  De donde saco los parametros
        try{
            Class.forName("oracle.jdbc.OracleDriver" );//intentar cargar el driver de conexion
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","db1","admin");// Inicializar la conexion a la base de datos con las credenciales
            ps= con.prepareStatement(query);//precompila o interpreta las sentencia, capturando los resultados
            ps.setInt(1, Movid);
            int x= ps.executeUpdate();//ejecuta la sentencia y captura los resultados
            if(x>=0){
                System.out.println("delete ok");
            }else{
                System.out.println("Error");
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void delete(int mov_id){
        Connection con = null; //la conexion a la base
        PreparedStatement ps= null; //entrada de instrucciones a la base de datos

        //leer los movs  desde la db
        String query ="DELETE FROM MOVIMIENTOS WHERE MOV_ID = ?";

        //TIP  De donde saco los parametros
        try{
            Class.forName("oracle.jdbc.OracleDriver" );//intentar cargar el driver de conexion
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","db1","admin");// Inicializar la conexion a la base de datos con las credenciales
            ps= con.prepareStatement(query);//precompila o interpreta las sentencia, capturando los resultados
            ps.setInt(1, mov_id);
            int x= ps.executeUpdate();//ejecuta la sentencia y captura los resultados
            if(x>=0){
                System.out.println("Delete ok");
            }else{
                System.out.println("Error");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
