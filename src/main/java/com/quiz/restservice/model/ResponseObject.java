package com.quiz.restservice.model;

import java.io.Serializable;

public class ResponseObject implements Serializable {

	private static final long serialVersionUID = 9089911519863129623L;
	private String response_code;
	private Results results[];
	
	public String getResponse_code() {
		return response_code;
	}
	public void setResponse_code(String response_code) {
		this.response_code = response_code;
	}
	public Results[] getResults() {
		return results;
	}
	public void setResults(Results[] results) {
		this.results = results;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
