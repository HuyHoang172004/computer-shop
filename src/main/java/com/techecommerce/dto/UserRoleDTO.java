package com.techecommerce.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.util.List;

@Data
public class UserRoleDTO {
    @NotNull(message = "User ID is required")
    private Long userId;

    @NotEmpty(message = "Role IDs are required")
    private List<Long> roleIds;

    @AssertTrue(message = "Role IDs must be unique")
    public boolean isRoleIdsUnique() {
        if (roleIds == null) {
            return true;
        }
        return roleIds.stream().distinct().count() == roleIds.size();
    }
} 