package com.example.dating_app.controller;

import com.example.dating_app.exception.TestNotFoundException;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({TestNotFoundException.class})
    public ResponseEntity<String> handleDishesNotFoundException(TestNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(),HttpStatusCode.valueOf(200));
    }
}
