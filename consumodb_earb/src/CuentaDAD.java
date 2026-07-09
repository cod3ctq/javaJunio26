import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// DAD: DATA ACCES OBJECT
// SEPARA LA LOGICA DE ACCESO A DATOS, ENCAPSULAMIENTO DE UNA CLASE QUE SE ENCARGA UNICAMENTE DE ESO
public class CuentaDAD {
    Connection con = null;//conexion ala BD
    PreparedStatement ps = null;//entrada de instrucciones ala bsae
    ResultSet rs = null;
    public List<cuentaDTO> obtenerCuenta(){
        //leer los movimiento de la bd
        Connection con = null;//conexion ala BD
        PreparedStatement ps = null;//entrada de instrucciones ala bsae
        ResultSet rs = null;//salida de resultado de bd



        //List<Cuenta> obtenerCuentas(){
        //Leer los movs desde la db
        String query = "SELECT CU.CUENTA_ID, CU.CLIENTE_ID, CU.TIPO_CUENTA_ID, CU.NUM_CUENTA, CU.CLABE,\n" +
                "       CU.SALDO, CU.FECHA_AP, CU.STATUS, T.NUM_TARJETA, T.NIP, \n" +
                "       TC.SALDO_MIN, TC.SALDO_MAX\n" +
                "FROM CUENTAS CU \n" +
                "INNER JOIN TARJETAS T\n" +
                "    ON CU.CUENTA_ID = T.CUENTA_ID\n" +
                "INNER JOIN TIPO_CUENTA TC\n" +
                "    ON CU.TIPO_CUENTA_ID = TC.TIPO_CUENTA_ID";
        List<cuentaDTO> cuentas = new ArrayList<cuentaDTO>();
        cuentaDTO c = null;
        try {
            Class.forName( "oracle.jdbc.OracleDriver");//cargar el driver de conexion
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "db1",  "admin");//inicializar la conexion a bd con las credenciales del usuario
            ps = con.prepareStatement(query);//precompila e interpreta la sentencia
            rs = ps.executeQuery();//ejecuta la sentencia, capturando los resultados

            while(rs.next()){
                c = new cuentaDTO(rs.getInt("CUENTA_ID"),rs.getInt("CLIENTE_ID")
                        , rs.getString("NUM_CUENTA"),
                        rs.getString("CLABE"), rs.getDouble("SALDO"),
                        rs.getString("STATUS").charAt(0), rs.getString("NUM_TARJETA"),
                        rs.getString("NIP"),rs.getDouble("SALDO_MIN"),rs.getDouble("SALDO_MAX"));

                cuentas.add(c);
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }
        return cuentas;
    }



}
