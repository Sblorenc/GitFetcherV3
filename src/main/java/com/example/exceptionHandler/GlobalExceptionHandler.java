package com.example.exceptionHandler;

import com.example.exceptionHandler.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ExceptionResponse>handleUserNotFoundException(UserNotFoundException ex){
        ExceptionResponse response = new ExceptionResponse(HttpStatus.NOT_FOUND.value(),"User not found");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}

