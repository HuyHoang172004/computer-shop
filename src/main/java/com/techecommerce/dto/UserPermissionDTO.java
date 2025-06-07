package com.techecommerce.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.util.List;

@Data
public class UserPermissionDTO {
    @NotNull(message = "User ID is required")
    private Long userId;

    @NotEmpty(message = "Permission IDs are required")
    private List<Long> permissionIds;

    @AssertTrue(message = "Permission IDs must be unique")
    public boolean isPermissionIdsUnique() {
        if (permissionIds == null) {
            return true;
        }
        return permissionIds.stream().distinct().count() == permissionIds.size();
    }
} 