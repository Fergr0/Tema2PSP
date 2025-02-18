package org.example.Examen;

public class Persona extends Thread{

    private Gestionar cuenta;
    private String nombre;

    public Persona(String nombre, Gestionar cuenta) {
        this.nombre = nombre;
        this.cuenta = cuenta;
    }

    @Override
    public void run() {//en este metodo se ejecuta el hilo haciendo las operaciones que pide el ejercicio
        System.out.println("Saldo inicial antes de sus operaciones" + cuenta.getSaldo_actual());
        System.out.println("Soy " + nombre);
        cuenta.ingresarSaldo(Aleatorio());
        System.out.println("Soy " + nombre);
        cuenta.reintegro(Aleatorio());
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Soy " + nombre);
        cuenta.ingresarSaldo(Aleatorio());
        System.out.println("Soy " + nombre);
        cuenta.reintegro(Aleatorio());
        System.out.println("Restante en la cuenta" + cuenta.getSaldo_actual());
    }

    public int Aleatorio(){//Metodo que genera un aleatorio para hacer ingreo o retiradam como pide el enunciado
       int aleatorio = (int) (Math.random() * 500+1);
       return aleatorio;
    }

}
