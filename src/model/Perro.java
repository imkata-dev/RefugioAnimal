package model;

import interfaces.Entrenable;

public class Perro extends Mascota implements Entrenable {
    private String raza;

    public Perro(String id, String nombre, int edad, String raza) {
        super(id, nombre, edad);
        this.raza = raza;
    }

    @Override
    public void hacerSonido() {
        System.out.println("El perrito " + nombre + " dice: ¡Guau, guau!");
    }

    @Override
    public void realizarTruco() {
        System.out.println( nombre + " da la pata y se sienta de forma educada.");

    }
    public String getRaza() { return raza; }

}
