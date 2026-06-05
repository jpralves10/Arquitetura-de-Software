package com.livro.ofertas.gubee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class LivroOfertasApplication {

	public static void main(String[] args) {
		SpringApplication.run(LivroOfertasApplication.class, args);
	}

}
