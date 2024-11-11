package org.example.actividad2_2;

public class HiloHolaMundo implements Runnable {

    private final String cadena;

    public HiloHolaMundo(String cadena) {
        this.cadena = cadena;
    }

    public void run(){
        long id = Thread.currentThread().getId();
        try{
            Thread.sleep(id*100);
            System.out.println("Hola Mundo " + this.cadena + " " + id);
        } catch (InterruptedException e) {
            System.out.println("");
        }

    }

}
