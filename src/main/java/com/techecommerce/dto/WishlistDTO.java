package com.techecommerce.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.util.List;

@Data
public class WishlistDTO {
    @NotEmpty(message = "Product IDs are required")
    @Size(max = 100, message = "Maximum 100 products allowed in wishlist")
    private List<Long> productIds;
} 