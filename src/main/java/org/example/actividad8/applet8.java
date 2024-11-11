package org.example.actividad8;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class applet8 extends Frame implements ActionListener {

    // Variables de control y componentes
    private MyHilo hilo1, hilo2; // Hilos para los contadores
    private Button comenzar, finalizar, btnReanuda1, btnReanuda2, btnSuspende1, btnSuspende2;
    private TextField tf1, tf2; // Campos de texto para mostrar contadores
    private Label hilo1Label, hilo2Label;

    public applet8() {
        // Configuración de la ventana
        setTitle("Applet Contador");
        setSize(400, 300);
        setLayout(new BorderLayout());
        setBackground(Color.pink);

        // Crear los botones y configurar las acciones
        comenzar = new Button("Comenzar Proceso");
        comenzar.addActionListener(this);

        finalizar = new Button("Finalizar Proceso");
        finalizar.addActionListener(this);

        btnReanuda1 = new Button("Reanudar 1");
        btnReanuda1.addActionListener(this);

        btnReanuda2 = new Button("Reanudar 2");
        btnReanuda2.addActionListener(this);

        btnSuspende1 = new Button("Suspender 1");
        btnSuspende1.addActionListener(this);

        btnSuspende2 = new Button("Suspender 2");
        btnSuspende2.addActionListener(this);

        // Panel superior para botones
        Panel panelSuperior = new Panel();
        panelSuperior.setLayout(new GridLayout(3, 1));

        // Sub-panel para el botón "Comenzar Proceso"
        Panel panelComenzar = new Panel(new FlowLayout(FlowLayout.CENTER));
        panelComenzar.add(comenzar);
        panelSuperior.add(panelComenzar);

        // Sub-panel para botones de reanudar
        Panel panelReanudar = new Panel(new FlowLayout(FlowLayout.CENTER, 20, 5));
        panelReanudar.add(btnReanuda1);
        panelReanudar.add(btnReanuda2);
        panelSuperior.add(panelReanudar);

        // Sub-panel para botones de suspender
        Panel panelSuspender = new Panel(new FlowLayout(FlowLayout.CENTER, 20, 5));
        panelSuspender.add(btnSuspende1);
        panelSuspender.add(btnSuspende2);
        panelSuperior.add(panelSuspender);

        add(panelSuperior, BorderLayout.NORTH);

        // Panel para TextField y etiquetas
        Panel panelInputs = new Panel();
        panelInputs.setLayout(new GridLayout(1, 2)); // Dos columnas

        // Panel izquierdo para Hilo 1
        Panel panelHilo1 = new Panel();
        panelHilo1.setLayout(new BorderLayout());
        hilo1Label = new Label("Hilo 1");
        tf1 = new TextField();
        panelHilo1.add(hilo1Label, BorderLayout.NORTH);
        panelHilo1.add(tf1, BorderLayout.SOUTH);

        // Panel derecho para Hilo 2
        Panel panelHilo2 = new Panel();
        panelHilo2.setLayout(new BorderLayout());
        hilo2Label = new Label("Hilo 2");
        tf2 = new TextField();
        panelHilo2.add(hilo2Label, BorderLayout.NORTH);
        panelHilo2.add(tf2, BorderLayout.SOUTH);

        // Añadir los paneles de Hilo 1 y Hilo 2 al panel de entradas
        panelInputs.add(panelHilo1);
        panelInputs.add(panelHilo2);

        add(panelInputs, BorderLayout.CENTER);

        // Panel inferior para el botón de finalizar
        Panel panelInferior = new Panel();
        panelInferior.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelInferior.add(finalizar);
        add(panelInferior, BorderLayout.SOUTH);

        // Configurar la ventana para cerrarse correctamente
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                stop(); // Detener los hilos al cerrar la ventana
                dispose(); // Cerrar la ventana
            }
        });

        setVisible(true); // Hacer visible la ventana
    }

    // Manejar botones
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == comenzar) {
            if (hilo1 == null || !hilo1.isAlive()) {
                // Crear e iniciar los hilos, uno para cada TextField
                hilo1 = new MyHilo(tf1); // Pasa el TextField al hilo
                hilo1.start(); // Iniciar el hilo 1

                hilo2 = new MyHilo(tf2); // Pasa el TextField al hilo
                hilo2.start(); // Iniciar el hilo 2
            }
        } else if (e.getSource() == finalizar) {
            stop(); // Llama al metodo stop para detener ambos hilos
        } else if (e.getSource() == btnSuspende1) {
            if (hilo1 != null) hilo1.suspende(); // Suspender hilo 1
        } else if (e.getSource() == btnSuspende2) {
            if (hilo2 != null) hilo2.suspende(); // Suspender hilo 2
        } else if (e.getSource() == btnReanuda1) {
            if (hilo1 != null) hilo1.reanuda(); // Reanudar hilo 1
        } else if (e.getSource() == btnReanuda2) {
            if (hilo2 != null) hilo2.reanuda(); // Reanudar hilo 2
        }
    }

    // metodo para detener los hilos
    public void stop() {
        if (hilo1 != null) {
            hilo1.detener();
            hilo1 = null; // Limpiar referencia
        }
        if (hilo2 != null) {
            hilo2.detener();
            hilo2 = null; // Limpiar referencia
        }
    }

    public static void main(String[] args) {
        new applet8(); // Crear y mostrar la ventana
    }
}
