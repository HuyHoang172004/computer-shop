package com.techecommerce.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.util.List;

@Data
public class OrderDTO {
    @NotEmpty(message = "Order items are required")
    @Valid
    private List<OrderItemDTO> orderItems;

    @NotBlank(message = "Shipping address is required")
    @Size(max = 200, message = "Shipping address must not exceed 200 characters")
    private String shippingAddress;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Invalid phone number format")
    private String phone;

    @NotBlank(message = "Payment method is required")
    @Pattern(regexp = "^(CASH|CREDIT_CARD|BANK_TRANSFER)$", message = "Invalid payment method")
    private String paymentMethod;

    @Size(max = 500, message = "Note must not exceed 500 characters")
    private String note;

    @Data
    public static class OrderItemDTO {
        @NotNull(message = "Product ID is required")
        private Long productId;

        @NotNull(message = "Quantity is required")
        @Min(value = 1, message = "Quantity must be at least 1")
        @Max(value = 100, message = "Quantity cannot exceed 100")
        private Integer quantity;
    }
} 