package com.pack.service.exceptions;

public class SuppressionException extends RuntimeException {

    public SuppressionException(String message) {
        super("Erreur pendant la suppression de l'élément. Cause: "+message);
    }
}
