package dao;

import databace.ConexionOracle;
import dto.ReciboDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServicioDAO {


    Connection con = null;   // la conexion
    PreparedStatement ps = null;  //Entrada de instrucciones a la bae
    ResultSet rs = null;    // salida de resultados a lanbase


    public Map<String , List<ReciboDTO>> obtenerCacheServicios() {
        Map<String, List<ReciboDTO>> datos = new HashMap<String, List<ReciboDTO>>();
        ReciboDTO dto = null;
        String query = "SELECT * FROM CACHE_SERVICIOS";


        try {
            //Apuntar a la unica instacia de la conexion a la base (singleton)
            con = ConexionOracle.getInstance().getCon();
            System.out.println(">>>>>>>>>>>>>>:"+con.toString());
            ps = con.prepareStatement(query);// precompilar o interpretar la sentancia
            rs = ps.executeQuery();

            while (rs.next()) {
                //CONSTRUYE EL OBJETO DTO
                dto = new ReciboDTO(rs.getString("REFERENCIA"), rs.getDate("FECHA_INICIO"), rs.getDate("FECHA_FIN"), rs.getDouble
                        ("MONTO"), rs.getString("STATUS").charAt(0));


                //YA existe la lllave ?

                if (datos.containsKey(rs.getString("CONVENIO"))) {


                    //Accede a la lista asociada a la yave y agrega el dato actual
                    //se asume que si la llave existe  su valor asociado lista tambien

                    datos.get(rs.getString("CONVENIO")).add(dto);
                } else {

                    //agrega la llave al mapa y a su lista vacia
                    datos.put(rs.getString("CONVENIO"), new ArrayList<>());
                }


            }


        } catch (Exception ex) {

        }

        return datos;

    }

    public void actualizarStatusRecibo (String referencia) {
        String query = "UPDATE RECIBOS SET '1' WHERE REFERENCIA =?";

        try {

            //Apuntar a la unica instacia de la conexion a la base (singleton)
            con = ConexionOracle.getInstance().getCon();
            System.out.println(">>>>>>>>>>>>>>:"+con.toString());
        ps = con.prepareStatement(query);// precompilar o interpretar la sentancia
        ps.setString(1, referencia);
        int x = ps.executeUpdate();

        if (x > 0) {

            System.out.println("Recibo pagado exitosamente");

        } else {
            System.out.println("Error al pagar recibo ");

        }

    }catch (Exception ex){
            ex.printStackTrace();
        }
    }


}
