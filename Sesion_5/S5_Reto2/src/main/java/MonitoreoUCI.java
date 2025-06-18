/*
En una UCI moderna, los sensores de pacientes generan constantemente datos como:
Frecuencia cardíaca (FC)
Presión arterial (PA)
Nivel de oxígeno (SpO2)
Estos datos se generan rápidamente, pero el sistema médico no puede procesar todo al mismo ritmo. Debes construir un flujo reactivo que:

Filtre valores críticos (ej. FC muy alta/baja, PA fuera de rango, SpO2 bajo).
Aplique backpressure para controlar la velocidad de procesamiento, evitando saturar al personal médico.
Muestre alertas en consola sólo para eventos críticos.
 */
import reactor.core.publisher.Flux;
import java.time.Duration;
import java.util.Random;

public class MonitoreoUCI {

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();

        // Flujo de signos vitales para 3 pacientes
        Flux<SignosVitales> paciente1 = generarSignosVitales(1, random);
        Flux<SignosVitales> paciente2 = generarSignosVitales(2, random);
        Flux<SignosVitales> paciente3 = generarSignosVitales(3, random);

        // Fusión de los flujos y procesamiento con priorización
        Flux.merge(paciente1, paciente2, paciente3)
                .filter(SignosVitales::esCritico) // 🔍 Filtrar solo eventos críticos
                .sort((e1, e2) -> e1.prioridad() - e2.prioridad()) // Priorizar FC sobre otros eventos
                .delayElements(Duration.ofSeconds(1)) // Backpressure
                .subscribe(System.out::println);

        Thread.sleep(15000); // Mantener el sistema corriendo 15 segundos
    }

    // Simula signos vitales de un paciente
    private static Flux<SignosVitales> generarSignosVitales(int pacienteId, Random random) {
        return Flux.interval(Duration.ofMillis(300))
                .map(tick -> {
                    int fc = 40 + random.nextInt(100);     // 40-140 bpm
                    int pas = 80 + random.nextInt(80);     // 80-160 sistólica
                    int pad = 50 + random.nextInt(50);     // 50-100 diastólica
                    int spo2 = 85 + random.nextInt(15);    // 85-100%
                    return new SignosVitales(pacienteId, fc, pas, pad, spo2);
                })
                .take(10); // Limitar cantidad de eventos por paciente

    }

}
