package com.tm.util.exceptions;

public class DatabaseException extends ApplicationException {

    private static final long serialVersionUID = 1L;

    public DatabaseException() {
    	errorCode = "1006";
    }

    public DatabaseException(String message, Throwable cause) {
        super(message, cause);
    	errorCode = "1006";
    }

    public DatabaseException(String message) {
        super(message);
    	errorCode = "1006";
    }

    public DatabaseException(Throwable cause) {
        super(cause);
    	errorCode = "1006";
    }
}
