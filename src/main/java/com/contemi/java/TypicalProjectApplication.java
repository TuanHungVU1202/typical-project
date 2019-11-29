package com.contemi.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.contemi.java.models")
public class TypicalProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(TypicalProjectApplication.class, args);
	}

}
