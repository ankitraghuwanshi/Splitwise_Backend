package org.scaler.splitwise_backend.exceptions;

public class UserNotFoundException extends Exception{
    //private String message;

    public UserNotFoundException(String message){
        super(message);
    }
}
