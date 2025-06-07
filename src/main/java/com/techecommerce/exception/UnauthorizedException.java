package com.techecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnauthorizedException extends RuntimeException {
    private String message;
    private String field;
    private Object value;

    public UnauthorizedException(String message) {
        super(message);
        this.message = message;
    }

    public UnauthorizedException(String message, String field, Object value) {
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