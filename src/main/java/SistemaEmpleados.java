import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SistemaEmpleados {
    // Creamos un mapa para almacenar los empleados
    private static Map<String, String> empleados = new HashMap<>();//Declaracion

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n----- Sistema de Gestión de Empleados -----");
            System.out.println("1. Ingresar empleado");
            System.out.println("2. Buscar empleado");
            System.out.println("3. Eliminar empleado");
            System.out.println("4. Mostrar todos los empleados");
            System.out.println("5. Salir");
            System.out.println("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            switch (opcion) {
                case 1:
                    ingresarEmpleado(scanner);
                    break;
                case 2:
                    buscarEmpleado(scanner);
                    break;
                case 3:
                    eliminarEmpleado(scanner);
                    break;
                case 4:
                    mostrarTodosEmpleados();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);
    }

    // Método para ingresar un empleado
    private static void ingresarEmpleado(Scanner scanner) {//Asignacion de valores
        System.out.println("Ingrese el ID del empleado: ");
        String id = scanner.nextLine();

        System.out.println("Ingrese el nombre completo del empleado: ");
        String nombre = scanner.nextLine();

        empleados.put(id, nombre); // Insertamos en el mapa
        System.out.println("Empleado ingresado exitosamente.");
    }

    // Método para buscar un empleado
    private static void buscarEmpleado(Scanner scanner) {
        System.out.println("Ingrese el ID del empleado a buscar: ");
        String id = scanner.nextLine();

        // Verificamos si el ID está en el mapa
        if (empleados.containsKey(id)) {
            System.out.println("Empleado encontrado: " + empleados.get(id));
        } else {
            System.out.println("Empleado no encontrado, no se puede Mostrar.");
        }
    }

    // Método para eliminar un empleado
    private static void eliminarEmpleado(Scanner scanner) {
        System.out.println("Ingrese el ID del empleado a eliminar: ");
        String id = scanner.nextLine();

        // Verificamos si el ID está en el mapa
        if (empleados.containsKey(id)) {
            empleados.remove(id); // Eliminamos el empleado
            System.out.println("Empleado eliminado exitosamente.");
        } else {
            System.out.println("Empleado no encontrado, no se puede Eliminar.");
        }
    }

    // Método para mostrar todos los empleados
    private static void mostrarTodosEmpleados() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            System.out.println("Listado de todos los empleados:");
            for (Map.Entry<String, String> entry : empleados.entrySet()) {
                System.out.println("ID: " + entry.getKey() + ", Nombre: " + entry.getValue());
            }
        }
    }
}