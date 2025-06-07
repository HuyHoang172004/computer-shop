package com.techecommerce.controller;

import com.techecommerce.model.Comment;
import com.techecommerce.service.CommentService;
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
@RequestMapping("/api/comments")
@Tag(name = "Comment", description = "Comment management APIs")
@SecurityRequirement(name = "bearerAuth")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/product/{productId}")
    @Operation(summary = "Get comments by product ID")
    public ResponseEntity<Page<Comment>> getCommentsByProduct(
            @Parameter(description = "Product ID") @PathVariable Long productId,
            Pageable pageable) {
        return ResponseEntity.ok(commentService.getCommentsByProduct(productId, pageable));
    }

    @GetMapping("/user/{userId}")
    @Operation(summary = "Get comments by user ID")
    public ResponseEntity<Page<Comment>> getCommentsByUser(
            @Parameter(description = "User ID") @PathVariable Long userId,
            Pageable pageable) {
        return ResponseEntity.ok(commentService.getCommentsByUser(userId, pageable));
    }

    @GetMapping("/parent/{parentId}")
    @Operation(summary = "Get replies by parent comment ID")
    public ResponseEntity<Page<Comment>> getRepliesByParent(
            @Parameter(description = "Parent comment ID") @PathVariable Long parentId,
            Pageable pageable) {
        return ResponseEntity.ok(commentService.getRepliesByParent(parentId, pageable));
    }

    @PostMapping("/product/{productId}")
    @PreAuthorize("hasRole('USER')")
    @Operation(summary = "Create a new comment")
    public ResponseEntity<Comment> createComment(
            @Parameter(description = "Product ID") @PathVariable Long productId,
            @Valid @RequestBody Comment comment,
            @RequestParam(required = false) Long parentId,
            @CurrentUser UserPrincipal currentUser) {
        return ResponseEntity.ok(commentService.createComment(comment, productId, currentUser.getId(), parentId));
    }

    @PutMapping("/{commentId}")
    @PreAuthorize("hasRole('USER')")
    @Operation(summary = "Update a comment")
    public ResponseEntity<Comment> updateComment(
            @Parameter(description = "Comment ID") @PathVariable Long commentId,
            @Valid @RequestBody Comment comment,
            @CurrentUser UserPrincipal currentUser) {
        return ResponseEntity.ok(commentService.updateComment(commentId, comment, currentUser.getId()));
    }

    @DeleteMapping("/{commentId}")
    @PreAuthorize("hasRole('USER')")
    @Operation(summary = "Delete a comment")
    public ResponseEntity<Void> deleteComment(
            @Parameter(description = "Comment ID") @PathVariable Long commentId,
            @CurrentUser UserPrincipal currentUser) {
        commentService.deleteComment(commentId, currentUser.getId());
        return ResponseEntity.ok().build();
    }
} 