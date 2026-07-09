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
    //Clases JDBC, estaran aqui temporalmente
    Connection con = null;              // La conexion a la base. (puerta)
    PreparedStatement ps = null;       // Entrada de instrucciones a la base
    ResultSet rs = null;                 // Salida de resultados de la base

    public Map<String, List<ReciboDTO>> obtenerCachesServicios(){
        //Instanciacion
        Map<String,List<ReciboDTO>> datos = new HashMap<String, List<ReciboDTO>>();
        ReciboDTO dto = null;
        String query="SELECT * FROM CACHE_SERVICIOS"; //esta consultaes una vista

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
            rs = ps.executeQuery();

            while (rs.next()){

                //construye el objecto dto
                dto = new ReciboDTO(rs.getString("REFERENCIA"),rs.getDate("FECHA_INICIO"),rs.getDate("FECHA_FIN"),rs.getDouble("MONTO"),rs.getString("STATUS").charAt(0));

                //ya existe la llave?
                if(datos. containsKey(rs.getString("CONVENIO"))){
                    datos.get(rs.getString("CONVENIO")).add(dto);
                }else {
                    //agrego la lleve al mapa, y su lista (vacia)
                    datos.put(rs.getString("CONVENIO"),new ArrayList<ReciboDTO>());
                    //anado el dto a la lista correspondiente
                    datos.get(rs.getString("CONVENIO")).add(dto);
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return datos;
    }

    public void actualizarStatusRecibo(String referencia){
        String query = "UPDATE RECIBOS SET STATUS = '1' WHERE REFERENCIA=?";
        try{
            // https://www.oracle.com/database/technologies/appdev/jdbc-downloads.html
            //Cargar el driver de conexion
//            Class.forName("oracle.jdbc.OracleDriver");
            //Inicializar la conexion a db con las credenciales de usuario
//            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "db1", "admin");
//            con.setAutoCommit(true); // autocommit para la base de datos
            con = ConexionOracle.getInstance().getCon(); //Apuntar a la unica instanacia de la conexion de la base
            System.out.println(">>>>>> "+con.toString());
            ps = con.prepareStatement(query); //Precompila o interpreta la sentencia
            ps.setString(1,referencia);
            int x = ps.executeUpdate();

            if (x > 0) {
                System.out.println("Recibo pagado correctamente");
            } else {
                System.out.println("Error al pagar recibo");
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
