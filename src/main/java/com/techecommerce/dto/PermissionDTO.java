package com.techecommerce.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class PermissionDTO {
    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @NotBlank(message = "Code is required")
    @Pattern(regexp = "^[A-Z_]{3,50}$", message = "Code must contain only uppercase letters and underscores, between 3 and 50 characters")
    private String code;

    @Size(max = 500, message = "Description must not exceed 500 characters")
    private String description;

    @NotBlank(message = "Module is required")
    @Size(min = 2, max = 50, message = "Module must be between 2 and 50 characters")
    private String module;

    @NotBlank(message = "Action is required")
    @Pattern(regexp = "^(CREATE|READ|UPDATE|DELETE|MANAGE)$", message = "Invalid action")
    private String action;

    @NotNull(message = "Active status is required")
    private Boolean active;
} 