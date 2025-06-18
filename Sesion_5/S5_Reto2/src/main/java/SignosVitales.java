
// Representación de un evento de signos vitales
public class SignosVitales {
    private final int pacienteId;
    private final int fc, pas, pad, spo2;

    public SignosVitales(int pacienteId, int fc, int pas, int pad, int spo2) {
        this.pacienteId = pacienteId;
        this.fc = fc;
        this.pas = pas;
        this.pad = pad;
        this.spo2 = spo2;
    }

    public boolean esCritico() {
        return fc < 50 || fc > 120 || spo2 < 90 || pas < 90 || pas > 140 || pad < 60 || pad > 90;
    }

    // Asigna prioridad: 1 (FC), 2 (SpO2), 3 (PA)
    public int prioridad() {
        if (fc < 50 || fc > 120) return 1;
        if (spo2 < 90) return 2;
        return 3;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (fc < 50 || fc > 120) sb.append("⚠️ Paciente ").append(pacienteId).append(" - FC crítica: ").append(fc).append(" bpm\n");
        if (spo2 < 90) sb.append("⚠️ Paciente ").append(pacienteId).append(" - SpO2 baja: ").append(spo2).append("%\n");
        if (pas < 90 || pas > 140 || pad < 60 || pad > 90)
            sb.append("⚠️ Paciente ").append(pacienteId).append(" - PA crítica: ").append(pas).append("/").append(pad).append(" mmHg\n");
        return sb.toString().trim();
    }
}
