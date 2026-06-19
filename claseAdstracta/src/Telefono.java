import java.util.Scanner;

public abstract class Telefono {

    String marca;
    String modelo;
    Double precio;
    String gama;//solo por ser un dato demostrartivo
    String materia;

    //como metodos o comportsmientos
    //clases las clases tiene 4 formas de coportarse
    // Metodos obtenidos
    // Metodos nativos
    // Metodos heredos
    // Metodos implementados



    public void mandarMensaje (String numero, String mesanjeTexto){
        System.out.println("numero: "+numero+" mensaje: "+mesanjeTexto);
    }

    public void crearContact(){
        Scanner scan= new Scanner(System.in);
        String tempName;
        String tempNumer;

        System.out.println("Cuale es e el nombre?");
        tempName=scan.nextLine();

        System.out.println("Cuale es el numero");
        tempNumer=scan.nextLine();

        System.out.println("conctacto: "+tempName+" numero: "+tempNumer);
    }

    //sobre escritura lograr el mismo resultado de una forma distinta

    //Sobre carga de argumentos: la creación de varios métodos con el mismo nombre pero con diferentes argumentos
    //polimorfismo: sobre carga de argumentos: definir variso metodos con el mismo nombre pero distintos cantidad orden y tipo de argumentos.
    //Sobre escritura: Define varios metodos en clases distintas con el mismo nombre y resuktado pero diferente logica

    //metodo de la forma 2 metodo adstracto
    //metodo sin implementacion, solo con la firma del metodo

    //metodo que no tiene implementacion, solo con la firma del metodo (metodo abstracto)
    public abstract void llamar(String numero);

    public void llamar(String numero, String comapania){
        System.out.println("marcando a "+ numero+"  de la compañia: "+comapania);
    }

    public void llamar(String numero, int saldo){
        System.out.println("marcando a "+ numero+"  de la saldo: "+saldo);
    }



    //clases por default
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getGama() {
        return gama;
    }

    public void setGama(String gama) {
        this.gama = gama;
    }

    @Override
    public String toString() {
        return "Telefono{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", precio=" + precio +
                ", gama='" + gama + '\'' +
                ", materia='" + materia + '\'' +
                '}';
    }
}
