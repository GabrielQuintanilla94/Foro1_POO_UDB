import java.util.ArrayList;
import java.util.List;//Definicion
import java.util.Scanner;

// Clase Bebida
class Bebida {
    private String nombre;
    private String tipo;

    public Bebida(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Tipo: " + tipo;
    }
}

// Clase principal para la gestión de bebidas
public class GestionBebidas {
    private static List<Bebida> bebidas = new ArrayList<>();//Declaracion
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Ingresar bebida");
            System.out.println("2. Buscar bebida");
            System.out.println("3. Eliminar bebida");
            System.out.println("4. Mostrar todas las bebidas");
            System.out.println("5. Salir");
            System.out.println("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la línea vacía

            switch (opcion) {
                case 1:
                    ingresarBebida();
                    break;
                case 2:
                    buscarBebida();
                    break;
                case 3:
                    eliminarBebida();
                    break;
                case 4:
                    mostrarBebidas();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);
    }

    // Método para ingresar una nueva bebida
    private static void ingresarBebida() {
        System.out.println("Ingrese el nombre de la bebida: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el tipo de bebida (e.g., refresco, jugo, etc.): ");
        String tipo = scanner.nextLine();

        Bebida nuevaBebida = new Bebida(nombre, tipo);
        bebidas.add(nuevaBebida);
        System.out.println("Bebida ingresada exitosamente.");
    }

    // Método para buscar una bebida por nombre
    private static void buscarBebida() {
        System.out.println("Ingrese el nombre de la bebida a buscar: ");
        String nombre = scanner.nextLine();

        for (Bebida bebida : bebidas) {
            if (bebida.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Bebida encontrada: " + bebida);
                return;
            }
        }
        System.out.println("Bebida no encontrada.");
    }

    // Método para eliminar una bebida por nombre
    private static void eliminarBebida() {
        System.out.println("Ingrese el nombre de la bebida a eliminar: ");
        String nombre = scanner.nextLine();

        for (Bebida bebida : bebidas) {
            if (bebida.getNombre().equalsIgnoreCase(nombre)) {
                bebidas.remove(bebida);//remove
                System.out.println("Bebida eliminada exitosamente.");
                return;
            }
        }
        System.out.println("Bebida no encontrada, no se puede eliminar.");
    }

    // Método para mostrar todas las bebidas
    private static void mostrarBebidas() {
        if (bebidas.isEmpty()) {
            System.out.println("No hay bebidas registradas.");
        } else {
            System.out.println("Lista de bebidas:");
            for (Bebida bebida : bebidas) {
                System.out.println(bebida);
            }
        }
    }
}
