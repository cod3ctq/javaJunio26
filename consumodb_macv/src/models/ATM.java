package models;

import dao.CuentaDAO;
import dto.CuentaDTO;
import entity.Cuenta;
import exception.AccountNotFoundException;
import exception.BusinessException;
import util.CuentaHelper;

import java.util.*;

//Clase abstracta: Define un concepto base para la especializacion a traves de clases hijas
public abstract class ATM {
    private String ubicacion;
    private String folio;
    public static int folioOperacion = 0;//folio de cada ticket generado

    //Composicion
    public static List<CuentaDTO> dbcuentas=new ArrayList<CuentaDTO>();

    //Inyeccion de dependencias (F1) : atributo
    private final CuentaDAO cuentaDAO = new CuentaDAO();

    //cache de retiros sin tarjeta generados
    public static Map<String, Double> cacheRetirosST = new HashMap<String, Double>();

    //cache de retiros ya cobrados
    public static Set<String> retirosCobrados = new HashSet<String>();

    public ATM() {
        //carga la lista de cuentas desde la db
        //al mismo tiempo de instanciar el objeto
        dbcuentas = cuentaDAO.obtenerCuentas();
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

    public static List<CuentaDTO> getDbcuentas() {
        return dbcuentas;
    }

    public static void setDbcuentas(List<CuentaDTO> dbcuentas) {
        ATM.dbcuentas = dbcuentas;
    }

    public static Map<String, Double> getCacheRetirosST() {
        return cacheRetirosST;
    }

    public static void setCacheRetirosST(Map<String, Double> cacheRetirosST) {
        ATM.cacheRetirosST = cacheRetirosST;
    }

    public static Set<String> getRetirosCobrados() {
        return retirosCobrados;
    }

    public static void setRetirosCobrados(Set<String> retirosCobrados) {
        ATM.retirosCobrados = retirosCobrados;
    }

    @Override
    public String toString() {
        return "models.ATM{" +
                "ubicacion='" + ubicacion + '\'' +
                ", folio='" + folio + '\'' +
                ", dbcuentas=" + dbcuentas +
                '}';
    }

    //Metodo abstracto:Cada clase hija implementara de manera distina (sobreescribir)
    //la logica de este metodo
    //List<Object> : Lista de objetos 8de "algo" -> sin un tipo exacto
    public abstract List<Object>cicobrarRetirosSinTarjeta();



    public static CuentaDTO buscarCuenta(String dato, String nip){
        //Busqueda sobre la lista de cuentas ya cargada
        CuentaDTO encontrada = null;
        for(int i = 0; i<getDbcuentas().size(); i++){
            if(getDbcuentas().get(i).getNumTarjeta().equals(dato)||
                    getDbcuentas().get(i).getClabe().equals(dato)||
                    getDbcuentas().get(i).getNumCuenta().equals(dato) ){
                encontrada = getDbcuentas().get(i);
                break;
            }//fin del if
        }//FIN DEL FOR
        if (encontrada == null) {
            throw new AccountNotFoundException("No fue posible hacer la operacion, no existe la cuenta");
        } else if (!(encontrada.getNip().equals(nip))) {
            throw new BusinessException("NIP ingresado invalido");
        } else {
            return encontrada;
        }
    }

    public static CuentaDTO buscarCuenta(String dato)throws AccountNotFoundException{
        //Busqueda sobre la lista de cuentas ya cargada
        CuentaDTO encontrada = null;
        for(int i = 0; i<getDbcuentas().size(); i++){
            if(getDbcuentas().get(i).getNumTarjeta().equals(dato)||
                    getDbcuentas().get(i).getClabe().equals(dato)||
                    getDbcuentas().get(i).getNumCuenta().equals(dato) ){
                encontrada = getDbcuentas().get(i);
                break;
            }//fin del if
        }//FIN DEL FOR
        if (encontrada == null) {
            throw new AccountNotFoundException("No fue posible hacer la operacion, no existe la cuenta");
        } else {
            return encontrada;
        }
    }

    public void consultarSaldo(CuentaDTO cuenta){
        System.out.println("Tu saldo es: " + cuenta.getSaldo());
    }
    //registro de movimientos



    //imprime el contenido de la lista de cuentas
    public static void imprimirCuentas() {
        //accede a la lista heredada a traves del getter
        //la cual ya esta cargada en este punto
        for (CuentaDTO c : getDbcuentas()) {
            System.out.println(c);
        }
    }

    //AUTOMATIZA LA GENERACION DE LOS RETIROS SIN TARJETA, GENERANDO 1 RETIRO POR CASA CUENTA

    public static void generarRetirosSinTarjeta(){

        for(CuentaDTO cuenta:getDbcuentas()){

            cacheRetirosST.put(cuenta.getNumTarjeta()+":"+
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
