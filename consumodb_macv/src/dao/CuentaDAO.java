package dao;

import database.ConexionOracle;
import dto.CuentaDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//DAO : Data Access Objetc
//Separa la logica de acceso a datos, encapsulada en una clase que se encarga unicamente de eso
public class CuentaDAO {

    Connection con = null; //Conexion a la base de datos
    PreparedStatement ps = null; //Entrada de instrucciones a la base
    ResultSet rs = null; //Salida de resultados de la base





    public List<CuentaDTO> obtenerCuentas(){
        String query ="SELECT CU.CUENTA_ID, CU.CLIENTE_ID, CU.TIPO_CUENTA_ID, CU.NUM_CUENTA,CU.CLABE, CU.SALDO, " +
                "CU.FECHA_AP, CU.STATUS, T.NUM_TARJETA, T.NIP, TC.SALDO_MIN, TC.SALDO_MAX " +
                "FROM CUENTAS CU INNER JOIN TARJETAS T " +
                "ON CU.CUENTA_ID = T.CUENTA_ID " +
                "INNER JOIN TIPO_CUENTA TC " +
                "ON CU.TIPO_CUENTA_ID = TC.TIPO_CUENTA_ID ";
        List<CuentaDTO> cuentas = new ArrayList<CuentaDTO>();
        CuentaDTO c = null;

        try {
            //Apuntar a la unica instancia de la conexion a la base (singleton)
            con = ConexionOracle.getInstance().getCon();;
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><"+con.toString());
            ps = con.prepareStatement(query);// Precopila o interpert la sentencia
            rs = ps.executeQuery();//Ejecuta la sentencia , capturando los resultados
            while (rs.next()) {
                c = new CuentaDTO(rs.getInt("CUENTA_ID"),rs.getInt("CLIENTE_ID"),
                        rs.getString("NUM_CUENTA"), rs.getString("CLABE"),
                        rs.getDouble("SALDO"), rs.getString("STATUS").charAt(0),
                        rs.getString("NUM_TARJETA"), rs.getString("NIP"),
                        rs.getDouble("SALDO_MIN"), rs.getDouble("SALDO_MAX"));

                //AÑADE A LA LIST
                cuentas.add(c);
            }//fin del while
        }//fin del try
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return cuentas;
    }
    public void actualizarSaldo(String numCuenta, double nuevoSaldo){
        String query="UPDATE CUENTAS SET SALDO = ? WHERE NUM_CUENTA = ?";
        try{
            //Apuntar a la unica instancia de la conexion a la base (singleton)
            con = ConexionOracle.getInstance().getCon();
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+con.toString());
            ps = con.prepareStatement(query);// Precopila o interpert la sentencia
            ps.setDouble(1,nuevoSaldo);
            ps.setString(2,numCuenta);
            int z = ps.executeUpdate();

            if(z>0){
                System.out.println("Saldo actualizado correctamente");
            }else{
                System.out.println("Error al actualizar el saldo");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }



}
