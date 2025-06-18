import java.util.concurrent.Callable;

public class SistemaControlTermico implements Callable<String> {
    private int temperaturaInternaGrados;

    public SistemaControlTermico(int temperaturaInternaGrados) {
        this.temperaturaInternaGrados = temperaturaInternaGrados;
    }

    @Override
    public String call() throws Exception {
        // Simula el tiempo de procesamiento del sistema térmico
        Thread.sleep(900);
        return "Sistema de Control Térmico: temperatura estabilizada en " + temperaturaInternaGrados + " °C.";
    }
}
