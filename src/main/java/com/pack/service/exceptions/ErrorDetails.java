package com.pack.service.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @NoArgsConstructor
public class ErrorDetails {
    private Date timestamp;
    private String message;
    private String details;

    public ErrorDetails(String message, String details) {
        this.timestamp = new Date();
        this.message = "Une erreur est survenue pendant l'opération. Cause :" + message;
        this.details = details;
    }
}
