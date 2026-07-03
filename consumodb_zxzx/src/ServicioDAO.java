import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServicioDAO {

    Connection con = null; //La conexion a la base, (puerta)
    PreparedStatement ps = null; //Entrada de instrucciones a la base
    ResultSet rs = null; //Salida de resultados de la base

    public Map<String, List<ReciboDTO>> obtenerCacheServicios(){
        Map<String, List<ReciboDTO>> datos = new HashMap<String, List<ReciboDTO>>();
        ReciboDTO dto = null;
        String query="SELECT * FROM CACHE_SERVICIOS"; //esta consulta consume una vista (view)

        try{
            Class.forName("oracle.jdbc.OracleDriver"); //Cargar el driver de conexion
            //Inicializar la conexion a db con las credenciales del usuario
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","db4","admin");
            ps= con.prepareStatement(query); //Precompila o interpreta la sentencia
            rs = ps.executeQuery();
            while(rs.next()){
                //construye el objeto dto
                dto = new ReciboDTO(rs.getString("REFERENCIA"),rs.getDate("FECHA_INICIO"),rs.getDate("FECHA_FIN"),rs.getDouble("MONTO"), rs.getString("STATUS").charAt(0));
                //ya existe la llave ?
                if(datos.containsKey(rs.getString("CONVENIO"))){
                    //accede a la lista asociada a la llave y agrega el dto actual
                    //(se asume que si la llave existe, su valor asociado (lista) tambien)
                    datos.get(rs.getString("CONVENIO")).add(dto);
                }else{
                    //agrego la llave(por primera vez) al mapa, y su lista (vacia)
                    datos.put(rs.getString("CONVENIO"), new ArrayList<ReciboDTO>());
                    //añado el dto a la lista correspondiente
                    datos.get(rs.getString("CONVENIO")).add(dto);
                }
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }
        return datos;
    }


    public void actualizarStatusRecibo(String referencia){
        String query="UPDATE RECIBOS SET STATUS='1' WHERE REFERENCIA='"+referencia+"'";

        try{
            Class.forName("oracle.jdbc.OracleDriver"); //Cargar el driver de conexion
            //Inicializar la conexion a db con las credenciales del usuario
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","db4","admin");
            ps= con.prepareStatement(query); //Precompila o interpreta la sentencia
            int x = ps.executeUpdate();

            if (x>0) {
                System.out.println("Recibo pagado exitosamente");
            }else{
                System.out.println("Error al pagar recibo");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }





}
