package org.example.actividad2_2;

public class HiloTac implements Runnable{

    public void run(){
        try{
            while (true){
                System.out.println("TAC");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("");
        }

    }

}
