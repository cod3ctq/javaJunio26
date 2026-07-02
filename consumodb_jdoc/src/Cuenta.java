import java.time.LocalDate;

//Entidad : Rigida

public class Cuenta {
    private int cuentaId;
    private int clienteId;
    private int tipoCuentaId;
    private String numCuenta;
    private String clabe;
    private double saldo;
    private LocalDate fechaAp;
    private char status;


    public Cuenta(char status, LocalDate fechaAp, double saldo, String clabe, String numCuenta, int tipoCuentaId, int clienteId, int cuentaId) {
        this.status = status;
        this.fechaAp = fechaAp;
        this.saldo = saldo;
        this.clabe = clabe;
        this.numCuenta = numCuenta;
        this.tipoCuentaId = tipoCuentaId;
        this.clienteId = clienteId;
        this.cuentaId = cuentaId;
    }

    public int getCuentaId() {
        return cuentaId;
    }

    public int getClienteId() {
        return clienteId;
    }

    public int getTipoCuentaId() {
        return tipoCuentaId;
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

    public LocalDate getFechaAp() {
        return fechaAp;
    }

    public char getStatus() {
        return status;
    }

    public void setCuentaId(int cuentaId) {
        this.cuentaId = cuentaId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public void setTipoCuentaId(int tipoCuentaId) {
        this.tipoCuentaId = tipoCuentaId;
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

    public void setFechaAp(LocalDate fechaAp) {
        this.fechaAp = fechaAp;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "cuentaId=" + cuentaId +
                ", clienteId=" + clienteId +
                ", tipoCuentaId=" + tipoCuentaId +
                ", numCuenta='" + numCuenta + '\'' +
                ", clabe='" + clabe + '\'' +
                ", saldo=" + saldo +
                ", fechaAp=" + fechaAp +
                ", status=" + status +
                '}';
    }
}
