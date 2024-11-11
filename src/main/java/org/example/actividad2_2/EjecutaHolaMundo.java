package org.example.actividad2_2;

/*
Hola Mundo pasa 21
Hola Mundo PSP 24
Hola Mundo Antonio 23
Hola Mundo profe 22
Hola Mundo Que 20

Esta es la ejecucion sin sleep
* */

/*

En la ejecucion con el sleep de tiempo id*100 se ejecuta de manera que cuanto mas grande sea el id mas tarda en hacer el sleep
entonces, como el id se asigna a la hora de declarar el hilo, lo normal es que se ejecute en orden, ya que los primeros, tendran menos sleep
que los ultimos declarados
* */


public class EjecutaHolaMundo {
    public static void main(String[] args) {
        HiloHolaMundo h1 = new HiloHolaMundo("Que");
        HiloHolaMundo h2 = new HiloHolaMundo("pasa");
        HiloHolaMundo h3 = new HiloHolaMundo("profe");
        HiloHolaMundo h4 = new HiloHolaMundo("Antonio");
        HiloHolaMundo h5 = new HiloHolaMundo("PSP");

        new Thread(h1).start();
        new Thread(h2).start();
        new Thread(h3).start();
        new Thread(h4).start();
        new Thread(h5).start();
    }

}
