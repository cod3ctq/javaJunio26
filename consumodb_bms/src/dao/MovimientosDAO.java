package dao;

import database.ConexionOracle;
import entity.Movimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MovimientosDAO {

    //Clases JDBC, estaran aqui temporalmente
    Connection con = null;              // La conexion a la base. (puerta)
    PreparedStatement ps = null;       // Entrada de instrucciones a la base
    ResultSet rs = null;                 // Salida de resultados de la base


    public void registrarMovimiento(Movimiento mov) {
        String query = "INSERT INTO MOVIMIENTOS(CUENTA_ID, TIPO, FECHA, MONTO)VALUES(?,?,?,?)";
        try {
            // https://www.oracle.com/database/technologies/appdev/jdbc-downloads.html
            //Cargar el driver de conexion
//            Class.forName("oracle.jdbc.OracleDriver");
            //Inicializar la conexion a db con las credenciales de usuario
//            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "db1", "admin");
//            con.setAutoCommit(true); // autocommit para la base de datos
            con = ConexionOracle.getInstance().getCon(); //Apuntar a la unica instanacia de la conexion de la base
            System.out.println(">>>>>> "+con.toString());
            ps = con.prepareStatement(query); //Precompila o interpreta la sentencia

            //acomodar los valores faltantes
            ps.setInt(1, mov.getCuentaId());
            ps.setString(2, mov.getTipo());
            ps.setDate(3, mov.getFecha());
            ps.setDouble(4, mov.getMonto());
            int x = ps.executeUpdate(); //devuelve el conteo de filas que fueron afectadas por la sentencia

            if (x > 0) {
                System.out.println("entity.Movimiento registrado correctamente");
            } else {
                System.out.println("Error al registrar el movimiento");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
