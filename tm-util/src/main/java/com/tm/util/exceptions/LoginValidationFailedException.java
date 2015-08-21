package com.tm.util.exceptions;

public class LoginValidationFailedException extends ApplicationException {

    private static final long serialVersionUID = 1L;

    public LoginValidationFailedException() {
    	errorCode = "1002";
    }

    public LoginValidationFailedException(String message, Throwable cause) {
        super(message, cause);
    	errorCode = "1002";
    }

    public LoginValidationFailedException(String message) {
        super(message);
    	errorCode = "1002";
    }

    public LoginValidationFailedException(Throwable cause) {
        super(cause);
    	errorCode = "1002";
    }
}
