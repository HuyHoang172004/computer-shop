package com.techecommerce.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class EmailTemplateDTO {
    @NotBlank(message = "Code is required")
    @Pattern(regexp = "^[A-Z_]{3,50}$", message = "Code must contain only uppercase letters and underscores, between 3 and 50 characters")
    private String code;

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @NotBlank(message = "Subject is required")
    @Size(min = 2, max = 200, message = "Subject must be between 2 and 200 characters")
    private String subject;

    @NotBlank(message = "Content is required")
    @Size(min = 2, max = 5000, message = "Content must be between 2 and 5000 characters")
    private String content;

    @Size(max = 500, message = "Description must not exceed 500 characters")
    private String description;

    @NotNull(message = "Active status is required")
    private Boolean active;

    @AssertTrue(message = "Content must contain valid Thymeleaf expressions")
    public boolean isContentValid() {
        if (content == null) {
            return false;
        }
        // Add Thymeleaf expression validation if needed
        return true;
    }
} 