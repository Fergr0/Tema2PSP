package org.example.ejercicio11;

import java.util.Random;
import java.util.Random;

public class Jugador extends Thread {
    private final Arbitro arbitro; // Referencia al árbitro compartido
    private final int idJugador; // Identificador del jugador

    // Constructor
    public Jugador(Arbitro arbitro, int idJugador) {
        this.arbitro = arbitro;
        this.idJugador = idJugador;
    }

    @Override
    public void run() {
        Random random = new Random();

        // El jugador sigue intentando hasta que el juego termine
        while (!arbitro.isJuegoTerminado()) {
            // Comprueba si es su turno
            if (arbitro.getTurno() == idJugador) {
                int numeroJugado = 1 + random.nextInt(10); // Genera un número entre 1 y 10
                arbitro.comprobarJugada(idJugador, numeroJugado);

                //Sleep para que sea mas visible lo que pasa.S
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}

