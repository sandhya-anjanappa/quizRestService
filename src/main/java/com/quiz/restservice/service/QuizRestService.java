package com.quiz.restservice.service;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.quiz.restservice.model.ResponseObject;

@Service
public class QuizRestService {

	private static Logger log = LoggerFactory.getLogger(QuizRestService.class);
	private RestTemplate restTemplate = new RestTemplate();


	@Async("asyncExecutor")
	public CompletableFuture<ResponseObject> getResultsFromApi1() throws InterruptedException 
	{
		log.info("API1 Starts");
		ResponseObject responseFromApi1 = restTemplate.getForObject("https://opentdb.com/api.php?amount=5&category=11", ResponseObject.class);

		log.info("responseFromApi1, {}", responseFromApi1);
		Thread.sleep(1000L);	//Intentional delay
		log.info("responseFromApi1 completed");
		return CompletableFuture.completedFuture(responseFromApi1);
	}

	@Async("asyncExecutor")
	public CompletableFuture<ResponseObject> getResultsFromApi2() throws InterruptedException 
	{
		log.info("API2 Starts");
		ResponseObject responseFromApi2 = restTemplate.getForObject("https://opentdb.com/api.php?amount=5&category=12", ResponseObject.class);

		log.info("responseFromApi2, {}", responseFromApi2);
		Thread.sleep(1000L);	//Intentional delay
		log.info("responseFromApi2 completed");
		return CompletableFuture.completedFuture(responseFromApi2);
	}


}
