package org.example.Examen;

public class Main {

    /*El ejercicio pide crear 3 clases, una que es Gestionar, que cumplira la funcion de una cuenta de banco,
    * la clase Persona que simula un usuario de una cuenta y el main, esta clase que se encarga de asignar una cuenta a
    * dos personas para que hagan  operaciones entre si
    * Primero se ejecutan las operaciones de un hilo y despues las de otro
    * En el metodo run de la clase persono añadi algunos Systemout para verificar que acceden al mismo objeto en memoria
    * a pesar de ser dos hilos diferentes*/

    public static void main(String[] args) {
        Gestionar comun = new Gestionar(200, 600);
        Persona persona = new Persona("Juan", comun);
        Persona persona2 = new Persona("Pepe", comun);

        try {
            persona.run();
            persona2.run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
