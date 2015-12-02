package com.tm.util.validations.beans;

public class Error {

	private String validatorMessage;
	
	private String applicationMessage;
	
	private String errorType;

	public String getErrorType() {
		return errorType;
	}

	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}

	public String getValidatorMessage() {
		return validatorMessage;
	}

	public void setValidatorMessage(String validatorMessage) {
		this.validatorMessage = validatorMessage;
	}

	public String getApplicationMessage() {
		return applicationMessage;
	}

	public void setApplicationMessage(String applicationMessage) {
		this.applicationMessage = applicationMessage;
	}
}
