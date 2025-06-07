package com.techecommerce.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UserNotificationDTO {
    @NotNull(message = "User ID is required")
    private Long userId;

    @NotBlank(message = "Type is required")
    @Pattern(regexp = "^(ORDER|PAYMENT|SHIPPING|SYSTEM|PROMOTION)$", message = "Invalid notification type")
    private String type;

    @NotBlank(message = "Title is required")
    @Size(min = 2, max = 200, message = "Title must be between 2 and 200 characters")
    private String title;

    @NotBlank(message = "Content is required")
    @Size(max = 1000, message = "Content must not exceed 1000 characters")
    private String content;

    @NotNull(message = "Is read flag is required")
    private Boolean isRead;

    @NotNull(message = "Is email sent flag is required")
    private Boolean isEmailSent;

    @NotNull(message = "Is push sent flag is required")
    private Boolean isPushSent;

    @Size(max = 500, message = "Link must not exceed 500 characters")
    private String link;

    @Size(max = 500, message = "Image URL must not exceed 500 characters")
    private String imageUrl;

    @Size(max = 500, message = "Note must not exceed 500 characters")
    private String note;

    @NotNull(message = "Active flag is required")
    private Boolean active;
} 