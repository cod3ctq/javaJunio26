package com.ddd_ms_cuentas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.ddd_ms_persistence.repository")
@EntityScan("com.ddd_ms_persistence.entity")
public class DddMsCuentasApplication {

	public static void main(String[] args) {
		SpringApplication.run(DddMsCuentasApplication.class, args);
	}

}
