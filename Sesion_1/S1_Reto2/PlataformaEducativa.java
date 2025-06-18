import java.util.List;
import java.util.function.Predicate;

public class PlataformaEducativa {

    public static void mostrarMateriales(List<? extends MaterialCurso> lista) {
        for (MaterialCurso m : lista) {
            m.mostrarDetalle();
        }
    }

    public static void contarDuracionVideos(List<? extends Video> lista) {
        int total = 0;
        for (Video v : lista) {
            total += v.getDuracion();
        }
        System.out.println("🎞️ Duración total de videos: " + total + " minutos");
    }

    public static void marcarEjerciciosRevisados(List<? super Ejercicio> lista) {
        for (Object obj : lista) {
            if (obj instanceof Ejercicio) {
                Ejercicio e = (Ejercicio) obj;
                e.marcarRevisado();
                System.out.println("✅ Ejercicio '" + e.titulo + "' marcado como revisado.");
            }
        }
    }

    public static void filtrarPorAutor(List<? extends MaterialCurso> lista, Predicate<MaterialCurso> filtro) {
        for (MaterialCurso m : lista) {
            if (filtro.test(m)) {
                m.mostrarDetalle();
            }
        }
    }
}