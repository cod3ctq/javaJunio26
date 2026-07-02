import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Clase abtracta: Define un concepto base para la especializacion a traves de clases hijas.
public abstract class Atm {

    private String ubicacion;
    private String folio;
    public static int folioOperacion = 0; // Folio de cada ticket generado


    // Composicion
    private List<CuentaDTO> dbcuentas;

    // Clases de JDBC, estarán aquí temporalmente
    Connection con = null; // Es la conexion a la base, (puerta) para entrar a la base
    PreparedStatement ps = null; // Entrada de instrucciones a la base
    ResultSet rs = null; // Salida de resultados de la base

    public Atm(){
        // Carga la lista de cuentas desde la base de datos al mismo tiempo de instanciar el objeto
        dbcuentas = obtenerCuentas();


    }

    // Constructor
    public Atm(String ubicacion, String folio) {
        this.ubicacion = ubicacion;
        this.folio = folio;
    }

    // Getter y Setter
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

    public List<CuentaDTO> getDbcuentas() {
        return dbcuentas;
    }

    public void setDbcuentas(List<CuentaDTO> dbcuentas) {
        this.dbcuentas = dbcuentas;
    }


    // Metodo toString ()

    @Override
    public String toString() {
        return "Atm{" +
                "ubicacion='" + ubicacion + '\'' +
                ", folio='" + folio + '\'' +
                ", dbcuentas=" + dbcuentas +
                '}';
    }



    //Metodo abstracto : Cda clase hija, implementara de manera distinta (Sobreescritura) la logica de este metodo
    // List<Object> : Lista de objetos de "algo" -----> sin un tipo exacto de dato
    public abstract List<Object> cobrarRetiroSinTarjeta();


    //------------------------------------------------------------------------------------------------------------------
    // Metodo para Obtener Cuentas

    public List<Object> retirar (String numTarjeta, String nip, double monto){

        // VALIDAR LIMITE DE MONTO ($$) DE RETIRO DIARIO ************************
        // VALIDAR LA CANTIDAD (SOLO MULTIPLOS DE 100)

        // Buscar la cuenta
        // validar el nip

        // invocar al metodo de busqueda
        CuentaDTO cuenta = buscarCuenta(numTarjeta);
        Ticket ti = null;
        List<Object> data = new ArrayList<>();
        //si la no cuenta existe
        if(cuenta == null){
            System.out.println("No fue posible hacer el retiro, no existe la cuenta");
            // si nip no es valido
        }else if (   !(cuenta.getNip().equals(nip))  ){
            System.out.println("No fue posible hacer el retiro, NIP ingresado inválido");
            // aquí asumo que la cuenta existe y ademas el nip es valido
        }else if(monto > cuenta.getSaldo()){
            // validar que monto a retirar sea menor al saldo disponible
            System.out.println("Saldo insuficiente");
        }else if((cuenta.getSaldo()-monto) < cuenta.getSaldoMin()){
            // validar que el saldo disponible - el monto sea > al saldo minimo de la cuenta
            System.out.println("Retiro no disponible, limite inferior alcanzada");
        }else{
            // calcular el indice de donde tome el objeto original
            int index = this.getDbcuentas().indexOf(cuenta);
            // retirar (descontar el monto)
            cuenta.setSaldo(cuenta.getSaldo()-monto);
            // actualizar el saldo de la cuenta (la que está en la lista, reemplazando el objeto)
            this.getDbcuentas().set(index,cuenta);

            // Invocar el metodo (registrarMovimiento) que registra el movimiento (En la base de datos)
            registrarMovimiento(new Movimiento(0, cuenta.getCuentaId(),
                    "RETIRO", Date.valueOf(LocalDate.now()),monto));


            // Invocar al metodo que actualiza los saldos en las cuentas (En la base de datos)
            actualizarSaldo(cuenta.getNumCuenta(), cuenta.getSaldo());


            // generar el ticket
//            int fo = folioOperacion ++;
            ti = new Ticket(this.getUbicacion(), LocalDate.now(),cuenta.getNumCuenta(),
                    "RETIRO",monto,"RT"+(folioOperacion++));
            // añade los elementos resultantes a la lista de salida
            data.add(ti);
            data.add(monto);
        }
        // Retornar resultados
        return data;

    }

    //------------------------------------------------------------------------------------------------------------------
    // Metodo para Obtener Cuentas

