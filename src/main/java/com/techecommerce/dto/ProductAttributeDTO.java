package com.techecommerce.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.util.List;

@Data
public class ProductAttributeDTO {
    @NotNull(message = "Product ID is required")
    private Long productId;

    @NotNull(message = "Attribute ID is required")
    private Long attributeId;

    @NotBlank(message = "Value is required")
    @Size(max = 500, message = "Value must not exceed 500 characters")
    private String value;

    private List<String> values;

    @AssertTrue(message = "Values are required for MULTI_SELECT type")
    public boolean isValuesValid() {
        if (getAttributeType().equals("MULTI_SELECT")) {
            return values != null && !values.isEmpty();
        }
        return true;
    }

    @AssertTrue(message = "Values must be unique")
    public boolean isValuesUnique() {
        if (values == null) {
            return true;
        }
        return values.stream().distinct().count() == values.size();
    }

    private String getAttributeType() {
        // This method should be implemented to get the attribute type from the attribute service
        return "TEXT";
    }
} 