package org.example.actividad2_8;

/*
 * Cuando quitamos la palabra clave synchronized del
 *  metodo que recibe la cantidad y se le añade al saldo,
 *     estamos abriendo la posibilidad de que varios hilos
 * puedan modificar el saldo simultáneamente, lo que puede llevar
 * a condiciones de carrera.
 * Sin embargo, el código seguirá ejecutándose,
 *  pero el saldo final puede ser incorrecto,
 * ya que las actualizaciones no están garantizadas a ser atómicas.*/

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Saldo_sin_synchronized {
    private int saldo;

    // Constructor que inicializa el saldo
    public Saldo_sin_synchronized(int saldoInicial) {
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
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    // Metodo que añade una cantidad al saldo (sin sincronizacion)
    public void añadirSaldo(String quien, int cantidad) {
        int saldoInicial = this.saldo;
        this.saldo += cantidad;

        // No mostramos nada, solo actualizamos el saldo internamente.
        // Sincronizacion eliminada, lo que puede generar problemas si se usan hilos concurrentes
    }
}

// Clase que extiende Thread y utiliza el metodo de Saldo
class ActualizadorSaldo_v2 extends Thread {
    private Saldo saldo;
    private String quien;
    private int cantidad;

    // Constructor para inicializar los parametros
    public ActualizadorSaldo_v2(Saldo saldo, String quien, int cantidad) {
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
class Main_v2 {
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

        // Visualizar saldo final despues de que los hilos hayan terminado
        System.out.println("Saldo final: " + saldo.getSaldo());
    }
}

