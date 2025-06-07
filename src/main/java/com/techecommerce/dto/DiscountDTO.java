package com.techecommerce.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class DiscountDTO {
    @NotBlank(message = "Code is required")
    @Pattern(regexp = "^[A-Z0-9]{3,20}$", message = "Code must contain only uppercase letters and numbers, between 3 and 20 characters")
    private String code;

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @Size(max = 500, message = "Description must not exceed 500 characters")
    private String description;

    @NotNull(message = "Discount type is required")
    @Pattern(regexp = "^(PERCENTAGE|FIXED_AMOUNT)$", message = "Invalid discount type")
    private String type;

    @NotNull(message = "Value is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Value must be greater than 0")
    @DecimalMax(value = "100.0", message = "Value cannot exceed 100 for percentage type")
    private Double value;

    @NotNull(message = "Start date is required")
    private LocalDateTime startDate;

    @NotNull(message = "End date is required")
    private LocalDateTime endDate;

    @Min(value = 0, message = "Minimum order amount must be at least 0")
    private Double minOrderAmount;

    @Min(value = 1, message = "Maximum uses must be at least 1")
    private Integer maxUses;

    @Min(value = 1, message = "Maximum uses per user must be at least 1")
    private Integer maxUsesPerUser;

    @NotNull(message = "Active status is required")
    private Boolean active;

    @AssertTrue(message = "End date must be after start date")
    public boolean isEndDateAfterStartDate() {
        return endDate.isAfter(startDate);
    }

    @AssertTrue(message = "Value must be between 0 and 100 for percentage type")
    public boolean isValueValidForType() {
        if (type.equals("PERCENTAGE")) {
            return value > 0 && value <= 100;
        }
        return value > 0;
    }
} 