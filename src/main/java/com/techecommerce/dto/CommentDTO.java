package com.techecommerce.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CommentDTO {
    @NotNull(message = "Product ID is required")
    private Long productId;

    @NotBlank(message = "Content is required")
    @Size(min = 2, max = 1000, message = "Content must be between 2 and 1000 characters")
    private String content;

    @Size(max = 5, message = "Maximum 5 images allowed")
    private String[] images;

    private Long parentId;

    @AssertTrue(message = "Parent comment must be different from current comment")
    public boolean isParentValid() {
        return parentId == null || !parentId.equals(getId());
    }
} 