package com.techecommerce.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UserAddressDTO {
    @NotNull(message = "User ID is required")
    private Long userId;

    @NotBlank(message = "Full name is required")
    @Size(min = 2, max = 100, message = "Full name must be between 2 and 100 characters")
    private String fullName;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^[0-9]{10,15}$", message = "Invalid phone number")
    private String phone;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Address is required")
    @Size(max = 500, message = "Address must not exceed 500 characters")
    private String address;

    @NotNull(message = "City ID is required")
    private Long cityId;

    @NotNull(message = "District ID is required")
    private Long districtId;

    @NotNull(message = "Ward ID is required")
    private Long wardId;

    @Size(max = 20, message = "Postal code must not exceed 20 characters")
    private String postalCode;

    @NotNull(message = "Is default flag is required")
    private Boolean isDefault;

    @Size(max = 500, message = "Note must not exceed 500 characters")
    private String note;

    @NotNull(message = "Active flag is required")
    private Boolean active;
} 