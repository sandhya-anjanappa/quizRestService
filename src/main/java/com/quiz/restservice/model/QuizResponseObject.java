package com.quiz.restservice.model;

import java.io.Serializable;
import java.util.ArrayList;

public class QuizResponseObject implements Serializable {
	
	private static final long serialVersionUID = 9089911519863129623L;
	private String category;
	private ArrayList<QuizResults> results;
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	public ArrayList<QuizResults> getResults() {
		return results;
	}
	public void setResults(ArrayList<QuizResults> results) {
		this.results = results;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
