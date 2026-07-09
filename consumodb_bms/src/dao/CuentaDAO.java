package dao;

import database.ConexionOracle;
import dto.CuentaDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//DAO : DATA ACESS OBJECT
//SEPARA LA LOGICA DE ACCESO A DATOS, ENCAPSULANDOLA EN UNA CLASE QUE SE ENCARGA UNICAMENTE DE ESO
public class CuentaDAO {
    //Clases JDBC, estaran aqui temporalmente
    Connection con= null;              // La conexion a la base. (puerta)
    PreparedStatement ps = null;       // Entrada de instrucciones a la base
    ResultSet rs = null;                 // Salida de resultados de la base

    public List<CuentaDTO> obtenerCuentas() {
        //Leer las cuentas desde la db
        String query = "SELECT CU.CUENTA_ID, CU.CLIENTE_ID, CU.TIPO_CUENTA_ID, CU.NUM_CUENTA,CU.CLABE, CU.SALDO, CU.FECHA_AP, CU.STATUS, T.NUM_TARJETA, T.NIP, TC.SALDO_MIN, TC.SALDO_MAX  FROM CUENTAS CU INNER JOIN TARJETAS T ON CU.CUENTA_ID = T.CUENTA_ID INNER JOIN TIPO_CUENTA TC ON CU.TIPO_CUENTA_ID = TC.TIPO_CUENTA_ID";      // LA INSTRUCCION DE JAVA
        List<CuentaDTO> cuentas = new ArrayList<CuentaDTO>();     // LISTA DE CUENTAS (LISTA PARALETRIZABLE)
        CuentaDTO c = null;

        try {
            // https://www.oracle.com/database/technologies/appdev/jdbc-downloads.html
            //Cargar el driver de conexion
//            Class.forName("oracle.jdbc.OracleDriver");
            //Inicializar la conexion a db con las credenciales de usuario
//            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "db1", "admin");
//            con.setAutoCommit(true); // autocommit para la base de datos
            con = ConexionOracle.getInstance().getCon(); //Apuntar a la unica instanacia de la conexion de la base
            System.out.println(">>>>>> "+con.toString());
            ps = con.prepareStatement(query); //Precompila o interpreta la sentenca
            rs = ps.executeQuery(); //Ejecuta la sentencia, capturando los resultados
            while (rs.next()) {
                c = new CuentaDTO(rs.getInt("CUENTA_ID"), rs.getInt("CLIENTE_ID"), rs.getString("NUM_CUENTA"), rs.getString("CLABE"), rs.getDouble("SALDO"), rs.getString("STATUS").charAt(0), rs.getString("NUM_TARJETA"), rs.getString("NIP"), rs.getDouble("SALDO_MIN"), rs.getDouble("SALDO_MAX"));
                //ANADE A LA LISTA
                cuentas.add(c);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cuentas;
    }

    public void actualizarSaldo(String numCuenta, double nuevoSaldo) {
        String query = "UPDATE CUENTAS SET SALDO = ? WHERE NUM_CUENTA = ?";
        try {
            //Cargar el driver de conexion
//            Class.forName("oracle.jdbc.OracleDriver");
            //Inicializar la conexion a db con las credenciales de usuario
//            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "db1", "admin");
            con = ConexionOracle.getInstance().getCon(); //Apuntar a la unica instanacia de la conexion de la base
            System.out.println(">>>>>> "+con.toString());
            ps = con.prepareStatement(query); //Precompila o interpreta la sentencia
            ps.setDouble(1, nuevoSaldo);
            ps.setString(2, numCuenta);
            int x = ps.executeUpdate(); //devuelve el conteo de filas que fueron afectadas por la sentencia

            if (x > 0) {
                System.out.println("Actualizacion de saldo realizado correctamente");
            } else {
                System.out.println("Error al registrar el movimiento");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } //end catch
    }  // end actualizarSaldo


}