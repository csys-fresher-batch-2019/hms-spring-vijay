package com.vijaysankar.HMSYSTEMAPP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ServletComponentScan("com.hmgsystem")
public class HmsystemappApplication {

	public static void main(String[] args) {
		SpringApplication.run(HmsystemappApplication.class, args);
	}

}
