package com.quiz.restservice.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.quiz.restservice.model.FinalQuizResponseObject;
import com.quiz.restservice.model.QuizResponseObject;
import com.quiz.restservice.model.QuizResults;
import com.quiz.restservice.model.ResponseObject;
import com.quiz.restservice.model.Results;
import com.quiz.restservice.service.QuizRestService;


@RestController
public class QuizRestServiceController {

	private static Logger log = LoggerFactory.getLogger(QuizRestServiceController.class);

	@Autowired
	private QuizRestService service;


	@RequestMapping(value = "/coding/exercise/quiz", method = RequestMethod.GET)
	public ResponseEntity<FinalQuizResponseObject> testAsynch() throws InterruptedException, ExecutionException, JsonMappingException, JsonProcessingException 
	{
		log.info("---------  Quiz Rest Service ------- ");

		// Retrieve data from downstream services.
		CompletableFuture<ResponseObject> responseFromApiOne = service.getResultsFromApi1();
		CompletableFuture<ResponseObject> responseFromApiTwo = service.getResultsFromApi2();
		
		// Wait until they are all done
		CompletableFuture.allOf(responseFromApiOne, responseFromApiTwo).join();		
			
		// Change the response object structure based on the requirement.
		QuizResponseObject responseOne = changeJasonFormat(responseFromApiOne.get());
		QuizResponseObject responseTwo = changeJasonFormat(responseFromApiTwo.get());
		
		// Combine both the responses from two different services.
		ArrayList<QuizResponseObject> responseFromOtherApis = new ArrayList<QuizResponseObject>();
		responseFromOtherApis.add(responseOne);
		responseFromOtherApis.add(responseTwo);
		
		// Construct & return the final response object.
		FinalQuizResponseObject finalResponse = new FinalQuizResponseObject();
		finalResponse.setQuiz(responseFromOtherApis);
		
		return new ResponseEntity<>(finalResponse, HttpStatus.OK);
	}
	
	
	
	private QuizResponseObject changeJasonFormat(ResponseObject responseObject) {
		
		Results results [] = responseObject.getResults();
		ArrayList<QuizResults> quizResults = new ArrayList<QuizResults>();
		
		QuizResponseObject quizResponseObj = new QuizResponseObject();
		
		// Iterate over all the results and alter the JSON structure as per the requirement.
		for (Results result : results) {
			
			if (quizResponseObj.getCategory() == null) {
				quizResponseObj.setCategory(result.getCategory());
			}
			
			QuizResults quizResult = new QuizResults();
			quizResult.setType(result.getType());
			quizResult.setDifficulty(result.getDifficulty());
			quizResult.setQuestion(result.getQuestion());
			quizResult.setCorrect_answer(result.getCorrect_answer());
			
			// Add correct answer to incorrect answer list to get all answers.
			result.getIncorrect_answers().add(result.getCorrect_answer());			
			quizResult.setAll_answers(result.getIncorrect_answers());
		
			quizResults.add(quizResult);
		}
		
		quizResponseObj.setResults(quizResults);
		return quizResponseObj;
	}

}
