import java.util.concurrent.locks.ReentrantLock;

public class RecursoMedico {
    private String nombreRecurso;
    private ReentrantLock bloqueoAcceso = new ReentrantLock();

    public RecursoMedico(String nombreRecurso) {
        this.nombreRecurso = nombreRecurso;
    }

    public void usar(String nombreProfesional) {
        bloqueoAcceso.lock();
        try {
            System.out.println(nombreProfesional + " ha ingresado a " + nombreRecurso);
            Thread.sleep(1000); // Simula uso del recurso
            System.out.println(nombreProfesional + " ha salido de " + nombreRecurso);
        } catch (InterruptedException excepcionInterrupcion) {
            Thread.currentThread().interrupt();
        } finally {
            bloqueoAcceso.unlock();
        }
    }
}
