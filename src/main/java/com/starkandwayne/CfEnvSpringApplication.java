package com.starkandwayne;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class CfEnvSpringApplication {
	
	@GetMapping("/")
	String home() {
		return System.getenv().toString();
	}

	public static void main(String[] args) {
		SpringApplication.run(CfEnvSpringApplication.class, args);
	}

}
