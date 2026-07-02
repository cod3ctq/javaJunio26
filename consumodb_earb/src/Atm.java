import oracle.jdbc.proxy.annotation.OnError;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//clase abstracta: define un concepto base para la especializacion atravez de clases hijas
public abstract class Atm {
    Connection con = null;//conexion ala BD
    PreparedStatement ps = null;//entrada de instrucciones ala bsae
    ResultSet rs = null;//salida de resultado de bd
    private String ubicacion;
    private String folio;
    private  static int folioOperacion =0;
    //Composicion
    private List<Cuenta> dbcuentas;


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

    public List<cuentaDTO> getDbcuentas() {
        return null;
    }

    public void setDbcuentas(List<cuentaDTO> dbcuentas) {
       // this.dbcuentas = dbcuentas;

    }

    @Override
    public String toString() {
        return "Atm{" +
                "ubicacion='" + ubicacion + '\'' +
                ", folio='" + folio + '\'' +
                ", dbcuentas=" + dbcuentas +
                '}';
    }

    public Atm(){
        //carga kalista de cuentas desde la bd al mismo tiempo de instancear el obnjeto
        //dbcuentas = obtenerCuenta();


    }

    //metodo abstracto: cada clase hija implenetra de manera distinta (sobreescritura
    // la logica de este metodo)

    public abstract List<Object> cobrarRetiroSinTarjeta();


    public List<Object> retirar(String numTarjeta, String nip, double monto){
        //VALIDAR LIMIYE DE MONTO($$$) DE RETIRO A DIARIO***
        //VALIDAR LA CANTIDAD (SOLO MULTIPLOS DE 100)


        //invocar al metodo de busqueda
        cuentaDTO cuenta = buscarCuenta(numTarjeta);
        Ticket ti = null;
        List<Object> data = new ArrayList<>();
        //si la cuenta existe
        if (cuenta == null) {
            System.out.println("no fue posible hacer el retiro, no existe la cuenta");
        }else if ( !(cuenta.getNip().equals(nip))){
         System.out.println("no fue posible hacer el retiro, Nip ingresado es Valido");
        }else if (monto > cuenta.getSaldo()){
            System.out.println("saldo insuficiente");
        }else if ((cuenta.getSaldo() - monto) < cuenta.getSaldoMin()){
            System.out.println("retiro no diswponible, limite inferior alcanzado");
        }else {
            int index = this.getDbcuentas().indexOf(cuenta);

            cuenta.setSaldo(cuenta.getSaldo()-monto);
            this.getDbcuentas().set(index, cuenta);
        //invoca al metodo que registra el movimiento
            registrarMovimientos(new Movimiento(0, cuenta.getCuentaId(),
                    "RETIRO", Date.valueOf(LocalDate.now()),monto));
        //Invocar ak metodo que actualiza los saldos de las cuentas

            actualizarSaldo(cuenta.getNumCuenta(), cuenta.getSaldo());

            //generar el ticket
            ti =new Ticket(this.getUbicacion(), LocalDate.now(),
                    cuenta.getNumCuenta(),"RETIRO",
                    monto, "RT"+(folioOperacion= folioOperacion+1));
        data.add(ti);
        data.add(monto);

        }

        // buscar la cuenta
        // validar el ni

        //validar que monto a retirar sea menor al saldo disponible
        return data;
    }
public  List<cuentaDTO> obtenerCuenta(){
    //leer los movimiento de la bd
    Connection con = null;//conexion ala BD
    PreparedStatement ps = null;//entrada de instrucciones ala bsae
    ResultSet rs = null;//salida de resultado de bd



      //List<Cuenta> obtenerCuentas(){
        //Leer los movs desde la db
        String query = "SELECT CU.CUENTA_ID, CU.CLIENTE_ID, CU.TIPO_CUENTA_ID, CU.NUM_CUENTA, CU.CLABE,\n" +
                "       CU.SALDO, CU.FECHA_AP, CU.STATUS, T.NUM_TARJETA, T.NIP, \n" +
                "       TC.SALDO_MIN, TC.SALDO_MAX\n" +
                "FROM CUENTAS CU \n" +
                "INNER JOIN TARJETAS T\n" +
                "    ON CU.CUENTA_ID = T.CUENTA_ID\n" +
                "INNER JOIN TIPO_CUENTA TC\n" +
                "    ON CU.TIPO_CUENTA_ID = TC.TIPO_CUENTA_ID";
        List<cuentaDTO> cuentas = new ArrayList<cuentaDTO>();
        cuentaDTO c = null;
        try {
            Class.forName( "oracle.jdbc.OracleDriver");//cargar el driver de conexion
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "db1",  "admin");//inicializar la conexion a bd con las credenciales del usuario
            ps = con.prepareStatement(query);//precompila e interpreta la sentencia
            rs = ps.executeQuery();//ejecuta la sentencia, capturando los resultados

            while(rs.next()){
                c = new cuentaDTO(rs.getInt("CUENTA_ID"),rs.getInt("CLIENTE_ID")
                        , rs.getString("NUM_CUENTA"),
                        rs.getString("CLABE"), rs.getDouble("SALDO"),
                        rs.getString("STATUS").charAt(0), rs.getString("NUM_TARJETA"),
                        rs.getString("NIP"),rs.getDouble("SALDO_MIN"),rs.getDouble("SALDO_MAX"));

                cuentas.add(c);
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }
        return cuentas;
}
//
    public cuentaDTO buscarCuenta(String numTarjeta){
        //busqueda sobre la lista de cuentas ya cargadas
        cuentaDTO encontrada =  null;
        for (cuentaDTO aux : getDbcuentas()){
            if (aux.getNumTarjeta().equals(numTarjeta)){
            encontrada = new cuentaDTO(aux.getCuentaId(),
                    aux.getClienteId(),aux.getNumCuenta(), aux.getClabe(), aux.getSaldo(),
                    aux.getStatus(),aux.getNumTarjeta(), aux.getNip(), aux.getSaldoMin(), aux.getSaldoMax());
            break;
            }
        }
        return encontrada;
    }

