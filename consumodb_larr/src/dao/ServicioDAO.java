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

    Connection con = null; // Es la conexion a la base, (puerta) para entrar a la base
    PreparedStatement ps = null; // Entrada de instrucciones a la base
    ResultSet rs = null; // Salida de resultados de la base


    public Map<String, List<ReciboDTO>> obtenerCacheServicios(){
        Map<String, List<ReciboDTO>> datos = new HashMap<String, List<ReciboDTO>>();
        ReciboDTO dto = null;
        String query = "SELECT * FROM CACHE_SERVICIOS"; // Esta consulta consume uan vista (view)

        try{
            // apuntar a la unica instancia de la conexion a la base (SINGLETON)
            con = ConexionOracle.getInstance().getCon();

            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>: "+con.toString());
            ps = con.prepareStatement(query); // Precompila o interpreta la sentencia
            rs = ps.executeQuery();

            while(rs.next()){

                // Construir el objeto dto
                dto = new ReciboDTO(rs.getString("REFERENCIA"), rs.getDate("FECHA_INICIO"), rs.getDate("FECHA_FIN"), rs.getDouble("MONTO"), rs.getString("STATUS").charAt(0));

                // Ya existe la llave ?
                if(datos.containsKey(rs.getString("CONVENIO"))){

                    // Accede a la lista asociada a la llave y agrega el dto actual (Se asume que si la llave existe, su valos asociado (lista) tambien)
                    datos.get(rs.getString("CONVENIO")).add(dto);

                }else{
                    // Agrego la llave (por primera vez) al mapa y su lista vacía
                    datos.put(rs.getString("CONVENIO"), new ArrayList<ReciboDTO>());
                    // Añado al dto correspondiente
                    datos.get(rs.getString("CONVENIO")).add(dto);
                }

            }

        }catch(Exception ex){
            ex.printStackTrace();

        }
        return datos;
    }


    public void actualizarStatusRecibo(String referencia){
        String query = "UPDATE RECIBOS SET STATUS = 1 WHERE REFERENCIA = ?";

        try{
            // apuntar a la unica instancia de la conexion a la base (SINGLETON)
            con = ConexionOracle.getInstance().getCon();

            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>: "+con.toString());
            ps = con.prepareStatement(query); // Precompila o interpreta la sentencia
            ps.setString(1, referencia);
            int x = ps.executeUpdate();

            if(x > 0){
                System.out.println("Recibo pagado exitosamente");
            }else{
                System.out.println("Error al pagar recibo");
            }

        }catch(Exception ex){

        }


    }

}
