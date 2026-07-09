package dao;

import database.ConexionOracle;
import dto.ReciboDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServicioDAO {

    Connection con = null; //Conexion a la base de datos
    PreparedStatement ps = null; //Entrada de instrucciones a la base
    ResultSet rs = null; //Salida de resultados de la base

    public Map<String, List<ReciboDTO>> obtenerCacheServicios() {
        Map<String, List<ReciboDTO>> datos = new HashMap<String, List<ReciboDTO>>();
        ReciboDTO dto = null;
        String query = "SELECT * FROM CACHE_SERVICIOS"; //Esta consulta consume una vista
        try {
            //Apuntar a la unica instancia de la conexion a la base (singleton)
            con = ConexionOracle.getInstance().getCon();
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>"+con.toString());
            ps = con.prepareStatement(query);// Precopila o interpert la sentencia
            rs = ps.executeQuery();
            while (rs.next()) {
                //construir el onjeto dto
                dto = new ReciboDTO(rs.getString("REFERENCIA"), rs.getDate("FECHA_INICIO"),
                        rs.getDate("FECHA_FIN"), rs.getDouble("MONTO"), rs.getString("STATUS").charAt(0));


                //ya existe la llave?
                if (datos.containsKey(rs.getString("CONVENIO"))) {
                    datos.get(rs.getString("CONVENIO")).add(dto);
                } else {
                    datos.put(rs.getString("CONVENIO"), new ArrayList<ReciboDTO>());
                    datos.get(rs.getString("CONVENIO")).add(dto);
                }
            }

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return datos;
    }
    public void actualizarStatusRecibo(String referencia){
        String query = "UPDATE RECIBOS SET STATUS='1' WHERE REFERENCIA=?";

        try{
            //Apuntar a la unica instancia de la conexion a la base (singleton)
            con = ConexionOracle.getInstance().getCon();
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>"+con.toString());
            ps = con.prepareStatement(query);// Precopila o interpert la sentencia
            ps.setString(1,referencia);
            int x = ps.executeUpdate();

            if(x>0){
                System.out.println("Recibo pagado exitosamente");
            }else {
                System.out.println("Error al pagar recibo");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
