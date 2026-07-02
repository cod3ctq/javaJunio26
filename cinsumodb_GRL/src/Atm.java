import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//clase abstracta Define un concepto base para specialization a traves de la clase hija
public abstract class Atm {
    private String Ubicacion;
    private String folio;
    static  int folioOperacion= 0;

    //composicion
    private List<CuentaDTO> dbcuentas;

    public Atm() {
        //carga la lista de cuentas de base de datos al mismo tiempo
        //que crea la base de datos
        dbcuentas = getObtenerCuentas();
    }

    //metodo abstracto: cada clase implementata de manera distinta (sobreescritura)
    //la logica de este metodo
    public abstract List<Object> cobrarRetiroSinTarjeta();


    public List<CuentaDTO> getObtenerCuentas(){
        Connection con = null; //la conexion a la base
        PreparedStatement ps= null; //entrada de instrucciones a la base de datos
        ResultSet rs= null; // Salida de resultados de la base

        //leer los movs  desde la db
        String query ="SELECT CU.CUENTA_ID, CU.CLIENTE_ID, CU.TIPO_CUENTA_ID, CU.NUM_CUENTA, CU.CLABE, CU.SALDO,  CU.STATUS, T.NUM_TARJETA, T.NIP, TC.SALDO_MIN, TC.SALDO_MAX FROM CUENTAS CU INNER JOIN TARJETAS T ON CU.CUENTA_ID = T.CUENTA_ID INNER JOIN TIPO_CUENTA TC ON CU.TIPO_CUENTA_ID = TC.TIPO_CUENTA_ID";
        List<CuentaDTO> cuentas = new ArrayList<CuentaDTO>();
        CuentaDTO c=null;
        //TIP  De donde saco los parametros
        try{
            Class.forName("oracle.jdbc.OracleDriver" );//intentar cargar el driver de conexion
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","db1","admin");// Inicializar la conexion a la base de datos con las credenciales
            ps= con.prepareStatement(query);//precompila o interpreta las sentencia, capturando los resultados
            rs = ps.executeQuery();//ejecuta la sentencia y captura los resultados

            while (rs.next()){
               /* m= new Cuenta(rs.getInt("MOV_ID"), rs.getInt("CUENTA_ID"),
                        rs.getString("TIPO"), rs.getDate("FECHA"), rs. getDouble("MONTO"));
                mos.add(m);*/
                c = new CuentaDTO(
                        rs.getInt("CUENTA_ID"),
                        rs.getInt("CLIENTE_ID"),
                        rs.getString("NUM_CUENTA"),
                        rs.getString("CLABE"),
                        rs.getDouble("SALDO"),
                        rs.getString("STATUS").charAt(0),
                        rs.getString("NUM_TARJETA"),
                        rs.getString("NIP"),
                        rs.getDouble("SALDO_MIN"),
                        rs.getDouble("SALDO_MAX")
                );
                 cuentas.add(c);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return cuentas;
    }

    public CuentaDTO buscarCuenta(String numTarjeta) {
        CuentaDTO  encontrado=null;
        for(int i=0;i<getDbcuentas().size();i++){
            if(getDbcuentas().get(i).getNumTarjeta().equals(numTarjeta)){
                encontrado= getDbcuentas().get(i);
               // System.out.println("encontrado");
                break;
            }
        }

        return encontrado;
    }

    public void consultarSaldo(String numTarjeta, String nip){
        CuentaDTO cuenta = buscarCuenta(numTarjeta);
        if (cuenta== null){
            System.out.println("la cuenta no existe");
        } else if (!(cuenta.getNip().equals(nip))) {
            System.out.println("NIP incorrecto");
        }else{
            // aquí asumo que la cuenta existe y ademas el nip es calido
            System.out.println("Tu saldo es: "+cuenta.getSaldo());
        }
    }

    public void validarMontoDeRetiroDiario() {

    }

    public  void registrarMovimiento(Movimientos mov){
        String query = "INSERT INTO MOVIMIENTOS(MOV_ID, CUENTA_ID, TIPO, FECHA, MONTO ) VALUES (?,?,?,?,?)";

        try {
            Class.forName("oracle.jdbc.OracleDriver"); // intentar cargar el driver de conexión

            try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "db1", "admin");
                 PreparedStatement ps = con.prepareStatement(query)) {
                ps.setInt(1, mov.getMovId());
                ps.setInt(2, mov.getCuentaId());
                ps.setString(3,mov.getTipo());
                ps.setDate(4, Date.valueOf(LocalDate.now()));
                ps.setDouble(5, mov.getMonto());


                int filasAfectadas = ps.executeUpdate();
                System.out.println("Filas insertadas: " + filasAfectadas);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
    }

    public List<Object> retirar(String numTarjeta, String nip,double monto){
    CuentaDTO cuenta = buscarCuenta(numTarjeta);

    List<Object>  data= new ArrayList<>();
    Ticket ti;
    if (cuenta== null){
        System.out.println("la cuenta no existe");
    } else if (!(cuenta.getNip().equals(nip))) {
        System.out.println("NIP incorrecto");
    }else if(monto > cuenta.getSaldo()){
        System.out.println("saldo insufiiciente");
    }else if((cuenta.getSaldo()-monto)< cuenta.getSaldoMin()){
        System.out.println("limite inferior alcanzado");
    }else{

        int index=this.getDbcuentas().indexOf(cuenta);
        cuenta.setSaldo(cuenta.getSaldo() - monto);
        this.getDbcuentas().set(index,cuenta);
        registrarMovimiento(new Movimientos(ultimoMovimiento(),cuenta.getCuentaId(),"RETIRO", LocalDate.now(), monto));

        actualizarSaldo(cuenta.getNumCuenta(),cuenta.getSaldo());
        //generar ticket
        ti = new Ticket(this.getUbicacion(),LocalDate.now(),cuenta.getNumCuenta(),"RETIRO" +
                "RETIRO", monto, "RT"+String.valueOf(folioOperacion=folioOperacion+1));
        data.add(ti);
        data.add(monto);
    }



    return data;
}
    public  int ultimoMovimiento(){
        String query ="SELECT max(MOV_ID) FROM MOVIMIENTOS";
        ResultSet indiceUltimo;
        int ultimoId = 0;
        try {
            Class.forName("oracle.jdbc.OracleDriver"); // cargar el driver de conexión
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "db1", "admin");
            PreparedStatement ps = con.prepareStatement(query);
            indiceUltimo = ps.executeQuery();


            if (indiceUltimo.next()) {
                ultimoId = indiceUltimo.getInt(1); // obtiene el valor de la primera columna
            }

            // cerrar recursos
            indiceUltimo.close();
            ps.close();
            con.close();


        }catch (Exception ex){
            ex.printStackTrace();
        }
        ultimoId++;
        System.out.println(ultimoId);
        return ultimoId;

    }

    public void actualizarSaldo(String numCuenta, double nuevoSaldo){
        String query = "UPDATE CUENTAS SET SALDO = ? WHERE NUM_CUENTA = ?";

        try{
            Class.forName("oracle.jdbc.OracleDriver"); // Cargar el driver de conexión
            // Inicializar la conexión a db con las credenciales del usuario
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","db1","admin");
            PreparedStatement ps = con.prepareStatement(query); // Precompila o interpreta la sentencia
            ps.setDouble(1, nuevoSaldo);
            ps.setString(2, numCuenta);
            System.out.println(numCuenta);
            int z = ps.executeUpdate();

            if(z > 0){
                System.out.println("Saldo actualizado correctamente");
            }else{
                System.out.println("Error al actualizar saldo");
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }



    public Atm(String ubicacion, String folio) {
        Ubicacion = ubicacion;
        this.folio = folio;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        Ubicacion = ubicacion;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public List<CuentaDTO> getDbcuentas() {
        return dbcuentas;
    }

    public void setDbcuentas(List<CuentaDTO> dbcuentas) {
        this.dbcuentas = dbcuentas;
    }

    @Override
    public String toString() {
        return "Atm{" +
                "Ubicacion='" + Ubicacion + '\'' +
                ", folio='" + folio + '\'' +
                ", dbcuentas=" + dbcuentas +
                '}';
    }
}
