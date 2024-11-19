package org.example.actividad2_9;

/*En ambos casos, la salida no será la que queremos. Esto ocurre porque no coordinamos los hilos de manera que
    el consumidor espere hasta que el productor produzca un valor (sin consumir repetidamente el mismo dato o valores inexistentes).
    El productor espere hasta que el consumidor consuma un valor (sin sobrescribir datos aún no consumidos).*/

public class Produc_Consum {
    public static void main(String[] args) {
        Cola cola = new Cola();
        Productor p = new Productor(cola, 1);
        Consumidor c = new Consumidor(cola, 1);
        p.start();
        c.start();
    }
}
