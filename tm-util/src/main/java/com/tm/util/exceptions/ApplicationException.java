package com.tm.util.exceptions;

public class ApplicationException extends Exception {

	protected String errorCode;
	
    private static final long serialVersionUID = 1L;

    public ApplicationException() {
        super();
    }

    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException(Throwable cause) {
        super(cause);
    }
    
    public String getErrorCode() {
    	return errorCode;
    }
}
