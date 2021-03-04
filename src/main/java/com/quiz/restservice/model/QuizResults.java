package com.quiz.restservice.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class QuizResults implements Serializable{

	private static final long serialVersionUID = 3705958972000701963L;
	
	private String type;
	private String difficulty;
	private String question;
	private ArrayList<String> all_answers;
	private String correct_answer;

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getCorrect_answer() {
		return correct_answer;
	}
	public void setCorrect_answer(String correct_answer) {
		this.correct_answer = correct_answer;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public ArrayList<String> getAll_answers() {
		return all_answers;
	}
	public void setAll_answers(ArrayList<String> all_answers) {
		this.all_answers = all_answers;
	}
}
