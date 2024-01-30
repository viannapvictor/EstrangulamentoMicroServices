package br.com.ebac.categoriasmemelandia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "br.com.ebac.categoriasmemelandia.repository")
public class CategoriasmemelandiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CategoriasmemelandiaApplication.class, args);
	}

}
