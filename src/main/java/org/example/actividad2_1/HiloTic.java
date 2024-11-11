package org.example.actividad2_1;

public class HiloTic extends Thread{

    public void run(){
        try{
            while (true){
                System.out.println("TIC");
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("");
        }


    }

}
