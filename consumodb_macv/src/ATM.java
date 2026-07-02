import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//Clase abstracta: Define un concepto base para la especializacion a traves de clases hijas
public abstract class ATM {
    private String ubicacion;
    private String folio;
    public static int folioOperacion = 0;//folio de cada ticket generado

    //Composicion
    private List<CuentaDTO> dbcuentas;

    //Clases de JDBC estaran aqui tamporalmente
    Connection con = null; //Conexion a la base de datos
    PreparedStatement ps = null; //Entrada de instrucciones a la base
    ResultSet rs = null; //Salida de resultados de la base

    public ATM() {
        //carga la lista de cuentas desde la db
        //al mismo tiempo de instanciar el objeto
        dbcuentas = obtenerCuentas();
    }

    public ATM(String ubicacion, String folio, List<Cuenta> dbcuentas) {
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

    public List<CuentaDTO> getDbcuentas() {
        return dbcuentas;
    }

    public void setDbcuentas(List<CuentaDTO> dbcuentas) {
        this.dbcuentas = dbcuentas;
    }

    @Override
    public String toString() {
        return "ATM{" +
                "ubicacion='" + ubicacion + '\'' +
                ", folio='" + folio + '\'' +
                ", dbcuentas=" + dbcuentas +
                '}';
    }

    //Metodo abstracto:Cada clase hija implementara de manera distina (sobreescribir)
    //la logica de este metodo
    //List<Object> : Lista de objetos 8de "algo" -> sin un tipo exacto
    public abstract List<Object>cicobrarRetirosSinTarjeta();

    public List<Object>retirar(String numTarjeta, String nip, double monto){
        ///***VALIDAR LIMITE DE MONTO ($$$) DE RETIRO DIARIO***
        ///***VALIDAR LA CANTIDAD (MULTIMPOS DE 100)***

        CuentaDTO cuenta = buscarCuenta(numTarjeta);
        Ticket t1 = null;
        List<Object> data = new ArrayList<>();
        // si la cuenta no existe
        if(cuenta==null){
            System.out.println("No fue posible hacer el retiro, no existe la cuenta");
            //si nip no es valido
        }else if(!(cuenta.getNip().equals(nip))){
            System.out.println("NIo fue posible hacer el retiro, NIP ingresado invalido");
            
        } else if (monto> cuenta.getSaldo()) {
            //validar que monto a retirar sea menor al saldo disponible
            System.out.println("Saldo insuficiente");
        } else if ( (cuenta.getSaldo()- monto ) <cuenta.getSaldomin()) {
            //validar que (saldo disponible - monto) > saldo minimo de la cuenta
            System.out.println("Retiro no disponible, limite inferiror alcanzado");
        }else {
            //retirar el monto
            cuenta.setSaldo(cuenta.getSaldo() - monto);

            ///Invocar al metodo que registra el movimiento
            registrarMovimiento(new Movimiento(0, cuenta.getCuentaId(),
                    "RETIRO", Date.valueOf(LocalDate.now()),monto));
            //Invocar al metodo que actualiza los saldos de las cuentas
            actualizarSaldo(cuenta.getNumCuenta(),cuenta.getSaldo());


            //generar ticket
            t1=new Ticket(this.getUbicacion(), LocalDate.now(),
                    cuenta.getNumCuenta(),"RETIRO",monto,"RT"+(folioOperacion++));

            data.add(t1);
            data.add(monto);
        }
        return data;

        //buscar el nip
        //validar el nip
        
        //validar que monto a retirar sea menor al disponible
        //validar que (saldo dispoinle - monto)> saldo minimo de la cuenta
        //retirar (descontar el monto)
        //actualizar el saldo de la cuenta
        //generar ticket
        //retornar resultados 



    }

    public List<CuentaDTO> obtenerCuentas(){
        String query ="SELECT CU.CUENTA_ID, CU.CLIENTE_ID, CU.TIPO_CUENTA_ID, CU.NUM_CUENTA,CU.CLABE, CU.SALDO, " +
                "CU.FECHA_AP, CU.STATUS, T.NUM_TARJETA, T.NIP, TC.SALDO_MIN, TC.SALDO_MAX " +
                "FROM CUENTAS CU INNER JOIN TARJETAS T " +
                "ON CU.CUENTA_ID = T.CUENTA_ID " +
                "INNER JOIN TIPO_CUENTA TC " +
                "ON CU.TIPO_CUENTA_ID = TC.TIPO_CUENTA_ID ";
        List<CuentaDTO> cuentas = new ArrayList<CuentaDTO>();
        CuentaDTO c = null;

        try {
            Class.forName("oracle.jdbc.OracleDriver"); //Cargas el driver de conexion
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "db1", "admin"); //Inicializar la conexion a db con las credenciales del usuario
            ps = con.prepareStatement(query);// Precopila o interpert la sentencia
            rs = ps.executeQuery();//Ejecuta la sentencia , capturando los resultados
            while (rs.next()) {
                c = new CuentaDTO(rs.getInt("CUENTA_ID"),rs.getInt("CLIENTE_ID"),
                        rs.getString("NUM_CUENTA"), rs.getString("CLABE"),
                        rs.getDouble("SALDO"), rs.getString("STATUS").charAt(0),
                        rs.getString("NUM_TARJETA"), rs.getString("NIP"),
                        rs.getDouble("SALDO_MIN"), rs.getDouble("SALDO_MAX"));

                //AÑADE A LA LIST
                cuentas.add(c);
            }//fin del while
        }//fin del try
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return cuentas;
    }

