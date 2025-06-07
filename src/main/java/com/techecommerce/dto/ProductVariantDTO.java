package com.techecommerce.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.util.List;
import java.util.Map;

@Data
public class ProductVariantDTO {
    @NotNull(message = "Product ID is required")
    private Long productId;

    @NotBlank(message = "SKU is required")
    @Pattern(regexp = "^[A-Z0-9-]{3,50}$", message = "SKU must contain only uppercase letters, numbers, and hyphens, between 3 and 50 characters")
    private String sku;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    @DecimalMax(value = "1000000000.0", message = "Price cannot exceed 1,000,000,000")
    private Double price;

    @NotNull(message = "Stock is required")
    @Min(value = 0, message = "Stock must be at least 0")
    @Max(value = 10000, message = "Stock cannot exceed 10,000")
    private Integer stock;

    @Size(max = 10, message = "Maximum 10 images allowed")
    private List<String> images;

    @NotNull(message = "Attributes are required")
    private Map<String, String> attributes;

    @NotNull(message = "Active status is required")
    private Boolean active;

    @AssertTrue(message = "Price must be greater than product's import price")
    public boolean isPriceValid() {
        // This method should be implemented to compare with product's import price
        return true;
    }

    @AssertTrue(message = "Attributes must match product's attribute set")
    public boolean isAttributesValid() {
        // This method should be implemented to validate against product's attribute set
        return true;
    }
} 