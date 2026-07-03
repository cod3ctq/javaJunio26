import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MovimientoDAO {

    Connection con = null; //La conexion a la base, (puerta)
    PreparedStatement ps = null; //Entrada de instrucciones a la base
    ResultSet rs = null; //Salida de resultados de la base

    //registro del movimiento
    public void registrarMovimiento(Movimiento mov){
        String query="INSERT INTO MOVIMIENTOS(CUENTA_ID, TIPO, FECHA, MONTO)VALUES(?,?,?,?)";
        try {
            Class.forName("oracle.jdbc.OracleDriver"); //Cargar el driver de conexion
            //Inicializar la conexion a db con las credenciales del usuario
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","db4","admin");
            ps= con.prepareStatement(query); //Precompila o interpreta la sentencia
            //Acomodar los valores faltantes
            ps.setInt(1, mov.getCuentaId());
            ps.setString(2, mov.getTipo());
            ps.setDate(3,mov.getFecha());
            ps.setDouble(4, mov.getMonto());
            int z = ps.executeUpdate();
            if(z>0){
                System.out.println("Movimiento registrado correctamente");
            }else{
                System.out.println("Error al registrar el movimiento");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }







}
