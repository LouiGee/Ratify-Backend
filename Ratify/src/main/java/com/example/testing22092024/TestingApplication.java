package com.example.testing22092024;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;


@EnableJpaAuditing
@EnableAsync
@SpringBootApplication
@RequiredArgsConstructor
public class TestingApplication {





	public static void main(String[] args) {
		SpringApplication.run(TestingApplication.class, args);
	}


}




