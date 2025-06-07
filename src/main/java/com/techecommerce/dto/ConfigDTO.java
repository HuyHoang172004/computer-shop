package com.techecommerce.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ConfigDTO {
    @NotBlank(message = "Key is required")
    @Pattern(regexp = "^[A-Z_]{3,50}$", message = "Key must contain only uppercase letters and underscores, between 3 and 50 characters")
    private String key;

    @NotBlank(message = "Value is required")
    @Size(max = 1000, message = "Value must not exceed 1000 characters")
    private String value;

    @Size(max = 500, message = "Description must not exceed 500 characters")
    private String description;

    @NotBlank(message = "Type is required")
    @Pattern(regexp = "^(STRING|NUMBER|BOOLEAN|JSON|ARRAY)$", message = "Invalid config type")
    private String type;

    @NotNull(message = "Active status is required")
    private Boolean active;

    @AssertTrue(message = "Value must match the specified type")
    public boolean isValueValid() {
        if (value == null) {
            return false;
        }
        try {
            switch (type) {
                case "NUMBER":
                    Double.parseDouble(value);
                    return true;
                case "BOOLEAN":
                    return value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false");
                case "JSON":
                    // Add JSON validation if needed
                    return true;
                case "ARRAY":
                    // Add array validation if needed
                    return true;
                default:
                    return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
} 