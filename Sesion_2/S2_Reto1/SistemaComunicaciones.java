import java.util.concurrent.Callable;

public class SistemaComunicaciones implements Callable<String> {
    private int duracionConexionMilisegundos;

    public SistemaComunicaciones(int duracionConexionMilisegundos) {
        this.duracionConexionMilisegundos = duracionConexionMilisegundos;
    }

    @Override
    public String call() throws Exception {
        // Simula el tiempo de espera para establecer la conexión
        Thread.sleep(duracionConexionMilisegundos);
        return "Sistema de Comunicaciones: enlace establecido tras " + duracionConexionMilisegundos + " ms.";
    }
}
