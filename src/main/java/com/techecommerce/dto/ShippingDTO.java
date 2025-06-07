package com.techecommerce.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ShippingDTO {
    @NotNull(message = "Order ID is required")
    private Long orderId;

    @NotBlank(message = "Shipping method is required")
    @Pattern(regexp = "^(STANDARD|EXPRESS|SAME_DAY)$", message = "Invalid shipping method")
    private String shippingMethod;

    @NotNull(message = "From location ID is required")
    private Long fromLocationId;

    @NotNull(message = "To location ID is required")
    private Long toLocationId;

    @NotBlank(message = "Shipping address is required")
    @Size(max = 200, message = "Shipping address must not exceed 200 characters")
    private String shippingAddress;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Invalid phone number format")
    private String phone;

    @NotBlank(message = "Recipient name is required")
    @Size(max = 100, message = "Recipient name must not exceed 100 characters")
    private String recipientName;

    @Size(max = 500, message = "Note must not exceed 500 characters")
    private String note;

    @AssertTrue(message = "From and to locations must be different")
    public boolean isLocationsDifferent() {
        return !fromLocationId.equals(toLocationId);
    }
} 