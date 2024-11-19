package org.example.actividad2_8;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Saldo {
    private int saldo;

    // Constructor que inicializa el saldo
    public Saldo(int saldoInicial) {
        this.saldo = saldoInicial;
    }

    // Getter para obtener el saldo
    public synchronized int getSaldo() {
        try {
            // Crear un objeto Random para generar un valor aleatorio
            Random random = new Random();

            // Generar un valor aleatorio entre 1000 y 3000 milisegundos (1 a 3 segundos)
            int randomSleepTime = random.nextInt(2001) + 1000;  // entre 1000 y 3000 milisegundos

            // Pausa aleatoria simulando un proceso largo
            sleep(randomSleepTime); // Usar el valor aleatorio para el sleep
        } catch (InterruptedException e) {
            System.out.println("Interrupcion durante el sleep");
        }
        return saldo;
    }

    // Setter para modificar el saldo
    public synchronized void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    // Metodo synchronized para añadir cantidad al saldo
    public synchronized void añadirSaldo(String quien, int cantidad) {
        int saldoInicial = this.saldo;
        this.saldo += cantidad;

        // No mostramos nada, solo actualizamos el saldo internamente.
        // Información para depuración (no se imprime según tu solicitud)
    }
}

// Clase que extiende Thread y utiliza el metodo de Saldo
class ActualizadorSaldo extends Thread {
    private Saldo saldo;
    private String quien;
    private int cantidad;

    // Constructor para inicializar los parámetros
    public ActualizadorSaldo(Saldo saldo, String quien, int cantidad) {
        this.saldo = saldo;
        this.quien = quien;
        this.cantidad = cantidad;
    }

    @Override
    public void run() {
        // Usar el metodo añadirSaldo desde el hilo
        saldo.añadirSaldo(quien, cantidad);
    }
}

// Clase principal para pruebas
class Main {
    public static void main(String[] args) {
        // Crear objeto Saldo con un valor inicial
        Saldo saldo = new Saldo(100);

        // Visualizar saldo inicial
        System.out.println("Saldo inicial: " + saldo.getSaldo());

        // Crear varios hilos que compartan el mismo objeto saldo
        ActualizadorSaldo hilo1 = new ActualizadorSaldo(saldo, "Hilo 1", 50);
        ActualizadorSaldo hilo2 = new ActualizadorSaldo(saldo, "Hilo 2", 30);
        ActualizadorSaldo hilo3 = new ActualizadorSaldo(saldo, "Hilo 3", 20);

        // Iniciar los hilos
        hilo1.start();
        hilo2.start();
        hilo3.start();


        // Visualizar saldo final después de que los hilos hayan terminado
        System.out.println("Saldo final: " + saldo.getSaldo());
    }
}
