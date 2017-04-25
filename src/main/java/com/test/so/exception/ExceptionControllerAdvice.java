package com.test.so.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author gduvinage
 */
@ControllerAdvice
public class ExceptionControllerAdvice {
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception e) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.setMessage("Contactez votre administrateur system");
        return new ResponseEntity<>(errorResponse,HttpStatus.OK);
    }
    
    
}
