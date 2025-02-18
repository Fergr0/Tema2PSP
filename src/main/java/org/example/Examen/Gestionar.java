package org.example.Examen;

public class Gestionar {

    private double saldo_actual; //saldo actual de la cuenta
    private double inicial; //saldo con el que parte la cuenta
    private double maximo; //saldo maximo para la cuenta

    public Gestionar(double inicial, double maximo) {//constructor que pide el ejercicio
        this.saldo_actual = inicial;
        this.inicial = inicial;
        this.maximo = maximo;
    }

    public boolean ingresarSaldo(double cantidad) {//Metodo que se encarga de los ingresos
        System.out.println("Se van a ingresar: " + cantidad);
        if((saldo_actual+cantidad) > maximo) {//control de superar o no la cantidad maxima
            System.out.println("No se puede realizar el ingreso, cantidad superada");
            return false;
        }
        saldo_actual = saldo_actual + cantidad;
        System.out.println("Ingreso correcto.");
        return true;
    }

    public boolean reintegro(double reintegro) {
        System.out.println("Se van a retirar: " + reintegro);
        if((saldo_actual - reintegro) < 0) {//control de no valores negativos
            System.out.println("No se puede realizar el retiro, cantidad superada");
            return false;
        }
        saldo_actual = saldo_actual - reintegro;
        System.out.println("Reintegro correcto.");
        return true;
    }

    public double getSaldo_actual() {
        return saldo_actual;
    }

    public void setSaldo_actual(double saldo_actual) {
        this.saldo_actual = saldo_actual;
    }

    public double getInicial() {
        return inicial;
    }

    public void setInicial(double inicial) {
        this.inicial = inicial;
    }

    public double getMaximo() {
        return maximo;
    }

    public void setMaximo(double maximo) {
        this.maximo = maximo;
    }

    @Override
    public String toString() {
        return "Gestionar{" +
                "saldo_actual=" + saldo_actual +
                ", inicial=" + inicial +
                ", maximo=" + maximo +
                '}';
    }
}
