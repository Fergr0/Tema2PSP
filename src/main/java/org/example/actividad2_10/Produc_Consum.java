package org.example.actividad2_10;

/*En este ejerciciose coordinan los hilos con synchronized, wait, y notify.
El productor genera valores y espera a que el consumidor los consuma antes de continuar,
mientras el consumidor espera a que el productor produzca un valor. Esto hace que
trabajen en orden, evitando conflictos y garantizando que cada valor producido sea consumido bien.*/

public class Produc_Consum {
    public static void main(String[] args) {
        Cola cola = new Cola();
        Productor p = new Productor(cola, 1);
        Consumidor c = new Consumidor(cola, 1);
        p.start();
        c.start();
    }
}
