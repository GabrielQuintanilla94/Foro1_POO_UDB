import java.util.Collection;//DEFINIR
import java.util.ArrayList;
import java.util.Scanner;

class Fruta {
    private String nombre;
    private String color;

    public Fruta(String nombre, String color) {
        this.nombre = nombre;
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Color: " + color;
    }
}

public class GestionFrutas {
    private static Collection<Fruta> frutas = new ArrayList<>();//DECLARAMOS
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Ingresar fruta");
            System.out.println("2. Buscar fruta");
            System.out.println("3. Eliminar fruta");
            System.out.println("4. Mostrar todas las frutas");
            System.out.println("5. Salir");
            System.out.println("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    ingresarFruta();
                    break;
                case 2:
                    buscarFruta();
                    break;
                case 3:
                    eliminarFruta();
                    break;
                case 4:
                    mostrarFrutas();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion no válida. Intente de nuevo.");
            }
        } while (opcion != 5);
    }
//ASIGNAR
    private static void ingresarFruta() {
        System.out.println("Ingrese el nombre de la fruta: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el SKU de la fruta: ");
        String color = scanner.nextLine();

        Fruta nuevaFruta = new Fruta(nombre, color);
        frutas.add(nuevaFruta);
        System.out.println("Fruta ingresada exitosamente.");
    }

    private static void buscarFruta() {
        System.out.println("Ingrese el nombre de la fruta a buscar: ");
        String nombre = scanner.nextLine();

        for (Fruta fruta : frutas) {
            if (fruta.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Fruta encontrada: " + fruta);
                return;
            }
        }
        System.out.println("Fruta no encontrada.");
    }
//REMOVE
    private static void eliminarFruta() {
        System.out.println("Ingrese el nombre de la fruta a eliminar: ");
        String nombre = scanner.nextLine();

        for (Fruta fruta : frutas) {
            if (fruta.getNombre().equalsIgnoreCase(nombre)) {
                frutas.remove(fruta);
                System.out.println("Fruta eliminada exitosamente.");
                return;
            }
        }
        System.out.println("Fruta no encontrada, no se puede eliminar.");
    }

    private static void mostrarFrutas() {
        if (frutas.isEmpty()) {
            System.out.println("No hay frutas registradas.");
        } else {
            System.out.println("Lista de frutas:");
            for (Fruta fruta : frutas) {
                System.out.println(fruta);
            }
        }
    }
}