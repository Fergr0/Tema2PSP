package org.example.actividad2_4;

public class SolicitaSuspender {

    private boolean suspender;

    public synchronized void set(boolean b) {
        suspender = b; //cambio de estado sobre el objeto
        notifyAll();
    }

    public synchronized void esperandoParaReanudar() throws InterruptedException {
        while (suspender) {
            wait(); //suspender hilo hasta recibir el notifyAll()
        }
    }


}
