package com.techecommerce.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ApiKeyDTO {
    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @Size(max = 500, message = "Description must not exceed 500 characters")
    private String description;

    @NotNull(message = "Expiry date is required")
    private LocalDateTime expiryDate;

    @Pattern(regexp = "^(READ|WRITE|ADMIN)$", message = "Invalid permission level")
    private String permissionLevel;

    @Size(max = 500, message = "IP whitelist must not exceed 500 characters")
    private String ipWhitelist;

    @NotNull(message = "Active status is required")
    private Boolean active;

    @AssertTrue(message = "Expiry date must be in the future")
    public boolean isExpiryDateValid() {
        return expiryDate.isAfter(LocalDateTime.now());
    }

    @AssertTrue(message = "IP whitelist must contain valid IP addresses")
    public boolean isIpWhitelistValid() {
        if (ipWhitelist == null || ipWhitelist.isEmpty()) {
            return true;
        }
        // Add IP address validation
        return true;
    }
} 