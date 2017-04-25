package com.test.so.exception;

/**
 *
 * @author gduvinage
 */
public class PersonException extends Exception{
    private static final Long serialVersionUID = 1L;
    
    private String errorMessage;

    public PersonException() {
        super();
    }

    public PersonException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
    
    
}
