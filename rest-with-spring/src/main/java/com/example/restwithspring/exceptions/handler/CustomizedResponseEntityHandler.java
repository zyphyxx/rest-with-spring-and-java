package com.example.restwithspring.exceptions.handler;

import com.example.restwithspring.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice
public class CustomizedResponseEntityHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionsResponse> handleAllExceptions (
            Exception e, WebRequest request){
        ExceptionsResponse exceptionsResponse = new ExceptionsResponse( new Date(),e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionsResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<ExceptionsResponse> handleNotFoundExceptions (
            Exception e, WebRequest request){
        ExceptionsResponse exceptionsResponse = new ExceptionsResponse( new Date(),e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionsResponse, HttpStatus.NOT_FOUND);
    }
}
