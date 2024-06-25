package com.example.dating_app.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String testNotFound) {
        super(testNotFound);
    }
}
