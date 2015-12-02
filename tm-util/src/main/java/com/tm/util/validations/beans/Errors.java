package com.tm.util.validations.beans;

import java.util.ArrayList;
import java.util.List;

public class Errors {

	private boolean error;
	
	private List<Error> errors;

	public Errors() {
		this.error = false;
		this.errors = new ArrayList<Error>();
	}
	
	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}
}
