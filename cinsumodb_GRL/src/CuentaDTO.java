import java.time.LocalDate;

public class CuentaDTO {
    private int cuentaId;
    private int cliente;
    private String numCuenta;
    private String clabe;
    private double saldo;
    private  char status;

    public double getSaldoMax() {
        return saldoMax;
    }

    public void setSaldoMax(double saldoMax) {
        this.saldoMax = saldoMax;
    }

    public double getSaldoMin() {
        return saldoMin;
    }

    public void setSaldoMin(double saldoMin) {
        this.saldoMin = saldoMin;
    }

    private String numTarjeta;
    private String nip;
    private  double saldoMin;
    private double saldoMax;
    // DTO: data transfer Object
    // objeto oensado parar la recepcion y transmision de dato con un enfoque flexibe


    public CuentaDTO(int cuentaId, int cliente, String numCuenta, String clabe, double saldo, char status, String numTarjeta, String nip, double saldoMin, double saldoMax) {
        this.cuentaId = cuentaId;
        this.cliente = cliente;
        this.numCuenta = numCuenta;
        this.clabe = clabe;
        this.saldo = saldo;
        this.status = status;
        this.numTarjeta = numTarjeta;
        this.nip = nip;
        this.saldoMin = saldoMin;
        this.saldoMax = saldoMax;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public int getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(int cuentaId) {
        this.cuentaId = cuentaId;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
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

    @Override
    public String toString() {
        return "CuentaDTO{" +
                "cuentaId=" + cuentaId +
                ", cliente=" + cliente +
                ", numCuenta='" + numCuenta + '\'' +
                ", clabe='" + clabe + '\'' +
                ", saldo=" + saldo +
                ", status=" + status +
                ", numTarjeta='" + numTarjeta + '\'' +
                ", nip='" + nip + '\'' +
                '}';
    }
}
