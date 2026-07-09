package models;

import dao.CuentaDAO;
import dto.CuentaDTO;
import exception.AccountNotFoundException;
import exception.BusinessException;
import util.CuentaHelper;

import java.util.*;

//clase abstracta: Define un concepto base para la especializacion a traves de clases hijas

public abstract class Atm {
    private String ubicacion;
    private String folio;
    public static int folioOperacion = 0; //folio de cada ticket generado

    //Composicion
    public static List<CuentaDTO> dbcuentas=new ArrayList<CuentaDTO>();

    //Inyeccion de dependencias (F1): Atributo
    private final CuentaDAO cuentaDAO = new CuentaDAO();

    //Cache de retiros sin tarjeta generados
    public static Map<String,Double> cacheRetirosST = new HashMap<String,Double>();

    //cache de retiros ya cobrados
    public static Set<String> retirosCobrados = new HashSet<String>();


    public Atm() {
        //carga la lista de cuentas desde la db al mismo tiempo de instanciar ael objeto
//        dbcuentas = obtenerCuentas();
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

    public static Set<String> getRetirosCobrados() {
        return retirosCobrados;
    }

    public static void setRetirosCobrados(Set<String> retirosCobrados) {
        Atm.retirosCobrados = retirosCobrados;
    }

    public static Map<String, Double> getCacheRetirosST() {
        return cacheRetirosST;
    }

    public static void setCacheRetirosST(Map<String, Double> cacheRetirosST) {
        Atm.cacheRetirosST = cacheRetirosST;
    }

    @Override
    public String toString() {
        return "models.Atm{" +
                "ubicacion='" + ubicacion + '\'' +
                ", folio='" + folio + '\'' +
                ", dbcuentas=" + dbcuentas +
                '}';
    }

    //metodo abstracto: cada clase hija implementara de manera distinta (sobreescritura)
    //la logica de este metedo
    //List<Object>: Lista de objetos "alg" --> sin un tipo exacto

    public abstract List<Object> cobrarRetiroSinTarjeta();


    public static CuentaDTO buscarCuenta(String dato, String nip) {
        //busqueda sobre la lista de cuentas ya cargada
        CuentaDTO encontrada = null;
        for (int i = 0; i < getDbcuentas().size(); i++) {

            if (getDbcuentas().get(i).getNumTarjeta().equals(dato)||getDbcuentas().get(i).getClabe().equals(dato)||getDbcuentas().get(i).getNumCuenta().equals(dato)) {
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
        //busqueda sobre la lista de cuentas ya cargada
        CuentaDTO encontrada = null;
        for (int i = 0; i < getDbcuentas().size(); i++) {

            if (getDbcuentas().get(i).getNumTarjeta().equals(dato)||getDbcuentas().get(i).getClabe().equals(dato)||getDbcuentas().get(i).getNumCuenta().equals(dato)) {
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
        System.out.println("Tu saldo es: "+ cuenta.getSaldo());
//        //INVOCAR AL METODO DEBUSQUEDA,
//        dto.CuentaDTO cuenta = buscarCuenta(numTarjeta);
//        //SI EL NUMERO DE CUENTA EXISTE
//        if (cuenta == null) {
//            System.out.println("No existe la cuenta");
//            //si el nip no es valido
//        } else if (!(cuenta.getNip().equals(nip))) {
//            System.out.println("Nip ingresando invalido");
//            //aqui asumo que la cuenta existe y ademas el nip es valido
//        } else {
//            //imprimo el saldo
//            System.out.println("Tu saldo es: " + cuenta.getSaldo());
//        }
    }

    //imprimir el contenido de la lista de cuentas
    public static void imprimirCuentas() {
        //acceder a la lista heredada a traves de getters
        //la cual ya esta cargada
        for(CuentaDTO c: getDbcuentas()) {
            System.out.println(c);
        }
    }//end imprimir Cuentas

    //Automatiza la generacion de los retiros sin tarjeta, generando un retiro por cada cuenta
    public static void generarRetirosSinTarjeta(){
        for (CuentaDTO cuenta:getDbcuentas()){
//            cacheRetirosST.put("100001:45678345678:6543",5000.00);
            cacheRetirosST.put(cuenta.getNumCuenta()+":"+ CuentaHelper.generarReference()+":"+CuentaHelper.generarClave(),Double.parseDouble(CuentaHelper.generarMonto()));
        }
    }

    public static void imprimirRetirosSinTarjeta(){
        for(String key : getCacheRetirosST().keySet()){
            System.out.println(key + "-->"+getCacheRetirosST().get(key));
        }
    }
} //end models.Atm