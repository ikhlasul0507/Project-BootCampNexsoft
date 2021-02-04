package br.com.danielpadua.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExampleApplication {

	public static void main(String[] args) {

		System.out.println("Alif anak baik");
		System.out.println("---------------------------------");
		SpringApplication.run(ExampleApplication.class, args);
	}

}
