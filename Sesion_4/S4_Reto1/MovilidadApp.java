import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class MovilidadApp {

    public CompletableFuture<String> calcularRuta(String lugarOrigen, String lugarDestino) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("🚦 Calculando ruta...");
                TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(2, 4));
                return "Ruta calculada: " + lugarOrigen + " → " + lugarDestino;
            } catch (InterruptedException errorInterrupcion) {
                throw new RuntimeException("Error al calcular la ruta");
            }
        });
    }

    public CompletableFuture<Double> estimarTarifa(double distanciaEnKm, double factorDemanda) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("💰 Estimando tarifa...");
                TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(1, 3));
                if (distanciaEnKm < 0) {
                    throw new IllegalArgumentException("Distancia inválida");
                }
                return 30.0 + distanciaEnKm * 5.0 * factorDemanda;
            } catch (InterruptedException errorInterrupcion) {
                throw new RuntimeException("Error al estimar la tarifa");
            }
        });
    }

    public void procesarSolicitud(String lugarOrigen, String lugarDestino, double distanciaEnKm, double factorDemanda) {
        CompletableFuture<String> futuroRuta = calcularRuta(lugarOrigen, lugarDestino);
        CompletableFuture<Double> futuroTarifa = estimarTarifa(distanciaEnKm, factorDemanda);

        futuroRuta
                .thenCombine(futuroTarifa, (rutaCalculada, tarifaEstimada) ->
                        "✅ 🚗 " + rutaCalculada + " | Tarifa estimada: $" + String.format("%.2f", tarifaEstimada)
                )
                .exceptionally(error -> "❌ Error en el proceso: " + error.getMessage())
                .thenAccept(System.out::println);
    }
}
