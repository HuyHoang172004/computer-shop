package com.techecommerce.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.util.List;
import java.util.Map;

@Data
public class ProductSpecificationDTO {
    @NotNull(message = "Product ID is required")
    private Long productId;

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @NotBlank(message = "Value is required")
    @Size(max = 500, message = "Value must not exceed 500 characters")
    private String value;

    @Size(max = 500, message = "Description must not exceed 500 characters")
    private String description;

    @Min(value = 0, message = "Order must be at least 0")
    private Integer order;

    @NotNull(message = "Active status is required")
    private Boolean active;

    private Map<String, String> translations;

    @AssertTrue(message = "Translations must be valid")
    public boolean isTranslationsValid() {
        if (translations == null) {
            return true;
        }
        return translations.values().stream()
                .allMatch(value -> value != null && value.length() <= 500);
    }
} 