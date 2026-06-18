public class Main {
    public static void main(String[] args) {
        // Objeto de una clase comun y corriente

        celular c1 = new celular("Nokia", "xz Premium,", 543, "Alta", "2500", "Cristal");


        // Invocar los metodos propis de esta clase
//        c1.llamar("43456643634");
//        c1.llamar("pepe", "telcel");
//        c1.llamar("4466436",67575);
//        c1.mandarMensaje("67987879970", "hola");
//        c1.crearContacto();
        //para construir objetos compuestos primero debo construir aquelos objetos
        // de los que se compone mi objeto ´rincipla

        String[] conectividad = { "2g", "3g", "4g","5g", "wifi","Bluetooth","GPS","NFC"};
        Pantalla display = new Pantalla(120,"2k","AmoLed","Gorilla glass", 6.8,500);

        Camara cam1 = new Camara("200",100,"Ultra gran angular ",200);
        Camara cam2 = new Camara("300",10,"Tele",200);
        Camara cam3 = new Camara("400",10,"Macro ",200);
        Camara cam4 = new Camara("500",5,"tof ",200);

        Camara[] cams ={cam1,cam2,cam3,cam4};

// composicion
        Smartphone sn = new Smartphone("Samsumng", "S23 Ultra", 10000,
                "Alta ","5000","Titani", true,"Android",true,512,conectividad,display,cams);

String[] conect = {"2g","3g","wifi","Bluetoot","gps","infrarojo","usb","salidaaj"};

Pantalla display2 = new Pantalla(30,"30x240","tft","",2.8,100);

        Camara cam5 = new Camara("5",10,"tof ",200);
        Camara[] camaras = {cam5};



        Smartphone sn2 = new Smartphone("Nokia", "N95 8GB", 10000,
                "Alta ","1200","POLICARBONATO", false,"Symbian",false,8,conect,display2,cams);


        System.out.println(c1);
        System.out.println(sn);

    }
}
