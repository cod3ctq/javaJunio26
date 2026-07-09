package database;

import java.sql.Connection;
import java.sql.DriverManager;

//Constructor privado: Dentro de esta clase es el unico lugar donde se puede
//Invocar la instanciacion de ella misma(privado)
//Dentro se carga el unico objeto connection que apunta directamente a la base

//PATRON SINGLETON: LIMITA LA CANTIDAD DE OBJETOS QUESE PUEDEN HACER UNA DETERMINADA CLASE A SOLO 1, GARANTIZANDO EL ESTADO Y CONSISTENCIA DE DATOS
public class ConexionOracle {

    private static ConexionOracle instancia = new ConexionOracle();
    private Connection connection;

    private String driver=OracleProvider.DRIVER;
    private String url=OracleProvider.URL;
    private String user=OracleProvider.USER;
    private String password=OracleProvider.PASSWORD;

    private ConexionOracle(){
        try{
            Class.forName(driver);
            connection = DriverManager.getConnection(url,user,password);
            // persiste los cambios de sentencia INSERT, UPDATE, SELECT
            connection.setAutoCommit(true);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static ConexionOracle getInstance(){
            return instancia;
    }

    public Connection getCon(){
        if (this.connection == null) {
            System.err.println(" ERROR CRÍTICO: La conexión a Oracle no se pudo establecer en el constructor. Revisa los datos de conexión.");
        }
        return  connection;
    }

}