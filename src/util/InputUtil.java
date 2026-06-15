package util;

import java.util.Scanner;

public class InputUtil {
    private static final Scanner scanner = new Scanner(System.in);

    public static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine().trim();
    }

    public static int leerEntero(String mensaje){
        while (true){
            try{
                System.out.println(mensaje);
                return Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("----Entrada inválida. Por favor, ingrese un número entero válido.");
            }
        }
    }

    public static boolean leerBooleano(String mensaje){
        while (true){
            String entrada = leerTexto(mensaje + "SI/NO: ").toUpperCase();
            if (entrada.equals("Sí")) return true;
            if (entrada.equals("No")) return false;
            System.out.println("Opción inválida. Ingrese solo SI o NO");
        }
    }
    public static void cerrarScanner() {
        scanner.close();
    }

}
