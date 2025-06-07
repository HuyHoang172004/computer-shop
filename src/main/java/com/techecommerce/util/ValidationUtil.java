package com.techecommerce.util;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.Set;
import java.util.stream.Collectors;

public class ValidationUtil {
    private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private static final Validator validator = factory.getValidator();

    public static <T> Set<String> validate(T object) {
        Set<ConstraintViolation<T>> violations = validator.validate(object);
        return violations.stream()
            .map(ConstraintViolation::getMessage)
            .collect(Collectors.toSet());
    }

    public static <T> boolean isValid(T object) {
        return validator.validate(object).isEmpty();
    }

    public static <T> Set<ConstraintViolation<T>> getViolations(T object) {
        return validator.validate(object);
    }

    public static <T> String getViolationMessage(T object) {
        Set<ConstraintViolation<T>> violations = validator.validate(object);
        if (violations.isEmpty()) {
            return null;
        }
        return violations.stream()
            .map(ConstraintViolation::getMessage)
            .collect(Collectors.joining(", "));
    }

    public static <T> Set<String> getViolationMessages(T object) {
        return validator.validate(object).stream()
            .map(ConstraintViolation::getMessage)
            .collect(Collectors.toSet());
    }

    public static <T> Set<String> getViolationProperties(T object) {
        return validator.validate(object).stream()
            .map(violation -> violation.getPropertyPath().toString())
            .collect(Collectors.toSet());
    }

    public static <T> Set<Object> getViolationValues(T object) {
        return validator.validate(object).stream()
            .map(ConstraintViolation::getInvalidValue)
            .collect(Collectors.toSet());
    }

    public static <T> boolean hasViolation(T object, String property) {
        return validator.validate(object).stream()
            .anyMatch(violation -> violation.getPropertyPath().toString().equals(property));
    }

    public static <T> String getViolationMessageForProperty(T object, String property) {
        return validator.validate(object).stream()
            .filter(violation -> violation.getPropertyPath().toString().equals(property))
            .map(ConstraintViolation::getMessage)
            .findFirst()
            .orElse(null);
    }

    public static <T> Object getViolationValueForProperty(T object, String property) {
        return validator.validate(object).stream()
            .filter(violation -> violation.getPropertyPath().toString().equals(property))
            .map(ConstraintViolation::getInvalidValue)
            .findFirst()
            .orElse(null);
    }

    public static <T> Set<String> getViolationMessagesForProperty(T object, String property) {
        return validator.validate(object).stream()
            .filter(violation -> violation.getPropertyPath().toString().equals(property))
            .map(ConstraintViolation::getMessage)
            .collect(Collectors.toSet());
    }
} 