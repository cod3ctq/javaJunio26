import java.time.LocalDate;

//DTO:Data Transfer Object
//Objeto pensado para la recpcion/transmicion de datos con un enfoque flexible

public class CuentaDTO {

    private int cuentaId;
    private int clienteId;
    private String numCuenta;
    private String clabe;
    private double saldo;
    private char status;
    private String numTarjeta;
    private String nip;
    private double saldoMax;
    private double salfoMin;

    public CuentaDTO(int cuentaId, int clienteId, String numCuenta, String clabe, double saldo, char status, String numTarjeta, String nip, double saldoMax, double salfoMin) {
        this.cuentaId = cuentaId;
        this.clienteId = clienteId;
        this.numCuenta = numCuenta;
        this.clabe = clabe;
        this.saldo = saldo;
        this.status = status;
        this.numTarjeta = numTarjeta;
        this.nip = nip;
        this.saldoMax = saldoMax;
        this.salfoMin = salfoMin;
    }

    public int getCuentaId() {
        return cuentaId;
    }

    public int getClienteId() {
        return clienteId;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public String getClabe() {
        return clabe;
    }

    public double getSaldo() {
        return saldo;
    }

    public char getStatus() {
        return status;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public String getNip() {
        return nip;
    }

    public double getSaldoMax() {
        return saldoMax;
    }

    public double getSalfoMin() {
        return salfoMin;
    }

    public void setCuentaId(int cuentaId) {
        this.cuentaId = cuentaId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public void setClabe(String clabe) {
        this.clabe = clabe;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public void setSaldoMax(double saldoMax) {
        this.saldoMax = saldoMax;
    }

    public void setSalfoMin(double salfoMin) {
        this.salfoMin = salfoMin;
    }

    @Override
    public String toString() {
        return "CuentaDTO{" +
                "cuentaId=" + cuentaId +
                ", clienteId=" + clienteId +
                ", numCuenta='" + numCuenta + '\'' +
                ", clabe='" + clabe + '\'' +
                ", saldo=" + saldo +
                ", status=" + status +
                ", numTarjeta='" + numTarjeta + '\'' +
                ", nip='" + nip + '\'' +
                ", saldoMax=" + saldoMax +
                ", salfoMin=" + salfoMin +
                '}';
    }
}



