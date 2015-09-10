package com.tm.util.exceptions;

public class DtoConversionException extends ApplicationException {

    private static final long serialVersionUID = 1L;

    public DtoConversionException() {
    	errorCode = "1008";
    }

    public DtoConversionException(String message, Throwable cause) {
        super(message, cause);
    	errorCode = "1008";
    }

    public DtoConversionException(String message) {
        super(message);
    	errorCode = "1008";
    }

    public DtoConversionException(Throwable cause) {
        super(cause);
    	errorCode = "1008";
    }
}
