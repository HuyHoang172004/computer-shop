package com.techecommerce.service;

import com.techecommerce.model.Order;
import com.techecommerce.model.OrderItem;
import com.techecommerce.model.Product;
import com.techecommerce.model.User;
import com.techecommerce.repository.OrderRepository;
import com.techecommerce.repository.ProductRepository;
import com.techecommerce.exception.ResourceNotFoundException;
import com.techecommerce.exception.BadRequestException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final EmailService emailService;

    public OrderService(OrderRepository orderRepository,
                       ProductRepository productRepository,
                       EmailService emailService) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.emailService = emailService;
    }

    public Page<Order> getOrdersByUser(Long userId, Pageable pageable) {
        return orderRepository.findByUserId(userId, pageable);
    }

    public Page<Order> getOrdersByStatus(String status, Pageable pageable) {
        return orderRepository.findByStatus(status, pageable);
    }

    public Page<Order> getOrdersByDateRange(LocalDateTime startDate, LocalDateTime endDate, Pageable pageable) {
        return orderRepository.findByCreatedAtBetween(startDate, endDate, pageable);
    }

    @Transactional
    public Order createOrder(Order order, Long userId) {
        // Kiểm tra tồn kho và tính toán tổng tiền
        validateAndCalculateOrder(order);

        // Lưu đơn hàng
        order.setUser(new User(userId));
        order.setStatus("PENDING");
        order.setCreatedAt(LocalDateTime.now());
        Order savedOrder = orderRepository.save(order);

        // Cập nhật tồn kho
        updateProductStock(order);

        // Gửi email xác nhận
        emailService.sendOrderStatusUpdateEmail(
            order.getUser().getEmail(),
            order.getUser().getName(),
            order.getId().toString(),
            "PENDING",
            "http://localhost:3000/orders/" + order.getId()
        );

        return savedOrder;
    }

    @Transactional
    public Order updateOrderStatus(Long orderId, String status, Long userId) {
        Order order = orderRepository.findById(orderId)
            .orElseThrow(() -> new ResourceNotFoundException("Order not found"));

        // Kiểm tra quyền cập nhật
        if (!order.getUser().getId().equals(userId)) {
            throw new BadRequestException("You can only update your own orders");
        }

        // Cập nhật trạng thái
        order.setStatus(status);
        order.setUpdatedAt(LocalDateTime.now());
        Order updatedOrder = orderRepository.save(order);

        // Gửi email thông báo
        emailService.sendOrderStatusUpdateEmail(
            order.getUser().getEmail(),
            order.getUser().getName(),
            order.getId().toString(),
            status,
            "http://localhost:3000/orders/" + order.getId()
        );

        return updatedOrder;
    }

    @Transactional
    public void cancelOrder(Long orderId, Long userId) {
        Order order = orderRepository.findById(orderId)
            .orElseThrow(() -> new ResourceNotFoundException("Order not found"));

        // Kiểm tra quyền hủy
        if (!order.getUser().getId().equals(userId)) {
            throw new BadRequestException("You can only cancel your own orders");
        }

        // Kiểm tra trạng thái đơn hàng
        if (!order.getStatus().equals("PENDING")) {
            throw new BadRequestException("Can only cancel pending orders");
        }

        // Hoàn trả tồn kho
        restoreProductStock(order);

        // Cập nhật trạng thái
        order.setStatus("CANCELLED");
        order.setUpdatedAt(LocalDateTime.now());
        orderRepository.save(order);

        // Gửi email thông báo
        emailService.sendOrderStatusUpdateEmail(
            order.getUser().getEmail(),
            order.getUser().getName(),
            order.getId().toString(),
            "CANCELLED",
            "http://localhost:3000/orders/" + order.getId()
        );
    }

    public Map<String, Object> getOrderStatistics(LocalDateTime startDate, LocalDateTime endDate) {
        List<Order> orders = orderRepository.findByCreatedAtBetween(startDate, endDate);
        
        Map<String, Object> statistics = new HashMap<>();
        BigDecimal totalRevenue = BigDecimal.ZERO;
        int totalOrders = 0;
        Map<String, Integer> statusStats = new HashMap<>();
        Map<Long, Integer> productStats = new HashMap<>();

        for (Order order : orders) {
            if (order.getStatus().equals("COMPLETED")) {
                totalRevenue = totalRevenue.add(order.getTotalAmount());
            }
            totalOrders++;

            // Thống kê theo trạng thái
            statusStats.merge(order.getStatus(), 1, Integer::sum);

            // Thống kê theo sản phẩm
            for (OrderItem item : order.getOrderItems()) {
                productStats.merge(item.getProduct().getId(), item.getQuantity(), Integer::sum);
            }
        }

        statistics.put("totalRevenue", totalRevenue);
        statistics.put("totalOrders", totalOrders);
        statistics.put("statusStats", statusStats);
        statistics.put("productStats", productStats);

        return statistics;
    }

    private void validateAndCalculateOrder(Order order) {
        BigDecimal totalAmount = BigDecimal.ZERO;

        for (OrderItem item : order.getOrderItems()) {
            Product product = productRepository.findById(item.getProduct().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

            // Kiểm tra tồn kho
            if (product.getStock() < item.getQuantity()) {
                throw new BadRequestException("Insufficient stock for product: " + product.getName());
            }

            // Tính toán giá
            item.setUnitPrice(product.getPrice());
            item.setTotalAmount(product.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
            totalAmount = totalAmount.add(item.getTotalAmount());
        }

        order.setTotalAmount(totalAmount);
    }

    private void updateProductStock(Order order) {
        for (OrderItem item : order.getOrderItems()) {
            Product product = item.getProduct();
            product.setStock(product.getStock() - item.getQuantity());
            productRepository.save(product);
        }
    }

    private void restoreProductStock(Order order) {
        for (OrderItem item : order.getOrderItems()) {
            Product product = item.getProduct();
            product.setStock(product.getStock() + item.getQuantity());
            productRepository.save(product);
        }
    }
} 