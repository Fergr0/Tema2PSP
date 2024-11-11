package org.example.actividad2_3;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class applet2_3 extends Applet implements ActionListener {

    //creo el hilo
    class HiloContador extends Thread{
        private boolean parar;

        public void parar(boolean parar){
            this.parar = parar;
        }
        //este metodo va incrementando el contador
        public void run(){
            parar = false;
            Thread hiloActual = new Thread();
            while (!parar){
                try {
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                repaint();
                contador+=1;
            }
        }
    }

    //creo un hilo de tipo HiloContador
    private HiloContador h;
    long contador = 0;

    private Font fuente;
    private Button b1, b2;

    public void start(){}

    //declaro como sera la interfaz
    public void init(){
        setBackground(Color.pink);
        add(b1 = new Button("Iniciar Contador"));
        b1.addActionListener(this);
        add(b2 = new Button("Parar Contador"));
        b2.addActionListener(this);
        fuente = new Font("Verdana", Font.BOLD, 26);
    }

    //cuando se pulsan botones
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1){
            b1.setLabel("Continuar");
            if (h != null && h.isAlive()){}
            else{//si no se inició mi hilo, empieza
                h = new HiloContador();
                h.start();
            }
        }else if(e.getSource() == b2)//si se puls parar
//            stop();
            h.parar(true);
    }


    //pintar la interfaz
    public void paint(Graphics g){
        g.clearRect(0,0,400, 400);
        g.setFont(fuente);
        g.drawString(Long.toString(contador), 80, 100);
    }

    @Override
    public void stop() {
//        if (h != null) { // Verifica si h no es null
//            h.parar(true); // Detiene el hilo
//            h = null; // Limpia la referencia
//        }
    }
}
