package com.quiz.restservice.model;

import java.io.Serializable;
import java.util.ArrayList;

public class FinalQuizResponseObject implements Serializable {
	
	private static final long serialVersionUID = 9089911519863129623L;
	public ArrayList<QuizResponseObject> quiz;

	public ArrayList<QuizResponseObject> getQuiz() {
		return quiz;
	}

	public void setQuiz(ArrayList<QuizResponseObject> quiz) {
		this.quiz = quiz;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
