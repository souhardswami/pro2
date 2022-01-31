package com.example.main.Exception;


public class ApiExceptionThrow extends RuntimeException {
    

    public ApiExceptionThrow(String message){
        super(message);
    }

    public ApiExceptionThrow(String message, Throwable cause){
        super(message, cause);
    }

}
