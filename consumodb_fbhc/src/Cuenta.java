import java.time.LocalDate;



//Entidad : rigida
//
public class Cuenta {


    private int cuentaId;
    private int clienteId;
    private int tipoCuenta;
    private String numCuenta;
    private String clabe;
    private double saldo;
    private LocalDate fecha;
    private  char status;


    public Cuenta(int cuentaId, int clienteId, int tipoCuenta, String numCuenta, String clabe, double saldo, LocalDate fecha, char status) {
        this.clabe = clabe;
        this.clienteId = clienteId;
        this.cuentaId = cuentaId;
        this.fecha = fecha;
        this.numCuenta = numCuenta;
        this.saldo = saldo;
        this.status = status;
        this.tipoCuenta = tipoCuenta;
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
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
                ", clienteId=" + clienteId +
                ", tipoCuenta=" + tipoCuenta +
                ", numCuenta='" + numCuenta + '\'' +
                ", clabe='" + clabe + '\'' +
                ", saldo=" + saldo +
                ", fecha=" + fecha +
                ", status=" + status +
                '}';
    }
}
