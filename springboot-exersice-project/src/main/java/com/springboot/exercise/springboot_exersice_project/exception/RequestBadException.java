package com.springboot.exercise.springboot_exersice_project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class RequestBadException extends RuntimeException {
    public RequestBadException(String message) {
        super(message);
    }
}
