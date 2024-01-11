package org.example;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Spring22UnitTestingMockitoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring22UnitTestingMockitoApplication.class, args);
	}

	@Bean
	public ModelMapper mapper(){
		return new ModelMapper();
	}

}
