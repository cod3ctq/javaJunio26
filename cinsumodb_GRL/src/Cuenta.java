import java.time.LocalDate;

public class Cuenta {
    private int cuentaId;
    private int cliente;
    private int tipoCuenta;
    private String numCuenta;
    private String clabe;
    private double saldo;
    private LocalDate fechaAp;
    private  char status;



    public Cuenta(int cuentaId, int cliente, int tipoCuenta, String numCuenta, String clabe, double saldo, LocalDate fechaAp, char status) {
        this.cuentaId = cuentaId;
        this.cliente = cliente;
        this.tipoCuenta = tipoCuenta;
        this.numCuenta = numCuenta;
        this.clabe = clabe;
        this.saldo = saldo;
        this.fechaAp = fechaAp;
        this.status = status;
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

    public int getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(int tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
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

    public LocalDate getFechaAp() {
        return fechaAp;
    }

    public void setFechaAp(LocalDate fechaAp) {
        this.fechaAp = fechaAp;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "cuentaId=" + cuentaId +
                ", cliente=" + cliente +
                ", tipoCuenta=" + tipoCuenta +
                ", numCuenta='" + numCuenta + '\'' +
                ", clabe='" + clabe + '\'' +
                ", saldo=" + saldo +
                ", fechaAp=" + fechaAp +
                ", status=" + status +
                '}';
    }
}
