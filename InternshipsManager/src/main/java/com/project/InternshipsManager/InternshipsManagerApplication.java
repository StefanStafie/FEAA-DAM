package com.project.InternshipsManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.project.InternshipsManager")
public class InternshipsManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(InternshipsManagerApplication.class, args);
	}

}
