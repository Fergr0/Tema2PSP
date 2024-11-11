package org.example.actividad2_6;

public class EjemploHiloPrioridad1 {
    public static void main(String[] args) {
        HiloPrioridad h1 = new HiloPrioridad("Hilo1");
        HiloPrioridad h2 = new HiloPrioridad("Hilo2");
        HiloPrioridad h3 = new HiloPrioridad("Hilo3");

        h1.setPriority(Thread.NORM_PRIORITY);
        h2.setPriority(Thread.MAX_PRIORITY);
        h3.setPriority(Thread.MIN_PRIORITY);

        h1.start();
        h2.start();
        h3.start();

        try{
            Thread.sleep(5000);
        }catch (Exception e){}

        h1.pararHilo();
        h2.pararHilo();
        h3.pararHilo();

        System.out.println("h2 (Prioridad máxima):" + h2.getContador());
        System.out.println("h1 (Prioridad normal):" + h1.getContador());
        System.out.println("h3 (Prioridad mínima):" + h3.getContador());

    }
}


