package com.techecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {
    private String message;
    private String field;
    private Object value;

    public BadRequestException(String message) {
        super(message);
        this.message = message;
    }

    public BadRequestException(String message, String field, Object value) {
        super(message);
        this.message = message;
        this.field = field;
        this.value = value;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String getField() {
        return field;
    }

    public Object getValue() {
        return value;
    }
} 