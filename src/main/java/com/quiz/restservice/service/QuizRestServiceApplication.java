package com.quiz.restservice.service;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.quiz.restservice"})
public class QuizRestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizRestServiceApplication.class, args);
	}
}
