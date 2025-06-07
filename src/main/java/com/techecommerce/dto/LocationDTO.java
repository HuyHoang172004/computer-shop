package com.techecommerce.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class LocationDTO {
    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @NotBlank(message = "Code is required")
    @Pattern(regexp = "^[A-Z0-9]{2,10}$", message = "Code must contain only uppercase letters and numbers, between 2 and 10 characters")
    private String code;

    @NotBlank(message = "Type is required")
    @Pattern(regexp = "^(COUNTRY|PROVINCE|DISTRICT|WARD)$", message = "Invalid location type")
    private String type;

    private Long parentId;

    @NotNull(message = "Active status is required")
    private Boolean active;

    @Size(max = 500, message = "Description must not exceed 500 characters")
    private String description;

    @AssertTrue(message = "Parent location must be different from current location")
    public boolean isParentValid() {
        return parentId == null || !parentId.equals(getId());
    }

    @AssertTrue(message = "Parent location type must be valid")
    public boolean isParentTypeValid() {
        if (parentId == null) {
            return type.equals("COUNTRY");
        }
        switch (type) {
            case "PROVINCE":
                return true; // Parent is country
            case "DISTRICT":
                return true; // Parent is province
            case "WARD":
                return true; // Parent is district
            default:
                return false;
        }
    }
} 