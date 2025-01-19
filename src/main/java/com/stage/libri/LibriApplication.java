package com.stage.libri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibriApplication {

	public static void main(String[] args) {
		System.setProperty("log4j.configurationFile", "classpath:log4j2.xml");
		SpringApplication.run(LibriApplication.class, args);
	}

}
