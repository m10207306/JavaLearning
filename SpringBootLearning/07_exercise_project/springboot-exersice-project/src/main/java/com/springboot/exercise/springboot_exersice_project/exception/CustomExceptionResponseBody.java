package com.springboot.exercise.springboot_exersice_project.exception;


import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionResponseBody extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
        ExceptionDetails exceptionDetails = new ExceptionDetails(
            LocalDateTime.now(), 
            ex.getMessage(), 
            request.getDescription(false)
        );
        return new ResponseEntity<>(exceptionDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<Object> handleResourceNotFoundException(RuntimeException ex, WebRequest request) throws Exception {
        ExceptionDetails exceptionDetails = new ExceptionDetails(
            LocalDateTime.now(), 
            ex.getMessage(), 
            request.getDescription(false)
        );
        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RequestBadException.class)
    public final ResponseEntity<Object> handleRequestBadException(RuntimeException ex, WebRequest request) throws Exception {
        ExceptionDetails exceptionDetails = new ExceptionDetails(
            LocalDateTime.now(), 
            ex.getMessage(), 
            request.getDescription(false)
        );
        return new ResponseEntity<>(exceptionDetails, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String errors = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining(", "));
        
        ExceptionDetails exceptionDetails = new ExceptionDetails(
            LocalDateTime.now(), 
            errors, 
            request.getDescription(false)
        );
        return new ResponseEntity<>(exceptionDetails, HttpStatus.BAD_REQUEST);
    }
}
