package com.example.realtime_exception_handling.controller;
import com.example.realtime_exception_handling.customexceptions.EmailValidationException;
import com.example.realtime_exception_handling.customexceptions.FirstNameValidationException;
import com.example.realtime_exception_handling.entity.User;
import com.example.realtime_exception_handling.errors.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @PostMapping("/user")
    public User addUser(@RequestBody User user) {
        if(!user.getEmail().contains("@")){
//            try {
//                throw new EmailValidationException("Not a valid Email :: " + user.getEmail());
//            }catch(Exception e){
//                e.printStackTrace();
//
//            }
            throw new EmailValidationException("Not a valid Email::"+user.getEmail());
        }
        if(user.getFname().contains("!")){
            throw new FirstNameValidationException("Not a valid name :: "+user.getFname());
        }

        return user;

    }

    @ExceptionHandler(value = EmailValidationException.class)
    public ResponseEntity<Error> emailValidation(EmailValidationException exception) {
        Error error=new Error(1000,exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }



}