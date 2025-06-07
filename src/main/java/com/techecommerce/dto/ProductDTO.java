package com.techecommerce.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductDTO {
    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 100, message = "Name must be between 3 and 100 characters")
    private String name;

    @NotBlank(message = "Description is required")
    @Size(min = 10, max = 2000, message = "Description must be between 10 and 2000 characters")
    private String description;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    @DecimalMax(value = "1000000000.0", message = "Price must be less than 1 billion")
    private BigDecimal price;

    @NotNull(message = "Import price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Import price must be greater than 0")
    @DecimalMax(value = "1000000000.0", message = "Import price must be less than 1 billion")
    private BigDecimal importPrice;

    @NotNull(message = "Stock is required")
    @Min(value = 0, message = "Stock cannot be negative")
    @Max(value = 1000000, message = "Stock cannot exceed 1 million")
    private Integer stock;

    @NotNull(message = "Category ID is required")
    private Long categoryId;

    @NotNull(message = "Brand ID is required")
    private Long brandId;

    @NotEmpty(message = "At least one image is required")
    @Size(max = 10, message = "Maximum 10 images allowed")
    private List<String> images;

    @Size(max = 1000, message = "Specifications must not exceed 1000 characters")
    private String specifications;

    @Size(max = 500, message = "Warranty information must not exceed 500 characters")
    private String warranty;

    @AssertTrue(message = "Price must be greater than import price")
    public boolean isPriceGreaterThanImportPrice() {
        if (price == null || importPrice == null) {
            return true;
        }
        return price.compareTo(importPrice) > 0;
    }
} 