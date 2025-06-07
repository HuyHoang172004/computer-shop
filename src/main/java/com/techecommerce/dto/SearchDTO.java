package com.techecommerce.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.util.List;

@Data
public class SearchDTO {
    @Size(min = 2, max = 100, message = "Keyword must be between 2 and 100 characters")
    private String keyword;

    private List<Long> categoryIds;

    private List<Long> brandIds;

    @DecimalMin(value = "0.0", message = "Min price must be at least 0")
    private Double minPrice;

    @DecimalMin(value = "0.0", message = "Max price must be at least 0")
    private Double maxPrice;

    @Pattern(regexp = "^(NAME|PRICE_ASC|PRICE_DESC|NEWEST|POPULAR)$", message = "Invalid sort field")
    private String sortBy;

    @Pattern(regexp = "^(ASC|DESC)$", message = "Invalid sort direction")
    private String sortDirection;

    @Min(value = 1, message = "Page number must be at least 1")
    private Integer page;

    @Min(value = 1, message = "Page size must be at least 1")
    @Max(value = 100, message = "Page size cannot exceed 100")
    private Integer size;

    @AssertTrue(message = "Max price must be greater than min price")
    public boolean isPriceRangeValid() {
        if (minPrice == null || maxPrice == null) {
            return true;
        }
        return maxPrice > minPrice;
    }
} 