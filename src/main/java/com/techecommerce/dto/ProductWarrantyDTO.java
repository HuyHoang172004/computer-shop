package com.techecommerce.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ProductWarrantyDTO {
    @NotNull(message = "Product ID is required")
    private Long productId;

    @NotBlank(message = "Type is required")
    @Pattern(regexp = "^(MANUFACTURER|SELLER|NONE)$", message = "Invalid warranty type")
    private String type;

    @NotNull(message = "Duration is required")
    @Min(value = 0, message = "Duration must be at least 0")
    private Integer duration;

    @Pattern(regexp = "^(MONTH|YEAR)$", message = "Invalid duration unit")
    private String durationUnit;

    @Size(max = 1000, message = "Terms must not exceed 1000 characters")
    private String terms;

    @Size(max = 500, message = "Description must not exceed 500 characters")
    private String description;

    @AssertTrue(message = "Duration must be valid for the duration unit")
    public boolean isDurationValid() {
        if (duration == null || durationUnit == null) {
            return false;
        }
        switch (durationUnit) {
            case "MONTH":
                return duration <= 60; // 5 years
            case "YEAR":
                return duration <= 5;
            default:
                return false;
        }
    }
} 