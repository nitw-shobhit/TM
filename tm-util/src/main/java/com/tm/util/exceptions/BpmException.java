package com.tm.util.exceptions;

public class BpmException extends ApplicationException {

    private static final long serialVersionUID = 1L;

    public BpmException() {
    	errorCode = "1007";
    }

    public BpmException(String message, Throwable cause) {
        super(message, cause);
    	errorCode = "1007";
    }

    public BpmException(String message) {
        super(message);
    	errorCode = "1007";
    }

    public BpmException(Throwable cause) {
        super(cause);
    	errorCode = "1007";
    }
}
