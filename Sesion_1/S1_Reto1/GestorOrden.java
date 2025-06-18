import java.util.List;

public class GestorOrden {

    // Método genérico para leer cualquier tipo de orden y mostrar sus datos
    public static void mostrarOrdenes(List<? extends OrdenProduccion> lista) {
        System.out.println("\n📋 Órdenes registradas:");
        for (OrdenProduccion orden : lista) {
            orden.mostrarResumen();
        }
    }

    // Método para modificar solo las órdenes personalizadas, mostrando un mensaje con el costo agregado
    public static void procesarPersonalizadas(List<? super OrdenPersonalizada> lista, int costoAdicional) {
        System.out.println("\n💰 Procesando órdenes personalizadas...");
        for (Object obj : lista) {
            if (obj instanceof OrdenPersonalizada) {
                ((OrdenPersonalizada) obj).ajustarCosto(costoAdicional);
            }
        }
    }

    // Método para contar el total de órdenes de cada tipo en la planta
    public static void contarOrdenes(List<OrdenProduccion> total) {
        int masa = 0, personalizadas = 0, prototipos = 0;
        for (OrdenProduccion orden : total) {
            if (orden instanceof OrdenMasa) masa++;
            else if (orden instanceof OrdenPersonalizada) personalizadas++;
            else if (orden instanceof OrdenPrototipo) prototipos++;
        }

        System.out.println("\n📊 Resumen total de órdenes:");
        System.out.println("🔧 Producción en masa: " + masa);
        System.out.println("🛠️ Personalizadas: " + personalizadas);
        System.out.println("🧪 Prototipos: " + prototipos);
    }
}