package model;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona {
    private List<Mascota> mascotasAdoptadas;

    public Cliente(String rut, String nombre, String telefono) {
        super(rut, nombre, telefono);
        this.mascotasAdoptadas = new ArrayList<>();
    }

    public void mostrarMascotas(){
        if(mascotasAdoptadas.isEmpty()){
            System.out.println("El cliente " + nombre + "aun no ha adoptado ninguna mascota.");
        }

        System.out.println("🐾 Mascotas adoptadas por " + nombre + ":");
        for (Mascota m : mascotasAdoptadas) {
            System.out.println("   - [" + m.getId() + "] " + m.getNombre() + " (" + m.getClass().getSimpleName() + ")");
        }
    }

    public List<Mascota> getMascotasAdoptadas(){
        return mascotasAdoptadas;
    }


    public void agregarMascota(Mascota mascotaEncontrada) {
    }
}
