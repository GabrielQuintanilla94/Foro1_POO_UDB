import java.util.ArrayList;
import java.util.Scanner;

public class AlumnoUDBVirtual {

    private class Alumno {
        private String carnet;
        private String nombreCompleto;

        public Alumno(String carnet, String nombreCompleto) {
            this.carnet = carnet;
            this.nombreCompleto = nombreCompleto;
        }

        public String getCarnet() {
            return carnet;
        }

        @Override
        public String toString() {
            return "Carnet: " + carnet + ", Nombre: " + nombreCompleto;
        }
    }

    // Instance variables instead of static variables
    private ArrayList<Alumno> alumnos = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // Main method is now used to create an instance and call a method
    public static void main(String[] args) {
        AlumnoUDBVirtual app = new AlumnoUDBVirtual();
        app.run();
    }

    // Non-static method to encapsulate the application's logic
    public void run() {
        int opcion;

        do {
            System.out.println("\nMenú de Opciones:");
            System.out.println("1. Ingresar alumno");
            System.out.println("2. Buscar alumno");
            System.out.println("3. Eliminar alumno");
            System.out.println("4. Mostrar todos los alumnos");
            System.out.println("5. Salir");
            System.out.println("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    ingresarAlumno();
                    break;
                case 2:
                    buscarAlumno();
                    break;
                case 3:
                    eliminarAlumno();
                    break;
                case 4:
                    mostrarTodosLosAlumnos();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente nuevamente.");
            }
        } while (opcion != 5);
    }

    private void ingresarAlumno() {
        System.out.println("Ingrese el carnet del alumno: ");
        String carnet = scanner.nextLine();
        System.out.println("Ingrese el nombre completo del alumno: ");
        String nombreCompleto = scanner.nextLine();

        Alumno nuevoAlumno = new Alumno(carnet, nombreCompleto);
        alumnos.add(nuevoAlumno);

        System.out.println("Alumno ingresado exitosamente.");
    }

    private void buscarAlumno() {
        System.out.println("Ingrese el carnet del alumno a buscar: ");
        String carnet = scanner.nextLine();

        for (Alumno alumno : alumnos) {
            if (alumno.getCarnet().equals(carnet)) {
                System.out.println("Alumno encontrado: " + alumno);
                return;
            }
        }
        System.out.println("Alumno no encontrado.");
    }

    private void eliminarAlumno() {
        System.out.println("Ingrese el carnet del alumno a eliminar: ");
        String carnet = scanner.nextLine();

        for (Alumno alumno : alumnos) {
            if (alumno.getCarnet().equals(carnet)) {
                alumnos.remove(alumno);
                System.out.println("Alumno eliminado exitosamente.");
                return;
            }
        }
        System.out.println("Alumno no encontrado, no se puede eliminar.");
    }

    private void mostrarTodosLosAlumnos() {
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
        } else {
            System.out.println("Listado de alumnos:");
            for (Alumno alumno : alumnos) {
                System.out.println(alumno);
            }
        }
    }
}
