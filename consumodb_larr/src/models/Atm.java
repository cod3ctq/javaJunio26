package models;

import dao.CuentaDAO;
import dto.CuentaDTO;
import exception.AccountNotFoundException;
import exception.BusinessException;
import util.CuentaHelper;

import java.util.*;

// Clase abtracta: Define un concepto base para la especializacion a traves de clases hijas.
public abstract class Atm {

    private String ubicacion;
    private String folio;
    public static int folioOperacion = 0; // Folio de cada ticket generado


    // Composicion
    public static List<CuentaDTO> dbcuentas = new ArrayList<CuentaDTO>();


    // Inyección de dependencias (F1) : atributo
    private final CuentaDAO cuentaDAO = new CuentaDAO(); // Representa una responsabilidad

    // Cache de retiros sin tarjeta generados
    public static Map<String, Double> cacheRetirosST = new HashMap<String, Double>();

    // Cache de retiros ya cobrados
    public static Set<String> retirosCobrados = new HashSet<String>();

    public Atm(){
        // Carga la lista de cuentas desde la base de datos al mismo tiempo de instanciar el objeto
        dbcuentas = cuentaDAO.obtenerCuentas();


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

    public static List<CuentaDTO> getDbcuentas() {
        return dbcuentas;
    }

    public static void setDbcuentas(List<CuentaDTO> dbcuentas) {
        Atm.dbcuentas = dbcuentas;
    }

    public static Map<String, Double> getCacheRetirosST() {
        return cacheRetirosST;
    }

    public static void setCache_RetirosST(Map<String, Double> cache_RetirosST) {
        Atm.cacheRetirosST = cache_RetirosST;
    }

    public static Set<String> getRetirosCobrados() {
        return retirosCobrados;
    }

    public static void setRetirosCobrados(Set<String> retirosCobrados) {
        Atm.retirosCobrados = retirosCobrados;
    }

    // Metodo toString ()

    @Override
    public String toString() {
        return "models.Atm{" +
                "ubicacion='" + ubicacion + '\'' +
                ", folio='" + folio + '\'' +
                ", dbcuentas=" + dbcuentas +
                '}';
    }



    //Metodo abstracto : Cda clase hija, implementara de manera distinta (Sobreescritura) la logica de este metodo
    // List<Object> : Lista de objetos de "algo" -----> sin un tipo exacto de dato
    public abstract List<Object> cobrarRetiroSinTarjeta();

    //------------------------------------------------------------------------------------------------------------------



    //------------------------------------------------------------------------------------------------------------------
    // Metodo para Buscar Cuentas

    public static CuentaDTO buscarCuenta(String dato, String nip) {
        // Busqueda sobre la lista de cuentas ya cargada
        CuentaDTO encontrada = null;
        for(int i = 0 ; i<getDbcuentas().size() ; i++){
            if(getDbcuentas().get(i).getNumTarjeta().equals(dato) ||
                    getDbcuentas().get(i).getClabe().equals(dato) ||
                    getDbcuentas().get(i).getNumCuenta().equals(dato)){
                encontrada = getDbcuentas().get(i);
                break;
            }
        }
        if (encontrada == null) {
            throw new AccountNotFoundException("No fue posible hacer la operacion, no existe la cuenta");
        } else if (!(encontrada.getNip().equals(nip))) {
            throw new BusinessException("NIP ingresado invalido");
        } else {
            return encontrada;
        }
    }


    public static CuentaDTO buscarCuenta(String dato) {
        // Busqueda sobre la lista de cuentas ya cargada
        CuentaDTO encontrada = null;
        for(int i = 0 ; i<getDbcuentas().size() ; i++){
            if(getDbcuentas().get(i).getNumTarjeta().equals(dato) ||
                    getDbcuentas().get(i).getClabe().equals(dato) ||
                    getDbcuentas().get(i).getNumCuenta().equals(dato)){
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


    //------------------------------------------------------------------------------------------------------------------
    // Metodo para Consultar Saldo

    public void consultarSaldo(CuentaDTO cuenta){
        System.out.println("Tu saldo es: " + cuenta.getSaldo());

    }



    //------------------------------------------------------------------------------------------------------------------
    // Imprime el contenido de la lista cuentas
    public static void imprimirCuentas(){

        // Accede a la lista heredada a traves de getter la cual ya está cargada en este punto
        for(CuentaDTO c : getDbcuentas()){
            System.out.println(c);
        }
    }



    // Automatiza la generación de los retiros sin tarjeta, generando un retiro por cada cuenta.

    public static void generarRetirosSinTarjeta(){

        for(CuentaDTO cuenta : getDbcuentas()){
            cacheRetirosST.put(cuenta.getNumCuenta()+":"+ CuentaHelper.generarReferencia()+":"+
                    CuentaHelper.generarClave(),Double.parseDouble(CuentaHelper.generarMonto()));
        }
    }



    public static void imprimirRetirosSinTarjeta(){
        for(String key:getCacheRetirosST().keySet()){
            System.out.println(key + "->"+getCacheRetirosST().get(key));
        }
    }







}
