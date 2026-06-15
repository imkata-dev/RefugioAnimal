package service;

import model.Cliente;
import model.Mascota;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RefugioService {
    private List<Mascota> inventarioMascota;
    private Map<String, Cliente> registroCliente;

    public RefugioService(){
        this.inventarioMascota = new ArrayList<>();
        this.registroCliente = new HashMap<>();
    }

    public void registrarMascota(Mascota mascota){
        inventarioMascota.add(mascota);
        System.out.println("¡Genial!, " + mascota.getNombre() + " ha sido ingresada con éxito al refugio.");
    }

    public void listarMascota(){
        if (inventarioMascota.isEmpty()){
            System.out.println("Actualmente no hay mascotas ingresadas al refugio.");
            return;
        }
        System.out.println("----INVENTARIO TOTAL DEL REFUGIO----");
        for (Mascota m : inventarioMascota){
            m.mostrarDetallesAdopcion();
        }
    }

    public void conciertoAnimal(){
        if (inventarioMascota.isEmpty()){
            System.out.println("El refugio está tranquilo, no hay animales cerca...");
            return;
        }

        System.out.println("¡Los animales han llegado!, ¡el show ha empezado!");
        for (Mascota m : inventarioMascota){
            m.hacerSonido();
        }
    }

    public void registrarCliente(Cliente cliente) {
        if (registroCliente.containsKey(cliente.getRut())){
            System.out.println("Ya hay un cliente registrado con el RUT: " + cliente.getRut());
            return;
        }
        registroCliente.put(cliente.getRut(), cliente);
        System.out.println("El cliente " + cliente.getNombre() + " ha sido registrado correctamente.");
    }

    public void listarClientes(){
        if (registroCliente.isEmpty()){
            System.out.println("No hay clientes registrados en el sistema.");
            return;
        }
        System.out.println("----REGISTRO TOTAL DE CLIENTES----");
        for (Cliente c : registroCliente.values()) {
            System.out.println("RUT: " + c.getRut() + " | Nombre: " + c.getNombre() + " | Teléfono: " + c.getTelefono());
            c.mostrarMascotas();
        }
    }

    public void asociarMascotaCliente(String rutCliente, String idMascota){

        Cliente cliente = registroCliente.get(rutCliente);
        if (cliente == null) {
            System.out.println("Lo sentimos, no se encontró ningún cliente con el RUT ingresado.");
            return;
        }

        Mascota mascotaEncontrada = null;
        for (Mascota m : inventarioMascota) {
            if (m.getId().equalsIgnoreCase(idMascota)) {
                mascotaEncontrada = m;
                break;
            }
        }

        // 3. Validar mascota y asociar
        if (mascotaEncontrada == null) {
            System.out.println("Lo sentimos, no se encontró ninguna mascota con el ID ingresado.");
            return;
        }

        if (mascotaEncontrada.isAdoptado()) {
            System.out.println("Esta mascota ya fue adoptada por otra persona.");
            return;
        }


        mascotaEncontrada.cambiarEstadoAdopcion(true);
        cliente.agregarMascota(mascotaEncontrada);
        System.out.println("¡Felicidades! " + cliente.getNombre() + " ha adoptado a " + mascotaEncontrada.getNombre() + ".");
    }


}