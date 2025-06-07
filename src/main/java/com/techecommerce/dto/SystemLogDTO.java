package com.techecommerce.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class SystemLogDTO {
    @NotBlank(message = "Level is required")
    @Pattern(regexp = "^(INFO|WARN|ERROR|DEBUG)$", message = "Invalid log level")
    private String level;

    @NotBlank(message = "Message is required")
    @Size(max = 1000, message = "Message must not exceed 1000 characters")
    private String message;

    @Size(max = 500, message = "Source must not exceed 500 characters")
    private String source;

    @Size(max = 500, message = "Stack trace must not exceed 500 characters")
    private String stackTrace;

    @NotNull(message = "Timestamp is required")
    private LocalDateTime timestamp;

    private Long userId;

    @Size(max = 500, message = "User agent must not exceed 500 characters")
    private String userAgent;

    @Size(max = 100, message = "IP address must not exceed 100 characters")
    private String ipAddress;

    @Size(max = 500, message = "Request URL must not exceed 500 characters")
    private String requestUrl;

    @Size(max = 50, message = "Request method must not exceed 50 characters")
    private String requestMethod;

    @Size(max = 1000, message = "Request body must not exceed 1000 characters")
    private String requestBody;

    @Size(max = 1000, message = "Response body must not exceed 1000 characters")
    private String responseBody;

    @Min(value = 0, message = "Response time must be at least 0")
    private Long responseTime;
} 