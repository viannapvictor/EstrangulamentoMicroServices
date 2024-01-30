package br.com.ebac.usuariosmemelandia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "br.com.ebac.usuariosmemelandia.repository")
public class UsuariosMemelandiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsuariosMemelandiaApplication.class, args);
	}

}
