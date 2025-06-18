/*
En una pizzería, algunos clientes han realizado pedidos para entrega a domicilio, pero no todos han dejado su número de teléfono para la confirmación.
El sistema debe:
Filtrar solo los pedidos que sean para entrega a domicilio.
Recuperar y utilizar solo los números de teléfono disponibles (sin null).
Transformar cada número en un mensaje de confirmación.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConfirmacionPedidos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Pedidos> pedidos = new ArrayList<>();

        System.out.print("¿Cuántos pedidos desea ingresar? ");
        int cantidad = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= cantidad; i++) {
            System.out.println("📃Pedido #" + i);
            System.out.print("😎Nombre del cliente: ");
            String cliente = scanner.nextLine();

            System.out.print("📍Tipo de entrega (domicilio/local): ");
            String tipo = scanner.nextLine();

            System.out.print("📞Teléfono (Enter si no proporcionó): ");
            String telefono = scanner.nextLine();
            if (telefono.isBlank()) {
                telefono = null;
            }

            pedidos.add(new Pedidos(cliente, tipo, telefono));
        }

        List<String> mensajes = pedidos.stream()
                .filter(p -> p.getTipoEntrega().equalsIgnoreCase("domicilio"))
                .map(Pedidos::getTelefono)
                .flatMap(Optional::stream)
                .map(tel -> "📞Confirmación enviada al número: " + tel)
                .collect(Collectors.toList());

        mensajes.forEach(System.out::println);

    }
}