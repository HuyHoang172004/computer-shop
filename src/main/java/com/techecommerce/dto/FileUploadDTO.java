package com.techecommerce.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class FileUploadDTO {
    @NotNull(message = "File is required")
    private MultipartFile file;

    @NotBlank(message = "Type is required")
    @Pattern(regexp = "^(PRODUCT|CATEGORY|BRAND|USER|REVIEW)$", message = "Invalid file type")
    private String type;

    @Size(max = 500, message = "Description must not exceed 500 characters")
    private String description;

    @AssertTrue(message = "File size must not exceed 5MB")
    public boolean isFileSizeValid() {
        return file != null && file.getSize() <= 5 * 1024 * 1024; // 5MB
    }

    @AssertTrue(message = "File type must be an image")
    public boolean isFileTypeValid() {
        if (file == null) {
            return false;
        }
        String contentType = file.getContentType();
        return contentType != null && contentType.startsWith("image/");
    }
} 