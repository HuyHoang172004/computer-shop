package com.techecommerce.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CategoryDTO {
    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @Size(max = 500, message = "Description must not exceed 500 characters")
    private String description;

    @Pattern(regexp = "^[a-z0-9-]+$", message = "Slug must contain only lowercase letters, numbers, and hyphens")
    @Size(min = 2, max = 50, message = "Slug must be between 2 and 50 characters")
    private String slug;

    private Long parentId;

    @Size(max = 200, message = "Image URL must not exceed 200 characters")
    private String imageUrl;

    @AssertTrue(message = "Parent category must be different from current category")
    public boolean isParentValid() {
        return parentId == null || !parentId.equals(getId());
    }
} 