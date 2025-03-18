package com.company.priceservice.infrastructure.adapters.api.exceptions;

public class InvalidParameterException extends RuntimeException {

    public InvalidParameterException(String message) {
        super(message);
    }
}
