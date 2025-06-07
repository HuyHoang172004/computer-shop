package com.techecommerce.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.util.List;

@Data
public class AttributeDTO {
    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @NotBlank(message = "Type is required")
    @Pattern(regexp = "^(TEXT|NUMBER|SELECT|MULTI_SELECT|BOOLEAN|DATE)$", message = "Invalid attribute type")
    private String type;

    @Size(max = 500, message = "Description must not exceed 500 characters")
    private String description;

    @NotNull(message = "Required status is required")
    private Boolean required;

    @NotNull(message = "Filterable status is required")
    private Boolean filterable;

    @NotNull(message = "Searchable status is required")
    private Boolean searchable;

    private List<String> options;

    @AssertTrue(message = "Options are required for SELECT and MULTI_SELECT types")
    public boolean isOptionsValid() {
        if (type.equals("SELECT") || type.equals("MULTI_SELECT")) {
            return options != null && !options.isEmpty();
        }
        return true;
    }

    @AssertTrue(message = "Options must be unique")
    public boolean isOptionsUnique() {
        if (options == null) {
            return true;
        }
        return options.stream().distinct().count() == options.size();
    }
} 