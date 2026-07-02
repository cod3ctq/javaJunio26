
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


// Classe abstarcta: define un concepto bse para la especializacion a traves de clases hijas

public abstract class Atm {


    private String ubicacion;
    private String folio;
    public static  int folioOperacion = 0;  //folio de cada tiket generado

    //Composicion
    private List<CuentaDTO> dbcuentas;


    //Clases de JDBC, estara aqui temporalmente

    Connection con = null;   // la conexion
    PreparedStatement ps = null;  //Entrada de instrucciones a la bae
    ResultSet rs = null;    // salida de resultados a lanbase


    public Atm(){

        // carga la lista de cuentas desde la db
        //al mismo tiempo de instanciar el objeto

        dbcuentas = obtenerCuentas();

    }

    public Atm(String ubicacion, String folio) {
        this.folio = folio;
        this.ubicacion = ubicacion;
    }


    public List<CuentaDTO> getDbcuentas() {
        return dbcuentas;
    }

    public void setDbcuentas(List<CuentaDTO> dbcuentas) {
        this.dbcuentas = dbcuentas;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }


    @Override
    public String toString() {
        return "Atm{" +
                "dbcuentas=" + dbcuentas +
                ", ubicacion='" + ubicacion + '\'' +
                ", folio='" + folio + '\'' +
                '}';
    }

    //Metodo abstracto cada clase hija implementara de clase distinta (sobrescritura)
    // la logica de este metodo

    // Lista de objetos algo List<Object> sin un tipo exato

    public abstract List<Objects> cobrarRetiroSinTarjeta();

    public List<Object> retirar(String numTarjeta, String nip, double monto){


        //VALIDAR  LIMITEDE MONTO ($$$)DE RETIRO DIARIO
        //buscar la cuneta
        //validar el nip
        //Validar que el monto a returar sea menor al saldo dispopnible
        //validar que el saldo disponible menos el monto sea mayor al saldo minimo de la cuenta
        //retirar (descontar el monto)
        //Actualizar el monto de la cuenta
        //generar el tiket
        //retonar resultado

        CuentaDTO cuenta = buscarCuenta(numTarjeta);
        Tiket t1 =null;
        List<Object> data = new ArrayList<>();
        //Si la cuenta existe
        if(cuenta==null){
            System.out.println("No fue posible hacer el retiro  exixte la cuenta ");
            //si el nip es invalido
        }else if( ! (cuenta.getNip().equals(nip)) ){

            System.out.println("No fue posible hacer el retiro Nip ingresado invalido");

            //Aqui asumo que la cuenta exixte y ademas el nip es invalido

        }else if(monto> cuenta.getSaldo()){
            //Imprimir el saldo
            System.out.println("Sldo insuficiente");
        }else if ((cuenta.getSaldo()-monto)< cuenta.getSaldoMin()){
            //validar que (saldo disponible - monto) > saldo minimo de la cuenta
            System.out.println("Retiro no disponible, limite inferior alcanzado");
        }else {
            //Calcular el indice de donde tome el objeto original
            int index = this.getDbcuentas().indexOf(cuenta);
            //retirar (descontar el monto)
            //actualizar el saldo de la cuenta
            cuenta.setSaldo(cuenta.getSaldo()-monto);

            //actualizar el saldo de la cuenta (la que esta en la lista )

            this.getDbcuentas().set(index, cuenta);
            //generar el tiket
            //invocar el moviiento que genera el  movimiento
            registrarMovimiento(new Movimientos(0,cuenta.getCuentaId(),
                    "RETIRO", Date.valueOf(LocalDate.now()) ,monto));

            //invocar al metodo que que actualiza los saldos de las cuentas
            actualizarSaldo(cuenta.getNumCuenta(),cuenta.getSaldo());



            t1 = new Tiket(this.getUbicacion(), LocalDate.now(),  //1234
                    cuenta.getNumCuenta(), "RETIRO",monto,"RT"+(folioOperacion++));

            //añade los elemntos resultantes a la lista de salida
            data.add(t1);
            data.add(monto);
        }
         //retorna resultados
        return data;
    }

