package org.example.actividad2_4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        MyHilo h = new MyHilo();
        String cadena = "r";
        h.start();
        while (!cadena.equalsIgnoreCase("*")){
            System.out.println("Que hacemos");
            cadena = entrada.nextLine();
            if (cadena.equalsIgnoreCase("s")){
                //suspender el hilo
                h.suspende();
            } else if (cadena.equalsIgnoreCase("r")) {
                //reanudar el hilo
                h.reanuda();
                h.run();
            }
        }
        System.out.println("Bucle fuera");
    }
}
