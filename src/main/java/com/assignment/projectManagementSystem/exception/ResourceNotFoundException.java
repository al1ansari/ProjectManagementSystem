package com.assignment.projectManagementSystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {


    public ResourceNotFoundException(String msg){
        super(msg);
    }

    public ResourceNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}
