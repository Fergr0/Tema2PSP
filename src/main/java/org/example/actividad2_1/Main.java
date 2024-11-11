package org.example.actividad2_1;

public class Main {

    /*No, no se ejecuta de manera ordenada (TIC, TAC, TIC, TAC...) ya que los hilos se ejecutan
    * esto se debe a que es el propio sistema quien decide en que orden se ejecuta y esto lo hace teniendo en cuenta muchos factores
    * Se llama planificador de hilos a la parte del sistema que los ejecuta en un orden en concreto*/

    public static void main(String[] args) {
        HiloTic tic = new HiloTic();
        HiloTac tac = new HiloTac();
        tic.start();
        tac.start();

    }

}
