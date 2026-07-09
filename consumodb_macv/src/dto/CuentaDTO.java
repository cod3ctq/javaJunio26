package dto;

//DTO: Data Transfer Object
//Objeto pensado para la recepcion/transmision de datos con un enfoque flexible
public class CuentaDTO {

    private int cuentaId;
    private int clienteId;
    private String numCuenta;
    private String clabe;
    private double saldo;
    private char status;
    private String numTarjeta;
    private String nip;
    private double saldomin;
    private double salfomax;

    //CONSTRUCTOR


    public CuentaDTO(int cuentaId, int clienteId, String numCuenta, String clabe, double saldo, char status, String numTarjeta, String nip, double saldomin, double salfomax) {
        this.cuentaId = cuentaId;
        this.clienteId = clienteId;
        this.numCuenta = numCuenta;
        this.clabe = clabe;
        this.saldo = saldo;
        this.status = status;
        this.numTarjeta = numTarjeta;
        this.nip = nip;
        this.saldomin = saldomin;
        this.salfomax = salfomax;
    }

    //GETTER Y SETTER

    public int getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(int cuentaId) {
        this.cuentaId = cuentaId;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }
    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getClabe() {
        return clabe;
    }

    public void setClabe(String clabe) {
        this.clabe = clabe;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public double getSaldomin() {
        return saldomin;
    }

    public void setSaldomin(double saldomin) {
        this.saldomin = saldomin;
    }

    public double getSalfomax() {
        return salfomax;
    }

    public void setSalfomax(double salfomax) {
        this.salfomax = salfomax;
    }
    //toString


    @Override
    public String toString() {
        return "dto.CuentaDTO{" +
                "cuentaId=" + cuentaId +
                ", clienteId=" + clienteId +
                ", numCuenta='" + numCuenta + '\'' +
                ", clabe='" + clabe + '\'' +
                ", saldo=" + saldo +
                ", status=" + status +
                ", numTarjeta='" + numTarjeta + '\'' +
                ", nip='" + nip + '\'' +
                ", saldomin=" + saldomin +
                ", salfomax=" + salfomax +
                '}';
    }
}
