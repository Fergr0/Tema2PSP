package org.example.actividad2_2;

public class HiloTic implements Runnable {

    public void run(){
        try{
            while (true){
                System.out.println("TIC");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("");
        }


    }

}
