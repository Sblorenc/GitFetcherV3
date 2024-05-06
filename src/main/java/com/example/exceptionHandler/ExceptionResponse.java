package com.example.exceptionHandler;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionResponse {
    private int status;
    private String message;

    public ExceptionResponse(int status, String message){
        this.status = status;
        this.message = message;
    }
}
