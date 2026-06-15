package model;

public class Gato extends Mascota{
    private final boolean esIndoor;

    public Gato(String id, String nombre, int edad, boolean esIndoor) {
        super(id, nombre, edad);
        this.esIndoor = esIndoor;
    }

    @Override
    public void hacerSonido() {
        System.out.println("🐾 " + nombre + " dice: ¡Miau, miau!");
    }

    public boolean isEsIndoor() { return esIndoor; }
}
