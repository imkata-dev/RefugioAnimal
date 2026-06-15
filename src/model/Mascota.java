package model;
import interfaces.Adoptable;

public abstract class Mascota implements Adoptable{
    protected String id;
    protected String nombre;
    protected int edad;
    protected boolean esAdoptado;

    public Mascota(String id, String nombre, int edad){
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.esAdoptado = false;
    }

    @Override
    public void cambiarEstadoAdopcion(boolean estado) {
        this.esAdoptado = estado;
    }

    @Override
    public void mostrarDetallesAdopcion() {
        System.out.println("Mascota: " + nombre + " | Estado: " + (esAdoptado ? "Adoptado" : "Disponible para adopción"));
    }

    public abstract void hacerSonido();

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public boolean isAdoptado() {
        return esAdoptado;
    }
}
