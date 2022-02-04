package com.example.demo;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Producto;
import com.example.demo.model.Usuario;
import com.example.demo.repository.ProductoRepository;
import com.example.demo.repository.UsuarioRepository;

@SpringBootApplication
public class BuenoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuenoSpringApplication.class, args);
	}
	
	
	@Bean
	CommandLineRunner iniData (UsuarioRepository usuRepo) {
		return (args) -> {
			usuRepo.saveAll(Arrays.asList(new Usuario("user","José", "Pérez", "user", "C/Málaga, 9 7A", 650000000, "user@user.com"),
					new Usuario("admin","Antonia", "García", "admin", "C/Arroyo, 9 7A", 690000000, "admin@admin.com"),
					new Usuario("flavio","Flavio",
							"de Diego", "flavio", "C/Jaen, 9 7A", 850000000, "flavio@flavio.com")
					));
		};
	}
	
	
	@Bean
	CommandLineRunner iniDataProdu (ProductoRepository produRepo) {
		return (args) -> {
			produRepo.saveAll(Arrays.asList(
					new Producto("Mordedor-A", 20.0, 1, "/img/pesa.jpg"),
					new Producto("Mordedor-B", 15.0, 2, "/img/pesa2.png"),
					new Producto("Mordedor-C", 10.0, 3, "/img/pesa3.jpg")));
		};
	}
	

}
