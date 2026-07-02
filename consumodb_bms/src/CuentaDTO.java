import java.time.LocalDate;


//DTO: transfer
//DTO : objeto pensado para la recepcion /transmision de datos con un enfoque flexible
public class CuentaDTO {

    //Attributes
    private int cuentaId;
    private int clienteId;
    private String numCuenta;
    private String clabe;
    private double saldo;
    private char status;
    private String numTarjeta;
    private String nip;
    private double saldoMin;
    private double saldoMax;

    public CuentaDTO(int cuentaId, int clienteId, String numCuenta, String clabe, double saldo, char status, String numTarjeta, String nip, double saldoMin, double saldoMax) {
        this.cuentaId = cuentaId;
        this.clienteId = clienteId;
        this.numCuenta = numCuenta;
        this.clabe = clabe;
        this.saldo = saldo;
        this.status = status;
        this.numTarjeta = numTarjeta;
        this.nip = nip;
        this.saldoMin = saldoMin;
        this.saldoMax = saldoMax;
    }

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

    public double getSaldoMin() {
        return saldoMin;
    }

    public void setSaldoMin(double saldoMin) {
        this.saldoMin = saldoMin;
    }

    public double getSaldoMax() {
        return saldoMax;
    }

    public void setSaldoMax(double saldoMax) {
        this.saldoMax = saldoMax;
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
                ", saldoMin=" + saldoMin +
                ", saldoMax=" + saldoMax +
                '}';
    }
}

