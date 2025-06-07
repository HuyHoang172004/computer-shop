package com.techecommerce.controller;

import com.techecommerce.model.Review;
import com.techecommerce.service.ReviewService;
import com.techecommerce.security.CurrentUser;
import com.techecommerce.security.UserPrincipal;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/reviews")
@Tag(name = "Review", description = "Review management APIs")
@SecurityRequirement(name = "bearerAuth")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/product/{productId}")
    @Operation(summary = "Get reviews by product ID")
    public ResponseEntity<Page<Review>> getReviewsByProduct(
            @Parameter(description = "Product ID") @PathVariable Long productId,
            Pageable pageable) {
        return ResponseEntity.ok(reviewService.getReviewsByProduct(productId, pageable));
    }

    @GetMapping("/user/{userId}")
    @Operation(summary = "Get reviews by user ID")
    public ResponseEntity<Page<Review>> getReviewsByUser(
            @Parameter(description = "User ID") @PathVariable Long userId,
            Pageable pageable) {
        return ResponseEntity.ok(reviewService.getReviewsByUser(userId, pageable));
    }

    @PostMapping("/product/{productId}")
    @PreAuthorize("hasRole('USER')")
    @Operation(summary = "Create a new review")
    public ResponseEntity<Review> createReview(
            @Parameter(description = "Product ID") @PathVariable Long productId,
            @Valid @RequestBody Review review,
            @CurrentUser UserPrincipal currentUser) {
        return ResponseEntity.ok(reviewService.createReview(review, productId, currentUser.getId()));
    }

    @PutMapping("/{reviewId}")
    @PreAuthorize("hasRole('USER')")
    @Operation(summary = "Update a review")
    public ResponseEntity<Review> updateReview(
            @Parameter(description = "Review ID") @PathVariable Long reviewId,
            @Valid @RequestBody Review review,
            @CurrentUser UserPrincipal currentUser) {
        return ResponseEntity.ok(reviewService.updateReview(reviewId, review, currentUser.getId()));
    }

    @DeleteMapping("/{reviewId}")
    @PreAuthorize("hasRole('USER')")
    @Operation(summary = "Delete a review")
    public ResponseEntity<Void> deleteReview(
            @Parameter(description = "Review ID") @PathVariable Long reviewId,
            @CurrentUser UserPrincipal currentUser) {
        reviewService.deleteReview(reviewId, currentUser.getId());
        return ResponseEntity.ok().build();
    }
} 