package com.techecommerce.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.util.List;

@Data
public class ImportDTO {
    @NotEmpty(message = "Import items are required")
    @Valid
    private List<ImportItemDTO> importItems;

    @NotBlank(message = "Supplier name is required")
    @Size(max = 100, message = "Supplier name must not exceed 100 characters")
    private String supplierName;

    @NotBlank(message = "Invoice number is required")
    @Size(max = 50, message = "Invoice number must not exceed 50 characters")
    private String invoiceNumber;

    @NotNull(message = "Import date is required")
    private String importDate;

    @Size(max = 500, message = "Note must not exceed 500 characters")
    private String note;

    @Data
    public static class ImportItemDTO {
        @NotNull(message = "Product ID is required")
        private Long productId;

        @NotNull(message = "Quantity is required")
        @Min(value = 1, message = "Quantity must be at least 1")
        @Max(value = 1000, message = "Quantity cannot exceed 1000")
        private Integer quantity;

        @NotNull(message = "Import price is required")
        @DecimalMin(value = "0.0", inclusive = false, message = "Import price must be greater than 0")
        @DecimalMax(value = "1000000.0", message = "Import price cannot exceed 1,000,000")
        private Double importPrice;
    }
} 