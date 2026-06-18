//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Celular c1 = new Celular("Nokia", "1100", 1000.00,
                "Baja", "600", "Plastico");

        //Invocar los metodos propios de esta clase

//        c1.llamar("4545454545");
//        c1.mandarMensaje("4545454545","Hola");
//        c1.crearContacto();


        //--------- COMPOSICION

        //Paraconstruir objetos compuestos, primero debo construir aquellos
        //objetos de los que se compone el objeto principal.


        String[] conectividad = {"2G", "3G", "4G", "5G", "Wifi", "Bluetooth", "GPS", "NFC"};
        Pantalla dsplay = new Pantalla(120, "2K", "AMOLED", "Gorilla Glass Victus 2",
                6.8, 500);
        Camara cam1 = new Camara("200", 100, "Ultra gran angular", 2000);
        Camara cam2 = new Camara("50", 10, "Macro", 2000);
        Camara cam3 = new Camara("50", 10, "Teleobjetivo", 2000);
        Camara cam4 = new Camara("12", 5, "TOF", 2000);

        //Array de camaras
        Camara[] cams = {cam1, cam2, cam3, cam4};


        Smartphone sm = new Smartphone("Samsung", "S23 Ultra",
                10000.00, "ALTA", "5000", "TITANIO", true, "Android",
                true, 512, conectividad, dsplay, cams);




        String[] conect = {"2G", "3G", "Wifi", "Bluetooth", "GPS", "Infrarrojo", "USB", "Salida AV"};
        Pantalla display2 = new Pantalla(30, "360x240", "TFT", "",
                2.8, 100);
        Camara cam5 = new Camara("5", 10, "Macro", 800);
        //Array de camaras
        Camara[] camaras = {cam5};


        Smartphone sm2 = new Smartphone("Nokia","N95 8GB",
                8000.00,"ALTA","1200","POLICARBONATO",false, "Symbian S60",
                false,8,conect, display2,camaras);

        System.out.println(c1);
        System.out.println(sm);
        System.out.println(sm2);




    }
}