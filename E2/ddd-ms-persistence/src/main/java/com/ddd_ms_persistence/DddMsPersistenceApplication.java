package com.ddd_ms_persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("ddd-ms-persistence.repository")
@EntityScan("ddd-ms-persistence.entity")
public class DddMsPersistenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DddMsPersistenceApplication.class, args);
	}

}
