package com.stajokulu.tools;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(Exception.class)
    ResponseEntity<?> handle(Exception e) {

        return handle(new CustomGenericException(e));
    }

    @ExceptionHandler(CustomGenericException.class)
    ResponseEntity<?> handle(CustomGenericException e) {

        final String errorMessage = String.join("-", e.getMessages().orElse(new String[] {""}));

        return ResponseEntity.status(e.getCode()).body(errorMessage);
    }
}
