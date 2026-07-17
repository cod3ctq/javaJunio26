package com.ms_prestamos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsPrestamosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsPrestamosApplication.class, args);
	}

}
