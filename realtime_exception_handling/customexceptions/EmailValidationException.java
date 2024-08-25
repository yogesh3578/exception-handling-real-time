package com.example.realtime_exception_handling.customexceptions;

public class EmailValidationException extends RuntimeException{

    public EmailValidationException(String error) {
        super(error);

    }
}
