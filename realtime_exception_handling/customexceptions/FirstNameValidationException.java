package com.example.realtime_exception_handling.customexceptions;

public class FirstNameValidationException extends RuntimeException {

    public FirstNameValidationException(String message) {
        super(message);

    }
}
