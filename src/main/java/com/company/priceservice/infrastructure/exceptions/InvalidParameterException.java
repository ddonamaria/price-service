package com.company.priceservice.infrastructure.exceptions;

public class InvalidParameterException extends RuntimeException {

    public InvalidParameterException(String message) {
        super(message);
    }
}
