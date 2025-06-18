/*
Imagina que trabajas en una planta industrial que produce:

🔧 Órdenes de producción en masa (productos estándar).
🛠️ Órdenes personalizadas (adaptadas a cliente).
🧪 Prototipos (productos en prueba).
Debes implementar un sistema que:

Gestione listas de órdenes de diferentes tipos (usando genéricos).
Muestre información de las órdenes sin importar el tipo.
Procese las órdenes personalizadas, agregando un costo adicional por ajuste.
*/

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<OrdenMasa> ordenesMasa = new ArrayList<>();
        ordenesMasa.add(new OrdenMasa("A123", 500));
        ordenesMasa.add(new OrdenMasa("A124", 750));

        List<OrdenPersonalizada> ordenesPersonalizadas = new ArrayList<>();
        ordenesPersonalizadas.add(new OrdenPersonalizada("P456", 100, "ClienteX"));
        ordenesPersonalizadas.add(new OrdenPersonalizada("P789", 150, "ClienteY"));

        List<OrdenPrototipo> ordenesPrototipo = new ArrayList<>();
        ordenesPrototipo.add(new OrdenPrototipo("T789", 10, "Diseño"));
        ordenesPrototipo.add(new OrdenPrototipo("T790", 5, "Pruebas"));

        // Mostrar órdenes
        GestorOrden.mostrarOrdenes(ordenesMasa);
        GestorOrden.mostrarOrdenes(ordenesPersonalizadas);
        GestorOrden.mostrarOrdenes(ordenesPrototipo);

        // Procesar órdenes personalizadas
        GestorOrden.procesarPersonalizadas(new ArrayList<>(ordenesPersonalizadas), 200);

        // Todas la órdenes para el resumen total
        List<OrdenProduccion> total = new ArrayList<>();
        total.addAll(ordenesMasa);
        total.addAll(ordenesPersonalizadas);
        total.addAll(ordenesPrototipo);

        GestorOrden.contarOrdenes(total);
    }
}