/*
En una plataforma educativa online, los cursos están compuestos por diferentes tipos de materiales:
🎥 Videos
📄 Artículos
📝 Ejercicios
El sistema debe:
Mostrar todos los materiales disponibles de un curso.
Filtrar solo los videos para contar su duración total.
Actualizar los materiales de tipo ejercicio, marcándolos como revisados.
 */
import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<MaterialCurso> materiales = new ArrayList<>();
        List<Video> videos = new ArrayList<>();
        List<Ejercicio> ejercicios = new ArrayList<>();

        // Materiales iniciales
        videos.add(new Video("Introducción a Java", "Juan", 15));
        videos.add(new Video("POO en Java", "Carlos", 20));

        materiales.addAll(videos);
        materiales.add(new Articulo("Historia de Java", "Ana", 1200));
        materiales.add(new Articulo("Tipos de datos", "Luis", 800));

        Ejercicio ej1 = new Ejercicio("Variables y tipos", "Luis");
        Ejercicio ej2 = new Ejercicio("Condicionales", "Mario");

        ejercicios.add(ej1);
        ejercicios.add(ej2);
        materiales.addAll(ejercicios);

        boolean salir = false;

        while (!salir) {
            limpiarPantalla();
            System.out.println("📚 Materiales del Curso:");
            System.out.println("1. Mostrar todos los materiales");
            System.out.println("2. Contar duración total de videos");
            System.out.println("3. Marcar ejercicios como revisados");
            System.out.println("4. Filtrar materiales por autor");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    limpiarPantalla();
                    System.out.println("📋 Todos los materiales:");
                    PlataformaEducativa.mostrarMateriales(materiales);
                    pausar(scanner);
                    break;

                case 2:
                    limpiarPantalla();
                    PlataformaEducativa.contarDuracionVideos(videos);
                    pausar(scanner);
                    break;

                case 3:
                    limpiarPantalla();
                    PlataformaEducativa.marcarEjerciciosRevisados(materiales);
                    pausar(scanner);
                    break;

                case 4:
                    limpiarPantalla();
                    System.out.print("Ingrese el nombre del autor a filtrar: ");
                    String autor = scanner.nextLine();
                    Predicate<MaterialCurso> filtro = m -> m.autor.equalsIgnoreCase(autor);
                    PlataformaEducativa.filtrarPorAutor(materiales, filtro);
                    pausar(scanner);
                    break;

                case 5:
                    salir = true;
                    limpiarPantalla();
                    System.out.println("👋 Saliendo del sistema...");
                    break;

                default:
                    limpiarPantalla();
                    System.out.println("❌ Opción no válida.");
                    pausar(scanner);
            }
        }

        scanner.close();
    }

    public static void limpiarPantalla() {
        for (int i = 0; i < 50; i++) System.out.println();
    }

    public static void pausar(Scanner scanner) {
        System.out.println("\nPresiona ENTER para continuar...");
        scanner.nextLine();
    }
}