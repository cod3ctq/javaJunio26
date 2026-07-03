import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//Clase abstracta: Define un concepto base para la especilizacion a traves de clases hijas
public abstract class Atm {


    public static int folioOperacion = 0; //folio de cada ticket generado

    private String ubicacion;
    private String folio;
    //Composicion
    public static List<CuentaDTO> dbcuentas = new ArrayList<CuentaDTO>();

    //Inyeccion de dependencia (F1) : atributo
    private final CuentaDAO cuentaDAO = new CuentaDAO();


    // Clases de JDBC, estaran aqui temporalmente
    Connection con = null; //La conexion a la base, (puerta)
    PreparedStatement ps = null; //Entrada de instrucciones a la base
    ResultSet rs = null; //Salida de resultados de la base

    public Atm(){
        //carga la lista de cuentas desde la db
        //al mismo tiempo de instanciar el objeto
        dbcuentas = cuentaDAO.obtenerCuentas();

    }

    public Atm(String ubicacion, String folio) {
        this.ubicacion = ubicacion;
        this.folio = folio;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public static List<CuentaDTO> getDbcuentas() {
        return dbcuentas;
    }

    public static void setDbcuentas(List<CuentaDTO> dbcuentas) {
        Atm.dbcuentas = dbcuentas;
    }

    public static int getFolioOperacion() {
        return folioOperacion;
    }

    public static void setFolioOperacion(int folioOperacion) {
        Atm.folioOperacion = folioOperacion;
    }

    @Override
    public String toString() {
        return "Atm{" +
                "ubicacion='" + ubicacion + '\'' +
                ", folio='" + folio + '\'' +
                ", dbcuentas=" + dbcuentas +
                '}';
    }

    //metodo abstracto: Cada clase hija implementara de manera distinta (sobreescritura)
    // la logica de este metodo
    //List<Object> : lista de objetos "algo" -> sin un tipo exacto
    public abstract List<Object> cobrarRetiroSinTarjeta();



    public CuentaDTO buscarCuenta(String dato){
        //busqueda sobre la lista de cuentas ya cargada
        CuentaDTO encontrada = null;
        for(int i = 0; i<getDbcuentas().size(); i++){

            if (getDbcuentas().get(i).getNumTarjeta().equals(dato) ||
                       getDbcuentas().get(i).getClabe().equals(dato) ||
                           getDbcuentas().get(i).getNumCuenta().equals(dato) ) {
                encontrada = getDbcuentas().get(i);
                break;
            }
        }
        return encontrada;
    }

    public void consultarSaldo(String numTarjeta, String nip){
        //invocar al metodo de busqueda
        CuentaDTO cuenta = buscarCuenta(numTarjeta);
        //si la no cuenta existe
        if(cuenta==null){
            System.out.println("No existe la cuenta");
            //si nip no es valido
        }else if( !(cuenta.getNip().equals(nip))){
            System.out.println("Nip ingresado invalido");
            //Aqui asumo que la cuenta existe y ademas el nip es valido
        }else{
            //imprimo el saldo
            System.out.println("Tu saldo es:" + cuenta.getSaldo());
        }
    }





    //imprime el contenido de la lista de cuentas
    public static void imprimirCuentas(){
        //accede a la lista heredada a traves del getter
        //la cual ya esta cargada en este punto
        for(CuentaDTO c:getDbcuentas()){
            System.out.println(c);
        }

    }


}
