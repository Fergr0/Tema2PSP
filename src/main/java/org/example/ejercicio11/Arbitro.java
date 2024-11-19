package org.example.ejercicio11;
public class Arbitro {
    private final int numeroAdivinar; // Número secreto
    private final int totalJugadores; // Total de jugadores
    private int turno; // Turno del jugador actual
    private boolean juegoTerminado; // Indica si el juego terminó

    // Constructor
    public Arbitro(int totalJugadores) {
        this.totalJugadores = totalJugadores;
        this.numeroAdivinar = 1 + (int) (10 * Math.random()); // Genera el número secreto
        this.turno = 1; // Comienza en el turno del jugador 1
        this.juegoTerminado = false;
        System.out.println("NÚMERO A ADIVINAR: " + numeroAdivinar);
    }

    // Devuelve el turno actual
    public synchronized int getTurno() {
        return turno;
    }

    // Indica si el juego ha terminado
    public synchronized boolean isJuegoTerminado() {
        return juegoTerminado;
    }

    // Comprueba la jugada del jugador
    public synchronized void comprobarJugada(int idJugador, int numeroJugado) {
        // Verifica si el juego ya terminó
        if (juegoTerminado) return;

        // Verifica si es el turno del jugador actual
        if (idJugador != turno) {
            System.out.println("Jugador " + idJugador + " está esperando su turno.");
            return;
        }

        System.out.println("Jugador " + idJugador + " dice: " + numeroJugado);

        // Verifica si el número jugado es correcto
        if (numeroJugado == numeroAdivinar) {
            System.out.println("¡Jugador " + idJugador + " ha acertado el número " + numeroAdivinar + "!");
            juegoTerminado = true; // Termina el juego
        } else {
            System.out.println("Jugador " + idJugador + " ha fallado.");
            // Cambia al siguiente turno
            turno = (turno % totalJugadores) + 1;
        }
    }
}
