/**
 * Sistema de soporte vital que simula el monitoreo de oxígeno personalizado.
 */
import java.util.concurrent.Callable;

public class SistemaSoporteVital implements Callable<String> {
    private int oxigeno;

    public SistemaSoporteVital(int oxigeno) {
        this.oxigeno = oxigeno;
    }

    public String call() throws Exception {
        Thread.sleep(800);
        return "Soporte vital: oxígeno al " + oxigeno + "% dentro de parámetros normales.";
    }
}