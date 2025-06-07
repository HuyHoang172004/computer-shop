package com.techecommerce.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ApiLogDTO {
    @NotBlank(message = "API key is required")
    private String apiKey;

    @NotBlank(message = "Endpoint is required")
    @Size(max = 500, message = "Endpoint must not exceed 500 characters")
    private String endpoint;

    @NotBlank(message = "Method is required")
    @Pattern(regexp = "^(GET|POST|PUT|DELETE|PATCH)$", message = "Invalid HTTP method")
    private String method;

    @NotNull(message = "Status code is required")
    @Min(value = 100, message = "Status code must be at least 100")
    @Max(value = 599, message = "Status code cannot exceed 599")
    private Integer statusCode;

    @Size(max = 1000, message = "Request body must not exceed 1000 characters")
    private String requestBody;

    @Size(max = 1000, message = "Response body must not exceed 1000 characters")
    private String responseBody;

    @NotNull(message = "Timestamp is required")
    private LocalDateTime timestamp;

    @Size(max = 100, message = "IP address must not exceed 100 characters")
    private String ipAddress;

    @Size(max = 500, message = "User agent must not exceed 500 characters")
    private String userAgent;

    @Min(value = 0, message = "Response time must be at least 0")
    private Long responseTime;

    @Size(max = 500, message = "Error message must not exceed 500 characters")
    private String errorMessage;
} 