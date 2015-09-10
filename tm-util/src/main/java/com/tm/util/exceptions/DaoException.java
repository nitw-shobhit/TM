package com.tm.util.exceptions;

public class DaoException extends ApplicationException {

    private static final long serialVersionUID = 1L;

    public DaoException() {
    	errorCode = "1009";
    }

    public DaoException(String message, Throwable cause) {
        super(message, cause);
    	errorCode = "1009";
    }

    public DaoException(String message) {
        super(message);
    	errorCode = "1009";
    }

    public DaoException(Throwable cause) {
        super(cause);
    	errorCode = "1009";
    }
}
