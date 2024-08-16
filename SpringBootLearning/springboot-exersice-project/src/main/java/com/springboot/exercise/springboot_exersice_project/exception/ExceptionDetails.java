package com.springboot.exercise.springboot_exersice_project.exception;

import java.time.LocalDateTime;

public class ExceptionDetails {
    private LocalDateTime timestamp;
    private String message;
    private String details;

    public ExceptionDetails(LocalDateTime timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getDetails() {
        return details;
    }
    public void setDetails(String details) {
        this.details = details;
    }
    @Override
    public String toString() {
        return "ExceptionDetails [timestamp=" + timestamp + ", message=" + message + ", details=" + details + "]";
    }    
}
