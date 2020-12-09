package com.shankar.sfg.recipes.recipes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class RecipesApplication {

	public static void main(String[] args) {
		log.info("Starting application");
		SpringApplication.run(RecipesApplication.class, args);
	}

}
