package com.example.dating_app.exception;

public class UserProfileNotFoundException extends  RuntimeException {
    public UserProfileNotFoundException(String exceptionMessage) {
            super(exceptionMessage);
        }
}
