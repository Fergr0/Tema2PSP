package org.example.actividad8;

import java.awt.*;

class MyHilo extends Thread {
    private TextField textField;
    private volatile boolean corriendo = true; // Estado para controlar la ejecución
    private volatile boolean suspendido = false; // Estado para suspender el hilo

    public MyHilo(TextField textField) {
        this.textField = textField; // Guardar referencia al TextField
    }

    public void run() {
        int contador = 0;
        while (corriendo) {
            try {
                synchronized (this) {
                    while (suspendido) {
                        wait(); // Esperar a que se reanude
                    }
                }
                Thread.sleep(500); // Esperar 500ms
                contador++; // Incrementar el contador
                textField.setText(Integer.toString(contador)); // Actualizar el TextField
            } catch (InterruptedException e) {
                corriendo = false; // Salir del bucle si se interrumpe
            }
        }
    }

    public void suspende() {
        suspendido = true; // Cambiar estado a suspendido
    }

    public void reanuda() {
        synchronized (this) {
            suspendido = false; // Cambiar estado a no suspendido
            notify(); // Notificar al hilo que puede continuar
        }
    }

    public void detener() {
        corriendo = false; // Cambiar estado para salir del bucle
        interrupt(); // Interrumpir el hilo si está esperando
    }
}
