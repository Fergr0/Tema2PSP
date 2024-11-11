package org.example.actividad2_4;

import java.util.Scanner;

public class MyHilo extends Thread{
    private SolicitaSuspender suspender = new SolicitaSuspender();

    private int contador = 0;

    public void suspende(){
        suspender.set(true);
    }

    public void reanuda(){
        suspender.set(false);
    }

    public void run(){
        try{
            System.out.println("Iniciando...");
                Thread.sleep(300);
                contador+=1;
                System.out.println(contador);
                suspender.esperandoParaReanudar();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
