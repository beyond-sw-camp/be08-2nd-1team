package com.beyond.kkwoborrow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class KkwoborrowApplication {

	public static void main(String[] args) {
		SpringApplication.run(KkwoborrowApplication.class, args);
	}

}
