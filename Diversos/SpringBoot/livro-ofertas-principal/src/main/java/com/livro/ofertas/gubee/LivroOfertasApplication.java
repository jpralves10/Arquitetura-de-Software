package com.livro.ofertas.gubee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
//@SpringBootApplication
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class LivroOfertasApplication {

	public static void main(String[] args) {
		SpringApplication.run(LivroOfertasApplication.class, args);
	}

}
