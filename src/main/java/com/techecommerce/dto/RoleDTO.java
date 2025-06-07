package com.techecommerce.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.util.List;

@Data
public class RoleDTO {
    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @NotBlank(message = "Code is required")
    @Pattern(regexp = "^[A-Z_]{3,50}$", message = "Code must contain only uppercase letters and underscores, between 3 and 50 characters")
    private String code;

    @Size(max = 500, message = "Description must not exceed 500 characters")
    private String description;

    private List<Long> permissionIds;

    @NotNull(message = "Active status is required")
    private Boolean active;

    @AssertTrue(message = "Permission IDs must be unique")
    public boolean isPermissionIdsUnique() {
        if (permissionIds == null) {
            return true;
        }
        return permissionIds.stream().distinct().count() == permissionIds.size();
    }
} 