package org.example.actividad2_1;

public class HiloHolaMundo extends Thread{

    public void run(){
        System.out.println("Hilo: " + getName() + " Hola Mundo");
    }

}
