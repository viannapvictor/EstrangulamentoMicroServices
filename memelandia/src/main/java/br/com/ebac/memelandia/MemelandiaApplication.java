package br.com.ebac.memelandia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("br.com.ebac.memelandia.repositories")
@EnableFeignClients(basePackages = "br.com.ebac.memelandia.client")
public class MemelandiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemelandiaApplication.class, args);
	}

}
