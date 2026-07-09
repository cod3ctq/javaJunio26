package dao;

import databace.ConexionOracle;
import entity.Movimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MovimientoDAO {


    Connection con = null;   // la conexion
    PreparedStatement ps = null;  //Entrada de instrucciones a la bae
    ResultSet rs = null;    // salida de resultados a lanbase

    //registro del movimiento
    public void registrarMovimiento (Movimientos mov){
        String query ="INSERT INTO MOVIMIENTOS(CUENTA_ID, TIPO, FECHA, MONTO)VALUES(?,?,?,?)";

        try {


            //Apuntar a la unica instacia de la conexion a la base (singleton)
            con = ConexionOracle.getInstance().getCon();
            System.out.println(">>>>>>>>>>>>>>:"+con.toString());
            ps = con.prepareStatement(query);// precompilar o interpretar la sentancia


            //Acomodar los valores faltantes
            ps.setInt(1,mov.getCuentaId());
            ps.setString(2,mov.getTipo());
            ps.setDate(3, mov.getFecha());
            ps.setDouble(4,mov.getMonto());
            int z= ps.executeUpdate();

            if(z>0){
                System.out.println("Movimiento resgistrado correctamente ");
            }else {
                System.out.println("Error al registrar el movimiento");
            }


        }catch (Exception ex){
            ex.printStackTrace();
        }
    }


}
