package com.keisar.Hotel.Management.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {
    private LocalDateTime timestamp;
    private String errorMessage;
    private String errorDescription;
    private String errorCode;

    public ErrorResponse(String errorMessage, String errorDescription, String errorCode) {
        this.timestamp = LocalDateTime.now();
        this.errorMessage = errorMessage;
        this.errorDescription = errorDescription;
        this.errorCode = errorCode;
    }
}
