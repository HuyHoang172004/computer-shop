package com.techecommerce.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class ReportDTO {
    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @NotBlank(message = "Type is required")
    @Pattern(regexp = "^(SALES|INVENTORY|USER|ORDER|PRODUCT)$", message = "Invalid report type")
    private String type;

    @NotNull(message = "Start date is required")
    private LocalDateTime startDate;

    @NotNull(message = "End date is required")
    private LocalDateTime endDate;

    @Pattern(regexp = "^(DAILY|WEEKLY|MONTHLY|YEARLY)$", message = "Invalid time unit")
    private String timeUnit;

    private List<Long> categoryIds;

    private List<Long> brandIds;

    @Pattern(regexp = "^(CSV|EXCEL|PDF)$", message = "Invalid export format")
    private String exportFormat;

    @Size(max = 500, message = "Description must not exceed 500 characters")
    private String description;

    @AssertTrue(message = "End date must be after start date")
    public boolean isEndDateAfterStartDate() {
        return endDate.isAfter(startDate);
    }

    @AssertTrue(message = "Date range must not exceed 1 year")
    public boolean isDateRangeValid() {
        return endDate.minusYears(1).isBefore(startDate);
    }
} 