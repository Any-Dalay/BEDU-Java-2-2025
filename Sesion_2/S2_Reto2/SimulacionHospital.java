import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimulacionHospital {
    public static void main(String[] args) {
        Scanner lectorEntrada = new Scanner(System.in);
        RecursoMedico salaCirugia = new RecursoMedico("Sala de cirugía");

        System.out.print("¿Cuántos profesionales participarán en la simulación? ");
        int totalProfesionales = Integer.parseInt(lectorEntrada.nextLine());

        List<String> listaNombresProfesionales = new ArrayList<>();
        for (int indice = 0; indice < totalProfesionales; indice++) {
            System.out.print("Ingresa el nombre del profesional #" + (indice + 1) + " (ej: Dra. Sánchez): ");
            listaNombresProfesionales.add(lectorEntrada.nextLine());
        }

        ExecutorService executor = Executors.newFixedThreadPool(4); // (esta línea se mantiene igual)

        System.out.println("Iniciando acceso a la Sala de cirugía...");

        for (String nombreProfesional : listaNombresProfesionales) {
            Runnable tareaAcceso = () -> salaCirugia.usar(nombreProfesional);
            executor.execute(tareaAcceso);
        }

        executor.shutdown();
    }
}
