package com.techecommerce.controller;

import com.techecommerce.model.Order;
import com.techecommerce.service.OrderService;
import com.techecommerce.security.CurrentUser;
import com.techecommerce.security.UserPrincipal;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
@Tag(name = "Order", description = "Order management APIs")
@SecurityRequirement(name = "bearerAuth")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/user/{userId}")
    @PreAuthorize("hasRole('USER')")
    @Operation(summary = "Get orders by user ID")
    public ResponseEntity<Page<Order>> getOrdersByUser(
            @Parameter(description = "User ID") @PathVariable Long userId,
            Pageable pageable) {
        return ResponseEntity.ok(orderService.getOrdersByUser(userId, pageable));
    }

    @GetMapping("/status/{status}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Get orders by status")
    public ResponseEntity<Page<Order>> getOrdersByStatus(
            @Parameter(description = "Order status") @PathVariable String status,
            Pageable pageable) {
        return ResponseEntity.ok(orderService.getOrdersByStatus(status, pageable));
    }

    @GetMapping("/date-range")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Get orders by date range")
    public ResponseEntity<Page<Order>> getOrdersByDateRange(
            @Parameter(description = "Start date") @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @Parameter(description = "End date") @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate,
            Pageable pageable) {
        return ResponseEntity.ok(orderService.getOrdersByDateRange(startDate, endDate, pageable));
    }

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    @Operation(summary = "Create a new order")
    public ResponseEntity<Order> createOrder(
            @Valid @RequestBody Order order,
            @CurrentUser UserPrincipal currentUser) {
        return ResponseEntity.ok(orderService.createOrder(order, currentUser.getId()));
    }

    @PutMapping("/{orderId}/status")
    @PreAuthorize("hasRole('USER')")
    @Operation(summary = "Update order status")
    public ResponseEntity<Order> updateOrderStatus(
            @Parameter(description = "Order ID") @PathVariable Long orderId,
            @Parameter(description = "New status") @RequestParam String status,
            @CurrentUser UserPrincipal currentUser) {
        return ResponseEntity.ok(orderService.updateOrderStatus(orderId, status, currentUser.getId()));
    }

    @PostMapping("/{orderId}/cancel")
    @PreAuthorize("hasRole('USER')")
    @Operation(summary = "Cancel an order")
    public ResponseEntity<Void> cancelOrder(
            @Parameter(description = "Order ID") @PathVariable Long orderId,
            @CurrentUser UserPrincipal currentUser) {
        orderService.cancelOrder(orderId, currentUser.getId());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/statistics")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Get order statistics")
    public ResponseEntity<Map<String, Object>> getOrderStatistics(
            @Parameter(description = "Start date") @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @Parameter(description = "End date") @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
        return ResponseEntity.ok(orderService.getOrderStatistics(startDate, endDate));
    }
} 