package models;

import constants.Mensajes;
import dao.CuentaDAO;
import dto.CuentaDTO;
import exception.AccountNotFoundException;
import exception.BusinessException;
import util.CuentaHelper;

import java.util.*;

//Clase abstracta: Define un concepto base para la especializacion a traves de clases hijas
public abstract class Atm {
    public static int folioOperacion = 0; //folio de cada ticket generado
    private String ubicacion;
    private String folio;
    //Composicion
    public static List<CuentaDTO> dbcuentas = new ArrayList<CuentaDTO>();

    //Inyeccion de dependencia (F1) : atributo
    public CuentaDAO cuentaDAO = new CuentaDAO();

    //Cache de retiros sin tarjeta generados
    public static Map<String, Double> cacheRetirosST = new HashMap<String,Double>();

    //cache de retiros ya cobrados
    public static Set<String> retirosCobrados = new HashSet<String>();

    public Atm() {
        //carga la lista de cuentas desde la db al mismo tiempo de instanciar el objeto
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
    public static Map<String, Double> getCacheRetirosST() {
        return cacheRetirosST;
    }
    public static void setCacheRetirosST(Map<String, Double> cacheRetirosST) {
        Atm.cacheRetirosST = cacheRetirosST;
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
                "ubicacion='" + ubicacion + '\'' +
                ", folio='" + folio + '\'' +
                ", dbcuentas=" + dbcuentas +
                '}';
    }
    //metodo abstracto: Cada clase hija implementara de manera distinta (sobreescritura)
    // la logica de este metodo
    //List<Object> : lista de objetos "algo" -> sin un tipo exacto
    public abstract List<Object> cobrarRetiroSinTarjeta();
    public static CuentaDTO buscarCuenta(String dato, String nip) throws AccountNotFoundException,BusinessException {
        //busqueda sobre la lista de cuentas ya cargada
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
            throw new AccountNotFoundException(Mensajes.ACCOUNT_NOT_FOUND);
        } else if (!(encontrada.getNip().equals(nip))) {
            throw new BusinessException(Mensajes.WRONG_NIP);
        } else {
            return encontrada;
        }
    }
    public static CuentaDTO buscarCuenta(String dato) throws AccountNotFoundException {
        //busqueda sobre la lista de cuentas ya cargada
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
            throw new AccountNotFoundException(Mensajes.ACCOUNT_NOT_FOUND);
        } else {
            return encontrada;
        }
    }
    public void consultarSaldo(CuentaDTO cuenta) {
        System.out.println("Tu saldo es:" + cuenta.getSaldo());
    }
    //imprime el contenido de la lista de cuentas
    public static void imprimirCuentas() {
        //accede a la lista heredada a traves del getter la cual ya esta cargada en este punto
        for (CuentaDTO c : getDbcuentas()) {
            System.out.println(c);
        }
    }
    //Automatiza la generacion de los retiros sin tarjeta, generando 1 retiro
    //por cada cuenta
    public static void generarRetirosSinTarjeta(){
        for(CuentaDTO cuenta:getDbcuentas()){
            cacheRetirosST.put(cuenta.getNumCuenta()+":"+
                    CuentaHelper.generarReferencia()+":"+
                    CuentaHelper.generarClave(),
                    Double.parseDouble(CuentaHelper.generarMonto()));
        }
    }
    public static void imprimirRetirosSinTarjeta(){
        for(String key:getCacheRetirosST().keySet()){
            System.out.println(key +"->"+getCacheRetirosST().get(key));
        }
    }

}
