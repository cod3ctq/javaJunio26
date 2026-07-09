package models;

import dao.CuentaDAO;
import dto.CuentaDTO;
import exception.AccountNotFoundException;
import exception.BussinessException;
import util.CuentaHelper;

import java.util.*;


// Classe abstarcta: define un concepto bse para la especializacion a traves de clases hijas

public abstract class Atm {


    private String ubicacion;
    private String folio;
    public static int folioOperacion = 0;  //folio de cada tiket generado

    //Composicion
    public static List<CuentaDTO> dbcuentas = new ArrayList<CuentaDTO>();


    //Inyeccion de dependencias (F1) : atributo

    private final CuentaDAO cuentaDAO = new CuentaDAO();

    //Cche de retiros sin  tarjeta generados

    public static Map<String, Double> caheRetirosST = new HashMap<String, Double>();

    //cache de retiros ya cobrados
    public static Set<String> retirosCobrados = new HashSet<String>();


    public Atm() {

        // carga la lista de cuentas desde la db
        //al mismo tiempo de instanciar el objeto

        dbcuentas = cuentaDAO.obtenerCuentas();

    }

    public Atm(String ubicacion, String folio) {
        this.folio = folio;
        this.ubicacion = ubicacion;
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

    public static int getFolioOperacion() {
        return folioOperacion;
    }

    public static void setFolioOperacion(int folioOperacion) {
        Atm.folioOperacion = folioOperacion;
    }

    public static List<CuentaDTO> getDbcuentas() {
        return dbcuentas;
    }

    public static void setDbcuentas(List<CuentaDTO> dbcuentas) {
        Atm.dbcuentas = dbcuentas;
    }


    public static Map<String, Double> getCaheRetirosST() {
        return caheRetirosST;
    }

    public static void setCaheRetirosST(Map<String, Double> caheRetirosST) {
        Atm.caheRetirosST = caheRetirosST;
    }

    public static Set<String> getRetirosCobrados() {
        return retirosCobrados;
    }

    public static void setRetirosCobrados(Set<String> retirosCobrados) {
        Atm.retirosCobrados = retirosCobrados;
    }

    @Override
    public String toString() {
        return "models.Atm{" +
                "dbcuentas=" + dbcuentas +
                ", ubicacion='" + ubicacion + '\'' +
                ", folio='" + folio + '\'' +
                '}';
    }

    //Metodo abstracto cada clase hija implementara de clase distinta (sobrescritura)
    // la logica de este metodo

    // Lista de objetos algo List<Object> sin un tipo exato

    public abstract List<Object> cobrarRetiroSinTarjeta();


    public static CuentaDTO buscarCuenta(String dato, String nip) {

        // Bsqueda sobre la lista de cuentas ya cargada

        CuentaDTO encontrada = null;
        for (int i = 0; i < getDbcuentas().size(); i++) {
            if (getDbcuentas().get(i).getNumTarjeta().equals(dato) ||
                    getDbcuentas().get(i).getClabe().equals(dato) ||
                    getDbcuentas().get(i).getNumCuenta().equals(dato)) {
                encontrada = getDbcuentas().get(i);

                break;
            }
        }

        if (encontrada == null) {
            throw new AccountNotFoundException("No fue posible hacer la operacion, no existe la cuenta");
        } else if (!(encontrada.getNip().equals(nip))) {
            throw new BussinessException("NIP ingresado invalido");
        } else {
            return encontrada;
        }

    }

    public static CuentaDTO buscarCuenta(String dato) {

        // Bsqueda sobre la lista de cuentas ya cargada

        CuentaDTO encontrada = null;
        for (int i = 0; i < getDbcuentas().size(); i++) {
            if (getDbcuentas().get(i).getNumTarjeta().equals(dato) ||
                    getDbcuentas().get(i).getClabe().equals(dato) ||
                    getDbcuentas().get(i).getNumCuenta().equals(dato)) {
                encontrada = getDbcuentas().get(i);

                break;
            }
        }

        if (encontrada == null) {
            throw new AccountNotFoundException("No fue posible hacer la operacion, no existe la cuenta");

        } else {
            return encontrada;
        }

    }


    public void consultarSaldo(CuentaDTO cuenta) {

        //Imprimir el saldo
        System.out.println("Tu saldo es:" + cuenta.getSaldo());
    }


    public static void imprimirCuentas() {
        // acceder a la lista heredada  a traves del guetter
        // la cual ya esta cargada en este epunto


        for (CuentaDTO c : getDbcuentas()) {
            System.out.println(c);
        }

    }


    //Automatiza la generacion de los retiros sin tarjeta generando un retiro
    //por cada cuenta


    public static void generarRetirosSinTarjrta() {


        for (CuentaDTO cuenta : getDbcuentas()) {
            caheRetirosST.put(cuenta.getNumCuenta() + ":" + CuentaHelper.generarReferencia() + ":" + CuentaHelper.generarClave(), Double.parseDouble(CuentaHelper.generarMonto()));

        }
    }

    public static void imprimirRetiroSinTarjeta(){

        for (String key:getCaheRetirosST().keySet()){

            System.out.println(key+"->"+getCaheRetirosST().get(key));
        }


    }

}


