import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner lectorEntrada = new Scanner(System.in);
        MovilidadApp aplicacionMovilidad = new MovilidadApp();

        System.out.print("Ingrese el nombre del lugar de origen: ");
        String lugarOrigen = lectorEntrada.nextLine();

        System.out.print("Ingrese el nombre del lugar de destino: ");
        String lugarDestino = lectorEntrada.nextLine();

        System.out.print("Ingrese la distancia en km (ejemplo 7.5): ");
        double distanciaKilometros = Double.parseDouble(lectorEntrada.nextLine());

        System.out.print("Ingrese el factor de demanda (ejemplo 1.2): ");
        double factorDemanda = Double.parseDouble(lectorEntrada.nextLine());

        aplicacionMovilidad.procesarSolicitud(lugarOrigen, lugarDestino, distanciaKilometros, factorDemanda);

        Thread.sleep(6000); // Espera para permitir que finalicen procesos simulados
        lectorEntrada.close();
    }
}
