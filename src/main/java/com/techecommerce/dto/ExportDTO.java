package com.techecommerce.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.util.List;

@Data
public class ExportDTO {
    @NotBlank(message = "Type is required")
    @Pattern(regexp = "^(PRODUCT|ORDER|USER|CATEGORY|BRAND)$", message = "Invalid export type")
    private String type;

    @Pattern(regexp = "^(CSV|EXCEL|PDF)$", message = "Invalid export format")
    private String format;

    private List<Long> ids;

    private List<String> fields;

    @Size(max = 500, message = "File name must not exceed 500 characters")
    private String fileName;

    @Size(max = 500, message = "Description must not exceed 500 characters")
    private String description;

    @AssertTrue(message = "Fields must be valid for the export type")
    public boolean isFieldsValid() {
        if (fields == null || fields.isEmpty()) {
            return true;
        }
        // Add field validation based on export type
        return true;
    }
} 