    public List<CuentaDTO> obtenerCuentas(){

            // leer los mov desde la db
            String query = "SELECT CU.CUENTA_ID, CU.CLIENTE_ID, CU.TIPO_CUENTA_ID, CU.NUM_CUENTA,CU.CLABE, " +
                    " CU.SALDO, CU.FECHA_AP, CU.STATUS, T.NUM_TARJETA, T.NIP, TC.SALDO_MIN, TC.SALDO_MAX " +
                    " FROM CUENTAS CU INNER JOIN TARJETAS T " +
                    " ON CU.CUENTA_ID = T.CUENTA_ID " +
                    " INNER JOIN TIPO_CUENTA TC " +
                    " ON CU.TIPO_CUENTA_ID = TC.TIPO_CUENTA_ID";
            List<CuentaDTO> cuenta = new ArrayList<CuentaDTO>();             // Principis solid
            CuentaDTO c= null;
            try {
                Class.forName("oracle.jdbc.OracleDriver");//Cargar el driver de conexion
                con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "db1", "admin"); //inicializar la conexion a db con las credenciales del usuario
                ps = con.prepareStatement(query);// precompilar o interpretar la sentancia
                rs = ps.executeQuery();// ejecutar la sentencia, capturando los resultados


                while (rs.next()) { // ejecutar la sentencia , capturando los resultados
                    c = new CuentaDTO(rs.getInt("CUENTA_ID"),rs.getInt("CLIENTE_ID"),
                            rs.getString("NUM_CUENTA"), rs.getString("CLABE"),
                           rs.getDouble("SALDO"),rs.getString("STATUS").charAt(0),
                            rs.getNString("NUM_TARJETA"),rs.getString("NIP"),
                            rs.getDouble("SALDO_MIN"),rs.getDouble("SALDO_MAX"));

                    //AÑADE A LA LISTA
                    cuenta.add(c);
                }


            }catch (Exception ex){
                ex.printStackTrace();
            }

            return cuenta;

        }

        public CuentaDTO buscarCuenta(String numTarjeta ){

        // Bsqueda sobre la lista de cuentas ya cargada

            CuentaDTO encontrada = null;
            for(int i = 0; i<getDbcuentas().size(); i++){

                if (getDbcuentas().get(i).getNumTarjeta().equals(numTarjeta)){
                    encontrada=getDbcuentas().get(i);

                    break;

                }


            }

        return encontrada;
        }


        public void consultarSaldo(String numTarjeta, String nip){



        // invocar el metodo de busqueda

            CuentaDTO cuenta = buscarCuenta(numTarjeta);
            //Si la cuenta existe
            if(cuenta==null){
                System.out.println("No exixte la cuenta ");
            }else if( ! (cuenta.getNip().equals(nip)) ){

                System.out.println("Nip ingresado invalido");
                //Aqui asumo que la cuenta exixte y ademas el nip es invalido

            }else {
                //Imprimir el saldo
                System.out.println("Tu saldo es:"+cuenta.getSaldo());
            }





            // validar el nip
            //si nip es valido
            // encontrar el saldo
            //mandar mensaje nip invalido
            //mandar mensaje no existe la cuenta


        }



        //registro del movimiento
        public void registrarMovimiento (Movimientos mov){
        String query ="INSERT INTO MOVIMIENTOS(CUENTA_ID, TIPO, FECHA, MONTO)VALUES(?,?,?,?)";

            try {


                Class.forName("oracle.jdbc.OracleDriver");//Cargar el driver de conexion
                con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "db1", "admin"); //inicializar la conexion a db con las credenciales del usuario
                ps = con.prepareStatement(query);// precompilar o interpretar la sentancia


                //Acomodar los valores faltantes
                ps.setInt(1,mov.getCuentaId());
                ps.setString(2,mov.getTipo());
                ps.setDate(3, mov.getFecha());
                ps.setDouble(4,mov.getMonto());
                int z= ps.executeUpdate();

                if(z>0){
                    System.out.println("Movimiento resgistrado correctamente ");
                }else {
                    System.out.println("Error al registrar el movimiento");
                }


            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        public void actualizarSaldo(String numCuenta, double nuevoSaldo){
        String query = "UPDATE CUENTAS SET SALDO = ? WHERE NUM_CUENTA = ?";
         try {
             Class.forName("oracle.jdbc.OracleDriver");//Cargar el driver de conexion
             con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "db1", "admin"); //inicializar la conexion a db con las credenciales del usuario
             ps = con.prepareStatement(query);// precompilar o interpretar la sentancia

             ps.setDouble(1,nuevoSaldo);
             ps.setString(2,numCuenta);
             int z = ps.executeUpdate();


             if (z>0){
                 System.out.println("Saldo actualizado correctamente");

             }else {
                 System.out.println("Error al actulizar el saldo");

             }


         }catch (Exception ex){
             ex.printStackTrace();

         }

        }


    }


