package com.example.dating_app.exception;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String testNotFound) {
        super(testNotFound);
    }
}