    public void consultarSaldo(String numTarjeta, String nip){

        //invocar al metodo de busqueda
        cuentaDTO cuenta = buscarCuenta(numTarjeta);
        //si la cuenta existe
        if (cuenta == null) {
            System.out.println("no exixte la cuenta");
        }else if ( !(cuenta.getNip().equals(nip))){
            System.out.println("Nip ingresado es Valido");
        }else {
            System.out.println("Tu saldo es: "+ cuenta.getSaldo());
        }

    }

    //registrar movimientos
    public void registrarMovimientos(Movimiento mov){

        Connection con = null;//conexion ala BD
        PreparedStatement ps = null;//entrada de instrucciones ala bsae
        ResultSet rs = null;//salida de resultado de bd

        String query= "INSERT INTO MOVIMIENTOS(CUENTA_ID, TIPO, FECHA, MONTO) VALUES(?,?,?,?)";

        try {
            Class.forName( "oracle.jdbc.OracleDriver");//cargar el driver de conexion
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "db1",  "admin");//inicializar la conexion a bd con las credenciales del usuario
            ps = con.prepareStatement(query);//precompila e interpreta la sentencia
            int z = ps.executeUpdate();
            //ACOMODAR LOS VALORES FALTANTES
            ps.setInt(1, mov.getCuentaId());
            ps.setString(2, mov.getTipo());
            ps.setDate(3, mov.getFecha());
            ps.setDouble(4, mov.getMonto());

            if (z>0){
                System.out.println("movimiento regstrado correctamente");
            }else {
                System.out.println("error al registrar");
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public void actualizarSaldo(String numCuenta, double nuevoSaldo){
        String query = "UPDATE CUENTAS SET SALDO = ? WHERE NUM_CUENTA =?";
        try {
            Class.forName( "oracle.jdbc.OracleDriver");//cargar el driver de conexion
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "db1",  "admin");//inicializar la conexion a bd con las credenciales del usuario
            ps = con.prepareStatement(query);
            ps.setDouble(1, nuevoSaldo);
            ps.setString(2, numCuenta);
            int z = ps.executeUpdate();
        }catch (Exception ex){

        }
    }
}
