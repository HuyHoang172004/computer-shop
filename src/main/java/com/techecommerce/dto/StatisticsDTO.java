package com.techecommerce.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class StatisticsDTO {
    @NotNull(message = "Start date is required")
    private LocalDateTime startDate;

    @NotNull(message = "End date is required")
    private LocalDateTime endDate;

    @Pattern(regexp = "^(DAILY|WEEKLY|MONTHLY|YEARLY)$", message = "Invalid time unit")
    private String timeUnit;

    @Pattern(regexp = "^(REVENUE|ORDERS|PRODUCTS|USERS)$", message = "Invalid statistics type")
    private String type;

    private List<Long> categoryIds;

    private List<Long> brandIds;

    @AssertTrue(message = "End date must be after start date")
    public boolean isEndDateAfterStartDate() {
        return endDate.isAfter(startDate);
    }

    @AssertTrue(message = "Date range must not exceed 1 year")
    public boolean isDateRangeValid() {
        return endDate.minusYears(1).isBefore(startDate);
    }
} 