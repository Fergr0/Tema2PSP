package org.example.actividad2_2;

public class Main {
    public static void main(String[] args) {
        HiloTic tic = new HiloTic();
        HiloTac tac = new HiloTac();
        new Thread(tic).start();
        new Thread(tac).start();

    }
}
