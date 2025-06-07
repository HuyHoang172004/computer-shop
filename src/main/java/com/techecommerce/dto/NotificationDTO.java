package com.techecommerce.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class NotificationDTO {
    @NotBlank(message = "Title is required")
    @Size(min = 2, max = 100, message = "Title must be between 2 and 100 characters")
    private String title;

    @NotBlank(message = "Content is required")
    @Size(min = 2, max = 1000, message = "Content must be between 2 and 1000 characters")
    private String content;

    @NotBlank(message = "Type is required")
    @Pattern(regexp = "^(ORDER|PROMOTION|SYSTEM|ACCOUNT)$", message = "Invalid notification type")
    private String type;

    @Size(max = 200, message = "Image URL must not exceed 200 characters")
    private String imageUrl;

    @Size(max = 200, message = "Link must not exceed 200 characters")
    @Pattern(regexp = "^(https?://)?([\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?$", message = "Invalid link format")
    private String link;

    @NotNull(message = "Priority is required")
    @Min(value = 1, message = "Priority must be at least 1")
    @Max(value = 5, message = "Priority cannot exceed 5")
    private Integer priority;

    @NotNull(message = "Active status is required")
    private Boolean active;
} 