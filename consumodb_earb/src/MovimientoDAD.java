import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MovimientoDAD {
    Connection con = null;//conexion ala BD
    PreparedStatement ps = null;//entrada de instrucciones ala bsae
    ResultSet rs = null;

    public void registrarMovimientos(Movimiento mov){

        Connection con = null;//conexion ala BD
        PreparedStatement ps = null;//entrada de instrucciones ala bsae
        ResultSet rs = null;//salida de resultado de bd

        String query= "INSERT INTO MOVIMIENTOS(CUENTA_ID, TIPO, FECHA, MONTO) VALUES(?,?,?,?)";

        try {
            Class.forName( "oracle.jdbc.OracleDriver");//cargar el driver de conexion
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "db1",  "admin");//inicializar la conexion a bd con las credenciales del usuario
            ps = con.prepareStatement(query);//precompila e interpreta la sentencia
            int z = ps.executeUpdate();
            //ACOMODAR LOS VALORES FALTANTES
            ps.setInt(1, mov.getCuentaId());
            ps.setString(2, mov.getTipo());
            ps.setDate(3, mov.getFecha());
            ps.setDouble(4, mov.getMonto());

            if (z>0){
                System.out.println("movimiento regstrado correctamente");
            }else {
                System.out.println("error al registrar");
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
