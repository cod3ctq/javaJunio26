package dao;

import database.ConexionOracle;
import entity.Movimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MovimientoDAO {

    Connection con = null; // Es la conexion a la base, (puerta) para entrar a la base
    PreparedStatement ps = null; // Entrada de instrucciones a la base
    ResultSet rs = null; // Salida de resultados de la base


    // Registro del movimiento

    public void registrarMovimiento(Movimiento mov){

        String query = "INSERT INTO MOVIMIENTOS (CUENTA_ID, TIPO, FECHA, MONTO)VALUES(?,?,?,?)";
        try{
            // apuntar a la unica instancia de la conexion a la base (SINGLETON)
            con = ConexionOracle.getInstance().getCon();

            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>: "+con.toString());
            ps = con.prepareStatement(query); // Precompila o interpreta la sentencia

            // Acomodar los valores faltantes
            ps.setInt(1,mov.getCuentaId());
            ps.setString(2,mov.getTipo());
            ps.setDate(3,mov.getFecha());
            ps.setDouble(4,mov.getMonto());

            int z = ps.executeUpdate();

            if(z > 0){
                System.out.println("entity.Movimiento registrado correctamente");
            }else{
                System.out.println("Error al registrar el movimiento");
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
