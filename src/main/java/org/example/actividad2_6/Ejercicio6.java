package org.example.actividad2_6;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Ejercicio6 extends JApplet {

    private JButton botonInicio;
    private JSlider deslizador1, deslizador2, deslizador3;
    private JProgressBar barraProgreso1, barraProgreso2, barraProgreso3;
    private JLabel etiquetaGanador;  // Etiqueta para mostrar el ganador
    private Thread hilo1, hilo2, hilo3;
    private AtomicBoolean carreraTerminada;  // Controla si la carrera ha terminado

    @Override
    public void init() {
        // Configurar el diseño del applet
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Estado para controlar si la carrera ha terminado
        carreraTerminada = new AtomicBoolean(false);

        // Crear los componentes de la interfaz
        botonInicio = new JButton("Comenzar Carrera");
        etiquetaGanador = new JLabel("Ganador: "); // Etiqueta para mostrar el ganador

        // Crear deslizadores con valores iniciales y rango de prioridad
        deslizador1 = new JSlider(1, 10, 5); // Rango de prioridad de 1 a 10, valor inicial 5
        deslizador2 = new JSlider(1, 10, 5);
        deslizador3 = new JSlider(1, 10, 5);

        // Crear barras de progreso (sin interacción con los deslizadores por el momento)
        barraProgreso1 = new JProgressBar(0, 100);
        barraProgreso2 = new JProgressBar(0, 100);
        barraProgreso3 = new JProgressBar(0, 100);

        // Añadir un ActionListener para el botón de inicio de la carrera
        botonInicio.addActionListener(e -> iniciarCarrera());

        // Configuración de la interfaz gráfica
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(botonInicio, gbc);

        // Añadir componentes para Hilo 1
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        gbc.gridx = 0;
        add(new JLabel("HILO 1"), gbc);

        gbc.gridx = 1;
        add(deslizador1, gbc);

        gbc.gridy = 2;
        add(barraProgreso1, gbc);

        // Añadir componentes para Hilo 2
        gbc.gridy = 3;
        gbc.gridx = 0;
        add(new JLabel("HILO 2"), gbc);

        gbc.gridx = 1;
        add(deslizador2, gbc);

        gbc.gridy = 4;
        add(barraProgreso2, gbc);

        // Añadir componentes para Hilo 3
        gbc.gridy = 5;
        gbc.gridx = 0;
        add(new JLabel("HILO 3"), gbc);

        gbc.gridx = 1;
        add(deslizador3, gbc);

        gbc.gridy = 6;
        add(barraProgreso3, gbc);

        // Añadir la etiqueta para mostrar el ganador
        gbc.gridy = 7;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        add(etiquetaGanador, gbc);

        // Configurar el tamaño del applet
        setSize(400, 300); // Tamaño del Applet
    }

    // Metodo para iniciar la carrera
    private void iniciarCarrera() {
        // Reiniciar el estado de las barras de progreso y la variable de carrera terminada
        carreraTerminada.set(false);
        barraProgreso1.setValue(0);
        barraProgreso2.setValue(0);
        barraProgreso3.setValue(0);
        etiquetaGanador.setText("Ganador: "); // Reiniciar el texto de la etiqueta del ganador

        // Crear e iniciar los hilos con las prioridades establecidas en los deslizadores
        hilo1 = crearHilo("HILO 1", barraProgreso1, deslizador1.getValue());
        hilo2 = crearHilo("HILO 2", barraProgreso2, deslizador2.getValue());
        hilo3 = crearHilo("HILO 3", barraProgreso3, deslizador3.getValue());

        // Iniciar los hilos
        hilo1.start();
        hilo2.start();
        hilo3.start();
    }

    // Metodo para crear cada hilo con su barra de progreso y prioridad
    private Thread crearHilo(String nombre, JProgressBar barraProgreso, int prioridad) {
        Thread hilo = new Thread(() -> {
            // Ejecutar el hilo hasta que la barra de progreso llegue a 100 o la carrera esté terminada
            while (barraProgreso.getValue() < 100 && !carreraTerminada.get()) {
                // Incrementar la barra de progreso
                barraProgreso.setValue(barraProgreso.getValue() + 1);
                try {
                    // Dormir el hilo para simular la velocidad basada en la prioridad
                    Thread.sleep(110 - prioridad * 10); // Mayor prioridad (10) -> menor tiempo de espera
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Verificar si este hilo ha ganado
            if (barraProgreso.getValue() >= 100 && carreraTerminada.compareAndSet(false, true)) {
                etiquetaGanador.setText("Ganador: " + nombre); // Actualizar la etiqueta del ganador
            }
        });

        // Establecer la prioridad del hilo
        hilo.setPriority(prioridad);
        return hilo;
    }
}
