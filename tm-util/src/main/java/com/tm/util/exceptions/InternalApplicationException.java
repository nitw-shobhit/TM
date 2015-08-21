package com.tm.util.exceptions;

public class InternalApplicationException extends ApplicationException {

    private static final long serialVersionUID = 1L;

    public InternalApplicationException() {
    	errorCode = "1001";
    }

    public InternalApplicationException(String message, Throwable cause) {
        super(message, cause);
    	errorCode = "1001";
    }

    public InternalApplicationException(String message) {
        super(message);
    	errorCode = "1001";
    }

    public InternalApplicationException(Throwable cause) {
        super(cause);
    	errorCode = "1001";
    }
}
