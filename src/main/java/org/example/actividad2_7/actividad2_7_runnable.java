package org.example.actividad2_7;

public class actividad2_7_runnable {

    //clase contador, que contiene el recurso a compartir por los hilos
    static class Contador {
        private static int contador;

        public void incrementar() {
            for (int i = 0; i < 5000; i++) {
                contador++;
            }
        }

        public int getValor() {
            return contador;
        }
    }


    // Hilo para incrementar el contador
    static class Incrementador implements Runnable {
        private final Contador contador;

        public Incrementador(Contador contador) {
            this.contador = contador;
        }

        @Override
        public void run() {
            synchronized (contador) {
                contador.incrementar();
            }
        }
    }

    public static void main(String[] args) {
        Contador contador = new Contador();
        // Crear 5 hilos
        Thread[] hilos = new Thread[5];
        for (int i = 0; i < 5; i++) {
            hilos[i] = new Thread(new Incrementador(contador));
            hilos[i].start();
        }


        System.out.println("Valor final del contador: " + contador.getValor());
    }
}
