package org.example.actividad2_1;

public class HiloTac extends Thread{

    public void run(){
        try{
            while (true){
                System.out.println("TAC");
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("");
        }

    }

}
