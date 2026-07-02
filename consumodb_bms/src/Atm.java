import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//clase abstracta: Define un concepto base para la especializacion a traves de clases hijas

public abstract class Atm {
    private String ubicacion;
    private String folio;
    public static int folioOperacion = 0; //folio de cada ticket generado

    //Composicion
    private List<CuentaDTO> dbcuentas;

    //Clases JDBC, estaran aqui temporalmente
    Connection con = null;              // La conexion a la base. (puerta)
    PreparedStatement ps = null;       // Entrada de instrucciones a la base
    ResultSet rs = null;                 // Salida de resultados de la base

    public Atm() {
        //carga la lista de cuentas desde la db al mismo tiempo de instanciar ael objeto
        dbcuentas = obtenerCuentas();
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

    public List<CuentaDTO> getDbcuentas() {
        return dbcuentas;
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

    //metodo abstracto: cada clase hija implementara de manera distinta (sobreescritura)
    //la logica de este metedo
    //List<Object>: Lista de objetos "alg" --> sin un tipo exacto

    public abstract List<Object> cobrarRetiroSinTarjeta();

    public List<Object> retirar(String numTarjeta, String nip, double monto) {
        //Invoca el metodo de Bucar
        CuentaDTO cuenta = buscarCuenta(numTarjeta);
        Ticket ti = null;
        List<Object> data = new ArrayList<>();
        //SI EL NUMERO DE CUENTA EXISTE
        if (cuenta == null) {
            System.out.println("No existe la cuenta");
            //si el nip no es valido
        } else if (!(cuenta.getNip().equals(nip))) {
            System.out.println("Nip ingresando invalido");
            //aqui asumo que la cuenta existe y ademas el nip es valido
        } else if (monto > cuenta.getSaldo()) {
            //imprimo el saldo
            System.out.println("Saldo insuficiente");
        } else if ((cuenta.getSaldo() - monto) < cuenta.getSaldoMin()) {
            System.out.println("Retiro no disponible, limite inferior alcanzado");
        } else {
            //Calcular el indice donde tome el objeto original
            int index = this.getDbcuentas().indexOf(cuenta);
            //retirar(descontar el monto)
            cuenta.setSaldo(cuenta.getSaldo() - monto);
            //actualizar el saldo de la cuenta(la que esta en la lista, reemplazando al objeto)
            this.getDbcuentas().set(index, cuenta);

            //invocar al metodo que registrea el movimiento
            registrarMovimiento(new Movimiento(0, cuenta.getCuentaId(), "RETIRO", Date.valueOf(LocalDate.now()), monto));

            actualizarSaldo(cuenta.getNumCuenta(), cuenta.getSaldo());

            //generar el ticket
            ti = new Ticket(this.getUbicacion(), LocalDate.now(), cuenta.getNumCuenta(), "RETIRO", monto, "RT" + (folioOperacion++));
            //anade los elementos resultantes a la lista de salida
            data.add(ti);
            data.add(monto);
        }
        return data;
    }

    public List<CuentaDTO> obtenerCuentas() {
        //Leer las cuentas desde la db
        String query = "SELECT CU.CUENTA_ID, CU.CLIENTE_ID, CU.TIPO_CUENTA_ID, CU.NUM_CUENTA,CU.CLABE, CU.SALDO, CU.FECHA_AP, CU.STATUS, T.NUM_TARJETA, T.NIP, TC.SALDO_MIN, TC.SALDO_MAX  FROM CUENTAS CU INNER JOIN TARJETAS T ON CU.CUENTA_ID = T.CUENTA_ID INNER JOIN TIPO_CUENTA TC ON CU.TIPO_CUENTA_ID = TC.TIPO_CUENTA_ID";      // LA INSTRUCCION DE JAVA
        List<CuentaDTO> cuentas = new ArrayList<CuentaDTO>();     // LISTA DE CUENTAS (LISTA PARALETRIZABLE)
        CuentaDTO c = null;

        try {
            // https://www.oracle.com/database/technologies/appdev/jdbc-downloads.html
            Class.forName("oracle.jdbc.OracleDriver");  //Cargar el driver de conexion
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "db1", "admin");  //Inicializar la conexion a db con las credenciales de usuario
//            con.setAutoCommit(true); // autocommit para la base de datos
            ps = con.prepareStatement(query); //Precompila o interpreta la sentenca
            rs = ps.executeQuery(); //Ejecuta la sentencia, capturando los resultados
            while (rs.next()) {
                c = new CuentaDTO(rs.getInt("CUENTA_ID"), rs.getInt("CLIENTE_ID"), rs.getString("NUM_CUENTA"), rs.getString("CLABE"), rs.getDouble("SALDO"), rs.getString("STATUS").charAt(0), rs.getString("NUM_TARJETA"), rs.getString("NIP"), rs.getDouble("SALDO_MIN"), rs.getDouble("SALDO_MAX"));
                //ANADE A LA LISTA
                cuentas.add(c);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cuentas;
    }

    public CuentaDTO buscarCuenta(String numTarjeta) {
        //busqueda sobre la lista de cuentas ya cargada
        CuentaDTO encontrada = null;
        for (int i = 0; i < getDbcuentas().size(); i++) {
            if (getDbcuentas().get(i).getNumTarjeta().equals(numTarjeta)) {
                encontrada = getDbcuentas().get(i);
                break;
            }
        }
        return encontrada;
    }

    public void consultarSaldo(String numTarjeta, String nip) {
        //INVOCAR AL METODO DEBUSQUEDA,
        CuentaDTO cuenta = buscarCuenta(numTarjeta);
        //SI EL NUMERO DE CUENTA EXISTE
        if (cuenta == null) {
            System.out.println("No existe la cuenta");
            //si el nip no es valido
        } else if (!(cuenta.getNip().equals(nip))) {
            System.out.println("Nip ingresando invalido");
            //aqui asumo que la cuenta existe y ademas el nip es valido
        } else {
            //imprimo el saldo
            System.out.println("Tu saldo es: " + cuenta.getSaldo());
        }
    }

    public void registrarMovimiento(Movimiento mov) {
        String query = "INSERT INTO MOVIMIENTOS(CUENTA_ID, TIPO, FECHA, MONTO)VALUES(?,?,?,?)";
        try {
            Class.forName("oracle.jdbc.OracleDriver");  //Cargar el driver de conexion
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "db1", "admin");    //Inicializar la conexion a db con las credenciales de usuario
            ps = con.prepareStatement(query); //Precompila o interpreta la sentencia

            //acomodar los valores faltantes
            ps.setInt(1, mov.getCuentaId());
            ps.setString(2, mov.getTipo());
            ps.setDate(3, mov.getFecha());
            ps.setDouble(4, mov.getMonto());
            int x = ps.executeUpdate(); //devuelve el conteo de filas que fueron afectadas por la sentencia

            if (x > 0) {
                System.out.println("Movimiento registrado correctamente");
            } else {
                System.out.println("Error al registrar el movimiento");
            }

        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    public void actualizarSaldo(String numCuenta, double nuevoSaldo) {
        String query = "UPDATE CUENTAS SET SALDO = ? WHERE NUM_CUENTA = ?";
        try {
            Class.forName("oracle.jdbc.OracleDriver");  //Cargar el driver de conexion
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "db1", "admin");    //Inicializar la conexion a db con las credenciales de usuario
            ps = con.prepareStatement(query); //Precompila o interpreta la sentencia
            ps.setDouble(1, nuevoSaldo);
            ps.setString(2, numCuenta);
            int x = ps.executeUpdate(); //devuelve el conteo de filas que fueron afectadas por la sentencia

            if (x > 0) {
                System.out.println("Movimiento registrado correctamente");
            } else {
                System.out.println("Error al registrar el movimiento");
            }
        } catch (Exception ex) {
            ex.getMessage();
        } //end catch
    }  // end actualizarSaldo
} //end Atm