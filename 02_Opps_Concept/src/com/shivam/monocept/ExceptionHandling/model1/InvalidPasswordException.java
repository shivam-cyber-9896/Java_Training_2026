package com.shivam.monocept.ExceptionHandling.model1;

public class InvalidPasswordException extends Exception {

    public InvalidPasswordException(String message) {
        super(message);
    }
}
