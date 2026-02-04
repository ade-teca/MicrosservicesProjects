package com.keisar.Hotel.Management.exception;

import com.keisar.Hotel.Management.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalHandlingException {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(ResourceNotFoundException exception, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessage(),
                request.getDescription(false),
                "Resource not found");

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

    }
}
