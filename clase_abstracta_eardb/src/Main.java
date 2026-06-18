//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

Celular c1 = new Celular("SAMUNG",2000,
        "GALAXI A 14","MEDIA","2500","CRISTAL");
    c1.llamar("2451541512");
    c1.llamar("5454","effr");
    c1.mandarMensaje("2451541512","holis");
    c1.crearContacto();

    //--> Composicion
    //para consttruir objetos compuestos, primero debo contruir aquellos onbjetos

    String[] conectivida ={"2g","3g","4g","5g","wifi","bluetoo","gps","nfc"};

    Pantalla display =new Pantalla(120,"2k","Amoled","glas victus",6.8,500);

    // objetos indiviuduaes para el array d camaras
    Camara cam1= new Camara("200",100,"Ultra gran angular",200);
    Camara cam2= new Camara("200",100,"Ultra gran angular",200);
    Camara cam3= new Camara("200",100,"Ultra gran angular",200);
    Camara cam4= new Camara("51",100,"Ultra gran angular",200);

    //array de camaras
    Camara[] cams = {cam1,cam2,cam3,cam4};

        Camara[] camaras = {cam1};

        Smarthfone sm = new Smarthfone("Samsung",1000,"S 23 Ultra","Alta","1500","Titanio",true,
            "Android",true,512,conectivida, display,cams);

    String[] concet = {"2g","3g","wifi","blueetooh","gps","infrarrojo","usb","SALID AV"};

        Pantalla display2 =new Pantalla(45,"2k","Amoled","glas victus",6.8,500);

    Smarthfone sm2 = new Smarthfone("NOKIA",150,"VIEJO","BAJA","1500","Titanio",true,
            "Android",true,512,concet, display2,camaras);

        System.out.println(c1);
        System.out.println(sm);



    }

}