    public List<CuentaDTO> obtenerCuentas(){

        // Leer los movimientos desde la base de datos db.
        String query = "SELECT CU.CUENTA_ID, CU.CLIENTE_ID, CU.TIPO_CUENTA_ID, " +
                "CU.NUM_CUENTA,CU.CLABE, CU.SALDO, CU.FECHA_AP, CU.STATUS, T.NUM_TARJETA, T.NIP, TC.SALDO_MIN, TC.SALDO_MAX " +
                "FROM CUENTAS CU INNER JOIN TARJETAS T " +
                "ON CU.CUENTA_ID = T.CUENTA_ID " +
                "INNER JOIN TIPO_CUENTA TC " +
                "ON CU.TIPO_CUENTA_ID = TC.TIPO_CUENTA_ID";
        List<CuentaDTO> cuentas = new ArrayList<CuentaDTO>();
        CuentaDTO c = null;

        try {
            Class.forName("oracle.jdbc.OracleDriver"); // Cargar el driver de conexion
            // Inicializar la conexion a db con las credenciales del usuario
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","db1","admin");
            ps = con.prepareStatement(query); // Precompila o interpreta la sentencia
            rs = ps.executeQuery(); // Ejecuta la sentencia, capturando los resultados

            while(rs.next()){
                c = new CuentaDTO(rs.getInt("CUENTA_ID"),rs.getInt("CLIENTE_ID"),
                        rs.getString("NUM_CUENTA"), rs.getString("CLABE"),
                        rs.getDouble("SALDO"), rs.getString("STATUS").charAt(0),
                        rs.getString("NUM_TARJETA"),rs.getString("NIP"),rs.getDouble("SALDO_MIN"),
                        rs.getDouble("SALDO_MAX"));

                // AÑADE A LA LISTA
                cuentas.add(c);
            }

        }catch (Exception ex){
            ex.printStackTrace();

        } //Fin del try

        return cuentas;
    }


    //------------------------------------------------------------------------------------------------------------------
    // Metodo para Buscar Cuentas

    public CuentaDTO buscarCuenta(String numTarjeta) {
        // Busqueda sobre la lista de cuentas ya cargada
        CuentaDTO encontrada = null;
        for(int i = 0 ; i<getDbcuentas().size() ; i++){
            if(getDbcuentas().get(i).getNumTarjeta().equals(numTarjeta)){
                encontrada = getDbcuentas().get(i);
                break;
            }
        }
        return encontrada;
    }


    //------------------------------------------------------------------------------------------------------------------
    // Metodo para Consultar Saldo

    public void consultarSaldo(String numTarjeta, String nip){

        // invocar al metodo de busqueda
        CuentaDTO cuenta = buscarCuenta(numTarjeta);
        //si la no cuenta existe
        if(cuenta == null){
            System.out.println("No existe la cuenta");
            // si nip no es valido
        }else if (   !(cuenta.getNip().equals(nip))  ){
            System.out.println("Nip ingresado inválido");
            // aquí asumo que la cuenta existe y ademas el nip es valido
        }else{
            //Imprimo saldo
            System.out.println("Tu saldo es: "+cuenta.getSaldo());
        }

    }


    //------------------------------------------------------------------------------------------------------------------
    // Registro del movimiento

    public void registrarMovimiento(Movimiento mov){

        String query = "INSERT INTO MOVIMIENTOS (CUENTA_ID, TIPO, FECHA, MONTO)VALUES(?,?,?,?)";
        try{
            Class.forName("oracle.jdbc.OracleDriver"); // Cargar el driver de conexion
            // Inicializar la conexion a db con las credenciales del usuario
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","db1","admin");
            ps = con.prepareStatement(query); // Precompila o interpreta la sentencia

            // Acomodar los valores faltantes
            ps.setInt(1,mov.getCuentaId());
            ps.setString(2,mov.getTipo());
            ps.setDate(3,mov.getFecha());
            ps.setDouble(4,mov.getMonto());

            int z = ps.executeUpdate();

            if(z > 0){
                System.out.println("Movimiento registrado correctamente");
            }else{
                System.out.println("Error al registrar el movimiento");
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }


    public void actualizarSaldo(String numCuenta, double nuevoSaldo){
        String query = "UPDATE CUENTAS SET SALDO = ? WHERE NUM_CUENTA = ?";

        try{
            Class.forName("oracle.jdbc.OracleDriver"); // Cargar el driver de conexion
            // Inicializar la conexion a db con las credenciales del usuario
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","db1","admin");
            ps = con.prepareStatement(query); // Precompila o interpreta la sentencia

            ps.setDouble(1,nuevoSaldo);
            ps.setString(2, numCuenta);
            int z = ps.executeUpdate();

            if(z > 0){
                System.out.println("Saldo actualizado correctamente");
            }else{
                System.out.println("Error al actualizar el saldo");
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }

    }








}
