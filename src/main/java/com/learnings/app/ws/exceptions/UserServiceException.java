package com.learnings.app.ws.exceptions;

public class UserServiceException extends RuntimeException {
    public UserServiceException(String message){
        super(message);
    }
}
