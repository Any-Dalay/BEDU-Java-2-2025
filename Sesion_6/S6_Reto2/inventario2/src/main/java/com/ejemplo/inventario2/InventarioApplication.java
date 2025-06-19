/*
 Objetivo: Reforzar el uso de relaciones en JPA mediante una entidad nueva llamada Marca, relacionada con Producto,
 simulando un modelo básico de una tienda en línea. Se trabajará con relaciones @ManyToOne, ideal para representar
 que varios productos pertenecen a una marca.
 */

package com.ejemplo.inventario2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventarioApplication {

	public static void main(String[] args) {

		SpringApplication.run(InventarioApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(ProductoRepository productoRepo, CategoriaRepository categoriaRepo, MarcaRepository marcaRepo) {
		return (args) -> {
			Categoria tecnologia = new Categoria("Tecnología");
			categoriaRepo.save(tecnologia);
			Marca apple = new Marca("Apple");
			Marca samsung = new Marca("Samsung");
			marcaRepo.save(apple);
			marcaRepo.save(samsung);


			productoRepo.save(new Producto("¡Phone 17", "Smartphone", 30000.00, tecnologia, apple));
			productoRepo.save(new Producto("¡Pad Pro", "Tablet", 26000.00, tecnologia, apple));
			productoRepo.save(new Producto("Galaxy S24", "Smartphone", 24000.00, tecnologia, samsung));
			productoRepo.save(new Producto("Smart TV 4K", "Pantalla 55 pulgadas", 7800.00, tecnologia, samsung));

			System.out.println("\n📂 Productos registrados:");
			productoRepo.findAll().forEach(p -> System.out.println(p.getNombre() + " - " + p.getCategoria().getNombre()));

			System.out.println("\n📚 Productos por marca:");
			marcaRepo.findAll().forEach(marca -> {
				System.out.println("🏷️ " + marca.getNombre() + ":");
				productoRepo.findAll().stream()
						.filter(p -> p.getMarca().getId().equals(marca.getId()))
						.forEach(p -> System.out.println("   - " + p.getNombre()));
			});
		};
	}

}
