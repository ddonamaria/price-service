package com.company.priceservice.infrastructure.exceptions;

import com.company.priceservice.domain.exceptions.ErrorMessage;
import com.company.priceservice.domain.exceptions.PriceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PriceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorMessage> handlePriceNotFound(PriceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                ErrorMessage.builder().status(HttpStatus.NOT_FOUND).message(ex.getMessage()).build());
    }

    @ExceptionHandler(InvalidParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorMessage> handleInvalidParameter(InvalidParameterException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                ErrorMessage.builder().status(HttpStatus.BAD_REQUEST).message(ex.getMessage()).build());
    }
}
