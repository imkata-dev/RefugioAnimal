package app;

import model.*;
import service.RefugioService;
import util.InputUtil;

public class Main {
    public static void main(String[] args) {
        RefugioService refugio = new RefugioService();
        int opcion = -1;

        System.out.println("🐾 ¡Bienvenido al Sistema de Gestión del Refugio Animal!");

        while (opcion != 7) {
            System.out.println("--- 🖥️ MENÚ PRINCIPAL ---");
            System.out.println("1). Registrar un Perro");
            System.out.println("2.) Registrar un Gato");
            System.out.println("3.) Registrar un Cliente");
            System.out.println("4.) Listar todas las Mascotas");
            System.out.println("5.) Listar todos los Clientes");
            System.out.println("6.) Adoptar Mascota (Asociar)");
            System.out.println("7.) Salir del Sistema");

            opcion = InputUtil.leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1 -> {
                    String id = InputUtil.leerTexto("Ingrese ID del perro: ");
                    String nombre = InputUtil.leerTexto("Ingrese el nombre: ");
                    int edad = InputUtil.leerEntero("Ingrese la edad: ");
                    String raza = InputUtil.leerTexto("Ingrese su raza: ");

                    refugio.registrarMascota(new Perro(id, nombre, edad, raza));
                }
                case 2 -> {
                    String id = InputUtil.leerTexto("Ingrese ID del gato: ");
                    String nombre = InputUtil.leerTexto("Ingrese Nombre: ");
                    int edad = InputUtil.leerEntero("Ingrese Edad: ");
                    boolean esIndoor = InputUtil.leerBooleano("¿Es un gato de interiores (Indoor)?");

                    refugio.registrarMascota(new Gato(id, nombre, edad, esIndoor));
                }
                case 3 -> {
                    String rut = InputUtil.leerTexto("Ingrese RUT del cliente: ");
                    String nombre = InputUtil.leerTexto("Ingrese Nombre completo: ");
                    String telefono = InputUtil.leerTexto("Ingrese Teléfono de contacto: ");

                    refugio.registrarCliente(new Cliente(rut, nombre, telefono));
                }
                case 4 -> refugio.listarMascota();
                case 5 -> refugio.listarClientes();
                case 6 -> {
                    System.out.println("\n---PROCESO DE ADOPCIÓN ---");
                    String rut = InputUtil.leerTexto("Ingrese RUT del Cliente: ");
                    String idMascota = InputUtil.leerTexto("Ingrese ID de la Mascota a adoptar: ");

                    refugio.asociarMascotaCliente(rut, idMascota);
                }
                case 7 -> System.out.println("\nCerrando sistema... ¡Muchas gracias por cuidar a los animales! 🐾");
                default -> System.out.println("Opción no válida. Por favor, intente una opción del 1 al 7.");
            }
        }

        InputUtil.cerrarScanner();
        System.out.println("Sistema apagado correctamente.");
    }
}