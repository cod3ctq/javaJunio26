package database;

import java.sql.Connection;
import java.sql.DriverManager;
//Patron singleton: Limita la cantidad de objetos que se pueden hacer de una determinada clase
//a solo 1, garantizando el estado y consistencia de datos
public class ConexionOracle {
    private static ConexionOracle instancia = new ConexionOracle();
    private Connection connection;

    private  String driver=OracleProvider.DRIVER;
    private  String url=OracleProvider.URL;
    private  String user=OracleProvider.USERNAME;
    private  String password=OracleProvider.PASSWORD;
    //Constructor privado: Dentro de esta clase es el unico lugar donde se puede
    //invocar la instancia de ella misma (privado)
    //Dentro se carga el unico objeto connection que apunta directamente a la base
    private ConexionOracle(){
        try{
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(true);//persiste los cambios INSERT, UPDATE, DELETE
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public static ConexionOracle getInstance(){
        return instancia;
    }
    public Connection getCon(){
        return connection;
    }


}
