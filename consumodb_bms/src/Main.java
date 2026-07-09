import dto.CuentaDTO;
import models.Atm;
import models.Ticket;
import services.impl.Basico;
import services.impl.PractiCaja;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Basico cb = new Basico();
        PractiCaja pc = new PractiCaja();
        pc.setUbicacion("Boulevard 24 Sur #9722");
        cb.setUbicacion("Avenida Guadalupe Blass #358");
        int flujo = 0, continuar=0;
        int seleccion = 0;
        double monto = 0.0;
        String convenio, referencia, dato, nip;
        CuentaDTO cuentaActual=null;
        Ticket ticket =  null;
        Scanner scan = new Scanner(System.in);
        try{
            imprimeLogo();
            Atm.imprimirCuentas();
            Atm.generarRetirosSinTarjeta();
            Atm.imprimirRetirosSinTarjeta();
            System.out.println("[#####  CAJERO BBVA    #####]");
            System.out.println("1: IDENTIFICARSE");
            System.out.println("2: RETIRO SIN TARJETA");
            System.out.print("?: ");
            flujo = scan.nextInt();
            scan.nextLine();

            switch(flujo){
                case 1:
                    System.out.println("INGRESA TU TARJETA");
                    dato = scan.nextLine();
                    System.out.println("INGRESA TU NIP");
                    nip = scan.nextLine();

                    cuentaActual = Atm.buscarCuenta(dato, nip);

                    while(continuar<2){
                        System.out.println("1: - CONSULTAR SALDO");
                        System.out.println("2: - RETIRAR");
                        System.out.println("3: - DEPOSITAR");
                        System.out.println("4: - PAGO DE SERVICIOS");
                        System.out.println("?: ");
                        seleccion = scan.nextInt();
                        switch (seleccion){
                            case 1:
                                cb.consultarSaldo(cuentaActual);
                                break;
                            case 2:
                                System.out.println("INGRESA EL MONTO A RETIRAR");
                                monto = scan.nextDouble();
                                ticket = (Ticket) cb.retirar(cuentaActual, monto).get(0);
                                System.out.println(ticket);
                                break;
                            case 3:
                                System.out.println("INGRESA EL MONTO A DEPOSITAR");
                                monto = scan.nextDouble();
                                ticket = pc.depositar(cuentaActual, monto);
                                System.out.println(ticket);
                                break;
                            case 4:
                                scan.nextLine();
                                System.out.println("INGRESA EL CONVENIO");
                                convenio = scan.nextLine();
                                System.out.println("INGRESA LA REFERENCIA");
                                referencia = scan.nextLine();
                                ticket = pc.pagarServicio(cuentaActual, convenio, referencia);
                                System.out.println(ticket);
                                break;

                        }
                        System.out.println("DESEA HACER OTRA OPERACION ?");
                        System.out.println("1 :SI");
                        System.out.println("2 :NO");
                        System.out.print("?: ");
                        continuar = scan.nextInt();
                    }
                    break;

                case 2:
                    do{
                        ticket = (Ticket)pc.cobrarRetiroSinTarjeta().get(0);
                        System.out.println(ticket);
                        System.out.println("DESEA HACER OTRA OPERACION ?");
                        System.out.println("1 :SI");
                        System.out.println("2 :NO");
                        System.out.print("?: ");
                        continuar = scan.nextInt();
                    } while (continuar < 2);
                    break;
            }

        }catch(Exception ex){
            ex.printStackTrace();

        }
    } //end Maina(String)

    static void imprimeLogo() throws Exception {
        String rutaImagen = "C:\\Users\\ThinkPad\\Desktop\\git\\photo_2026-07-06_08-29-22.jpg";
        BufferedImage imagen = ImageIO.read(new File(rutaImagen));
        int anchoFinal = 60;
        int altoFinal = (imagen.getHeight() * 30) / imagen.getWidth();
        String caracteres = "@%#*+=-:. ";
        for (int y = 0; y < altoFinal; y++) {
            StringBuilder linea = new StringBuilder();
            for (int x = 0; x < anchoFinal; x++) {
                int pixelX = x * imagen.getWidth() / anchoFinal;
                int pixelY = y * imagen.getHeight() / altoFinal;
                int rgb = imagen.getRGB(pixelX, pixelY);
                int rojo = (rgb >> 16) & 0xff;
                int verde = (rgb >> 8) & 0xff;
                int azul = rgb & 0xff;
                int gris = (rojo + verde + azul) / 3;
                int indice = gris * (caracteres.length() - 1) / 255;
                linea.append(caracteres.charAt(indice));
            }
            System.out.println(linea);
        }
    }
} //end Class Main;