    public CuentaDTO buscarCuenta(String numTarjeta){
        //Busqueda sobre la lista de cuentas ya cargada
        CuentaDTO encontrada = null;
        for(int i = 0; i<getDbcuentas().size(); i++){
            if(getDbcuentas().get(i).getNumTarjeta().equals(numTarjeta)){
                encontrada = getDbcuentas().get(i);
                break;
            }//fin del if
        }//FIN DEL FOR
        return encontrada;
    }

    public void consultarSaldo(String numTarjeta, String nip){
        //Invocar al metodo de busqueda
        CuentaDTO cuenta = buscarCuenta(numTarjeta);
        // si la cuenta no existe
        if(cuenta==null){
            System.out.println("No existe la cuenta");
            //si nip no es valido
        }else if(!(cuenta.getNip().equals(nip))){
            System.out.println("NIP ingresado invalido");
            //Aqui asumo que la cuenta existe y ademas el nip es valido
        }else {
            //imprimo el saldo
            System.out.println("Tu saldo es: "+ cuenta.getSaldo());
        }
    }
    //registro de movimientos
    public void registrarMovimiento(Movimiento mov) {

        String query = "INSERT INTO MOVIMIENTOS(CUENTA_ID, TIPO, FECHA, MONTO)VALUES(?,?,?,?)";
            try{
                Class.forName("oracle.jdbc.OracleDriver"); //Cargas el driver de conexion
                con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "db1", "admin"); //Inicializar la conexion a db con las credenciales del usuario
                ps = con.prepareStatement(query);// Precopila o interpert la sentencia

                //acomodar los valores faltantes
                ps.setInt(1,mov.getCuentaId());
                ps.setString(2,mov.getTipo());
                ps.setDate(3,mov.getFecha());
                ps.setDouble(4,mov.getMonto());
                int z= ps.executeUpdate();

                if(z>0){
                    System.out.println("Movimiento registrado correctaente");
                }else{
                    System.out.println("Error al registrar el movimiento");
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
    }
    public void actualizarSaldo(String numCuenta, double nuevoSaldo){
        String query="UPDATE CUENTAS SET SALDO = ? WHERE NUM_CUENTA = ?";
        try{
            Class.forName("oracle.jdbc.OracleDriver"); //Cargas el driver de conexion
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "db1", "admin"); //Inicializar la conexion a db con las credenciales del usuario
            ps = con.prepareStatement(query);// Precopila o interpert la sentencia
            ps.setDouble(1,nuevoSaldo);
            ps.setString(2,numCuenta);
            int z = ps.executeUpdate();

            if(z>0){
                System.out.println("Saldo actualizado correctamente");
            }else{
                System.out.println("Error al actualizar el saldo");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
