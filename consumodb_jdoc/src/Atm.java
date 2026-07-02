import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//Clase abstracta: Define un concepto base para la especializacion a traves de las clases hijas
public abstract class Atm {

    private String ubicacion;
    private String folio;
    public  static int folioOperacion = 0;


    // composicion
    private List<CuentaDTO> dbcuentas;
// Clases jdbc: estaran aqui temporalmente
    Connection con =null; // la conexion a la base, (puerta)
    PreparedStatement ps = null;//Entrada de instrucciones a la base
    ResultSet rs = null;// Salida de resultados a la base

    public Atm() {
        //Carga la lista de cuentas desde la bd
        //Al mismo tiempo que de instanciar
        dbcuentas =obtenerCuenta();

    }

    public Atm(String ubicacion, String folio) {
        this.ubicacion = ubicacion;
        this.folio = folio;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getFolio() {
        return folio;
    }

    public List<CuentaDTO> getDbcuentas() {
        return dbcuentas;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public void setDbcuentas(List<CuentaDTO> dbcuentas) {
        this.dbcuentas = dbcuentas;
    }

    @Override
    public String toString() {
        return "Atm{" +
                "ubicacion='" + ubicacion + '\'' +
                ", folio='" + folio + '\'' +
                ", dbcuentas=" + dbcuentas +
                '}';
    }


    //Metodo abstracto: Cada clase hija implementara de manera distinta (Sobreescritura)
    //La logica de este metodo
    //List<Object>:Lista de objetos "algo"---> si un tipo exacto
    public abstract List<Object> cobrarRetiroSinTarjeta();

    public List<Object> retirar(String numTarjeta, String nip, double monto) {

        //validar limite de monto ($$$) de retiro diario *****
        //calidar la cantidad (solo solo multiplos de 100)

        CuentaDTO cuenta = buscarCuenta(numTarjeta);
        Ticket ti = null;
        List<Object> data = new ArrayList<>();
        //si la cuenta existe
        if (cuenta == null) {
            System.out.println("No fue posible hacer el retiro, no existe la cuenta.");
            //Si Nip no es valido
        } else if (!(cuenta.getNip().equals(nip))) {
            System.out.println("No fue posible hacer el retiro, Nip ingresado invalido");
            //aqui asumo que la cuenta existe y ademas el nip es valido
        } else if (monto > cuenta.getSaldo()) {
            //validar que monto a retirar sea menor a saldo siponible
            System.out.println("saldo insuficiente");
        } else if ((cuenta.getSaldo() - monto) < cuenta.getSalfoMin()) {
            // validar que el saldo siponible- monto >saldo minimo de la cuenta
            System.out.println("Retiro no disponioble, limite inferior alcanzado");
        } else {
            //calcula el indice de dondde tome el objeto original
            int index = this.getDbcuentas().indexOf(cuenta);
            //retirar  (deescontar el monto)
            cuenta.setSaldo(cuenta.getSaldo() - monto);
            //actualizar el saldo de la cuenta (la que esta en la lista, remplazando al objeto inicial)
            this.getDbcuentas().set(index, cuenta);
            //generar ticket
            //invocar el metodo registrado el movimiento
            registrarMovimiento(new Movimiento(0,cuenta.getCuentaId(),
                    "RETIRO", Date.valueOf(LocalDate.now()),monto));
            actualizarSaldo(cuenta.getNumCuenta(),cuenta.getSaldo());

            //Invocar al metodo que actualiza los saldos de las cuentas

            ti = new Ticket(this.getUbicacion(), LocalDate.now(), cuenta.getNumCuenta(), "RETIRO", monto, "RT" + (folioOperacion=folioOperacion+1));
            //añade los elementos resltantes a la lista de salida

            data.add(ti);
            data.add(monto);

        }
        //retornar resultados
        return data;
    }

    //validar que el monto a retiras sea menor al disponible
    //validar que el saldo dispponible menos el monto sea mayor al saldo minimo de la cuenta
    //retirar (descontar el monto)
    //actualizar el saldo de la cuenta
    //generar el ticket
    //retornar resultados

    public List<CuentaDTO> obtenerCuenta(){
        //leer los movs desde la db
        String query = "SELECT CU.CUENTA_ID, CU.CLIENTE_ID, CU.TIPO_CUENTA_ID, CU.NUM_CUENTA,CU.CLABE, CU.SALDO,  " +
                "CU.FECHA_AP, CU.STATUS, T.NUM_TARJETA, T.NIP, TC.SALDO_MIN, TC.SALDO_MAX " +
                "FROM CUENTAS CU INNER JOIN TARJETAS T  " +
                "ON CU.CUENTA_ID = T.CUENTA_ID " +
                "INNER JOIN TIPO_CUENTA TC " +
                "ON CU.TIPO_CUENTA_ID = TC.TIPO_CUENTA_ID";
        List <CuentaDTO> cuentas = new ArrayList<CuentaDTO>();
        CuentaDTO c = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");//Cargar el driver de conexion
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","db1","admin");//Inicializar la conexion
            //a bd con las credenciales del usuario
            ps= con.prepareStatement(query);//Precopila o interpreta la sentencia
            rs = ps.executeQuery();//Ejecuta la sentencia, capturando los resultados

            while (rs.next()){

                c = new CuentaDTO(rs.getInt("CUENTA_ID"), rs.getInt("CLIENTE_ID"),
                        rs.getString("NUM_CUENTA"), rs.getString("CLABE"),
                        rs.getDouble("SALDO"), rs.getString("STATUS").charAt(0),
                        rs.getString("NUM_TARJETA"), rs.getString("NIP"), rs.getDouble("SALDO_MIN"), rs.getDouble("SALDO_MAX"));
                //A{ADEA LA LISTA

                cuentas.add(c);
            }


        }catch (Exception ex){
            ex.printStackTrace();
        }
        return cuentas;
    }
    public CuentaDTO buscarCuenta(String numTarjeta){
        //buscar sobre la lista de cuentas ya cargadas
        CuentaDTO encontrada = null;
        for (int i = 0; i<getDbcuentas().size();i++){
            if(getDbcuentas().get(i).getNumTarjeta().equals(numTarjeta)){
                encontrada = getDbcuentas().get(i);
                break;
            }
        }
        return encontrada;
    }

    public void consultarSaldo(String numTarjeta, String nip){

        //invocar el metodo de la busqueda
        CuentaDTO cuenta = buscarCuenta(numTarjeta);
        //si la cuenta existe
        if (cuenta==null){
            System.out.println("No existe la cuenta");
        }else if (cuenta.getNip().equals(nip)){
            System.out.println("Nip ingresado invalido");
        }else{

                System.out.println("tu saldo es:" + cuenta.getSaldo());
            }
        }
        //regustro del movimiento
        public void registrarMovimiento(Movimiento mov){
        String query = "INSERT INTO MOVIMIENTOS(CUENTA_ID, TIPO, FECHA, MONTO)VALUES(?,?,?,?)";
                try {
                    Class.forName("oracle.jdbc.OracleDriver");//Cargar el driver de conexion
                    con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","db1","admin");//Inicializar la conexion
                    //a bd con las credenciales del usuario
                    ps= con.prepareStatement(query);//Precopila o interpreta la sentencia
                    //acomodar los valores faltantes
                    ps.setInt(1, mov.getCuentaId());
                    ps.setString(2,mov.getTipo());
                    ps.setDate(3,mov.getFecha());
                    ps.setDouble(4,mov.getMonto());
                    int z = ps.executeUpdate();

                    if (z>0){
                        System.out.println("Movimiento registrado correctamente");
                    }else {
                        System.out.println("Error al registro del movimiento");
                    }

                }catch (Exception ex){
                    ex.printStackTrace();
                }
        }
    public void actualizarSaldo(String numCuenta, double nuevosaldo){
        String query = "UPDATE CUENTAS SET SALDO= WHERE NUM_CUENTA,?)";
        try {
            Class.forName("oracle.jdbc.OracleDriver");//Cargar el driver de conexion
            //Inicializar la conexion de bd con las credencuiales del usuario
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","db1","admin");//Inicializar la conexion
            ps= con.prepareStatement(query);//Precopila o interpreta la sentencia
            ps.setDouble(1, nuevosaldo);
            ps.setDouble(2, nuevosaldo);
            int z = ps.executeUpdate();

            if (z>0){
                System.out.println("Saldo actualizado correctamente");
            }else {
                System.out.println("Error al actualizar saldo");
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }

        //Invocae al metodo de busqueda
        //si la cuenta existe
        //validar nip
        //si nip es valido
        //mostrar saldo
        //sino
        //mandar mensaje nip invalido
        //no existe
        //mandar mensaje no existe la cuenta
    }
}
