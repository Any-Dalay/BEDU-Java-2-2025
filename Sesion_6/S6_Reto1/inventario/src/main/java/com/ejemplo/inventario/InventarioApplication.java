/*
Objetivo: Aprender a crear una entidad Java utilizando JPA y definir un repositorio para gestionar operaciones básicas
con una base de datos, simulando un sistema de inventario.
Reto: Agregar validaciones y consultas específicas en la clase Producto, simulando un sistema de inventario más realista.
 */

package com.ejemplo.inventario;

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
	public CommandLineRunner demo(ProductoRepository repository) {
		return (args) -> {
			// Guardar algunos productos
			repository.save(new Producto("Laptop", "Portátil de 16 pulgadas", 1200.00));
			repository.save(new Producto("Teclado mecánico", "Switch azul", 800.00));
			repository.save(new Producto("Mouse gamer", "Alta precisión", 600.00));
			repository.save(new Producto("Monitor", "Monitor HD", 300.00));

			// Mostrar todos los productos
			System.out.println("\n📂 Productos disponibles:");
			repository.findAll().forEach(System.out::println);

			System.out.println("\n📦 Productos con precio mayor a 500:");
			repository.findByPrecioGreaterThan(500).forEach(System.out::println);

			System.out.println("\n🔍 Productos que contienen 'lap':");
			repository.findByNombreContainingIgnoreCase("lap").forEach(System.out::println);

			System.out.println("\n🎯 Productos con precio entre 400 y 1000:");
			repository.findByPrecioBetween(400, 1000).forEach(System.out::println);

			System.out.println("\n📘 Productos cuyo nombre empieza con 'm':");
			repository.findByNombreStartingWithIgnoreCase("m").forEach(System.out::println);
		};
	}
}
