package com.thanhthien.cuoiki;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication()
public class CuoikiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CuoikiApplication.class, args);
	}

}
