package org.example.actividad2_7;

public class actividad2_7_thread {
    static class Contador {
        private static int contador; // Compartido entre los hilos

        // Incrementar el contador
        public synchronized void incrementar() {
            for (int i = 0; i < 5000; i++) {
                contador++;
            }
        }

        // Obtener el valor del contador
        public int getContador() {
            return contador;
        }
    }

    // Hilo que extiende Thread
    static class Incrementador extends Thread {
        private final Contador contador;

        // Constructor que recibe la instancia compartida
        public Incrementador(Contador contador) {
            this.contador = contador;
        }

        @Override
        public void run() {
            contador.incrementar(); // Uso de la instancia compartida
        }
    }

    public static void main(String[] args) {
        Contador contador = new Contador(); // Instancia compartida
        Thread[] hilos = new Thread[5];

        // Crear e iniciar los hilos
        for (int i = 0; i < 5; i++) {
            hilos[i] = new Incrementador(contador);
            hilos[i].start();
        }

        // Esperar a que todos los hilos terminen
        for (Thread hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Imprimir el valor final del contador
        System.out.println("Valor final del contador: " + contador.getContador());
    }
}
