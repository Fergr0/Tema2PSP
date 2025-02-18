package org.example.actividad2_12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ejercicio5 extends JPanel implements Runnable {
    private Thread hilo;
    private int x = 1;  // Posición inicial de la letra en X
    private int y = 100; // Posición inicial de la letra en Y
    private int velocidad = 1; // Velocidad de movimiento de la letra
    private boolean moviendoDerecha = true; // Dirección del movimiento
    private JButton boton; // Botón para detener o reanudar el hilo
    private boolean hiloActivo = true; // Para controlar el estado del hilo
    
    public ejercicio5() {
        setPreferredSize(new Dimension(400, 200)); // Establecer tamaño del panel

        // Crear el botón para detener o reanudar el hilo
        boton = new JButton("Finalizar hilo");
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (hiloActivo) {
                    // Detener el hilo
                    hiloActivo = false;
                    boton.setText("Reanudar hilo");
                } else {
                    // Reanudar el hilo
                    hiloActivo = true;
                    synchronized (hilo) {
                        hilo.notify();
                    }
                    boton.setText("Finalizar hilo");
                }
            }
        });

        // Agregar el botón a la ventana
        setLayout(new BorderLayout());
        add(boton, BorderLayout.SOUTH);
    }

    public void start() {
        hilo = new Thread(this);
        hilo.start();
    }

    @Override
    public void run() {
        while (true) {
            if (hiloActivo) {
                // Mover la letra
                if (moviendoDerecha) {
                    x += velocidad; // Mover a la derecha
                    if (x >= getWidth() - 20) { // Rebote al llegar al borde derecho
                        moviendoDerecha = false;
                    }
                } else {
                    x -= velocidad; // Mover a la izquierda
                    if (x <= 1) { // Rebote al llegar al borde izquierdo
                        moviendoDerecha = true;
                    }
                }
                repaint(); // Actualizar la pantalla

                // Pausar brevemente
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                // Detener el hilo cuando se pausa
                synchronized (hilo) {
                    try {
                        hilo.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Arial", Font.BOLD, 50));
        g.setColor(Color.BLACK);
        g.drawString("A", x, y); // Dibujar la letra en la posición x, y
    }

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Letra Rebotando");
        ejercicio5 panel = new ejercicio5();
        ventana.add(panel);
        ventana.pack();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
        
        panel.start(); // Iniciar el hilo
    }
}
