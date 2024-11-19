package org.example.ejercicio11;

public class JuegoAdivinarNumero {
    public static void main(String[] args) {
        int totalJugadores = 3; // Número de jugadores
        Arbitro arbitro = new Arbitro(totalJugadores); // Crea el árbitro

        // Crea y lanza los hilos de los jugadores
        for (int i = 1; i <= totalJugadores; i++) {
            Jugador jugador = new Jugador(arbitro, i);
            jugador.start(); // Inicia el hilo del jugador
        }
    }
}

