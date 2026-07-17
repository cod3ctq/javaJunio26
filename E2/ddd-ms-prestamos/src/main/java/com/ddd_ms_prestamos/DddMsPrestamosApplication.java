package com.ddd_ms_prestamos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.ddd_ms_persistence.repository")
@EntityScan("com.ddd_ms_persistence.entity")
public class DddMsPrestamosApplication {

	public static void main(String[] args) {
		SpringApplication.run(DddMsPrestamosApplication.class, args);
	}

}
