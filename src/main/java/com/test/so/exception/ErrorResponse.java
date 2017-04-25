package com.test.so.exception;

/**
 *
 * @author gduvinage
 */
public class ErrorResponse {
    private int errCode;
    private String message;

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
}
