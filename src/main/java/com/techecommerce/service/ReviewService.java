package com.techecommerce.service;

import com.techecommerce.model.Review;
import com.techecommerce.model.Product;
import com.techecommerce.model.User;
import com.techecommerce.repository.ReviewRepository;
import com.techecommerce.repository.ProductRepository;
import com.techecommerce.repository.OrderRepository;
import com.techecommerce.exception.ResourceNotFoundException;
import com.techecommerce.exception.BadRequestException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public ReviewService(ReviewRepository reviewRepository,
                        ProductRepository productRepository,
                        OrderRepository orderRepository) {
        this.reviewRepository = reviewRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    public Page<Review> getReviewsByProduct(Long productId, Pageable pageable) {
        return reviewRepository.findByProductId(productId, pageable);
    }

    public Page<Review> getReviewsByUser(Long userId, Pageable pageable) {
        return reviewRepository.findByUserId(userId, pageable);
    }

    @Transactional
    public Review createReview(Review review, Long productId, Long userId) {
        // Kiểm tra sản phẩm tồn tại
        Product product = productRepository.findById(productId)
            .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        // Kiểm tra người dùng đã mua sản phẩm chưa
        boolean hasPurchased = orderRepository.existsByUserIdAndProductId(userId, productId);
        if (!hasPurchased) {
            throw new BadRequestException("You must purchase this product before reviewing");
        }

        // Kiểm tra người dùng đã đánh giá sản phẩm này chưa
        Optional<Review> existingReview = reviewRepository.findByProductIdAndUserId(productId, userId);
        if (existingReview.isPresent()) {
            throw new BadRequestException("You have already reviewed this product");
        }

        // Lưu đánh giá
        review.setProduct(product);
        review.setUser(new User(userId));
        Review savedReview = reviewRepository.save(review);

        // Cập nhật rating trung bình của sản phẩm
        updateProductRating(productId);

        return savedReview;
    }

    @Transactional
    public Review updateReview(Long reviewId, Review reviewDetails, Long userId) {
        Review review = reviewRepository.findById(reviewId)
            .orElseThrow(() -> new ResourceNotFoundException("Review not found"));

        // Kiểm tra quyền sở hữu
        if (!review.getUser().getId().equals(userId)) {
            throw new BadRequestException("You can only update your own reviews");
        }

        review.setRating(reviewDetails.getRating());
        review.setComment(reviewDetails.getComment());
        Review updatedReview = reviewRepository.save(review);

        // Cập nhật rating trung bình của sản phẩm
        updateProductRating(review.getProduct().getId());

        return updatedReview;
    }

    @Transactional
    public void deleteReview(Long reviewId, Long userId) {
        Review review = reviewRepository.findById(reviewId)
            .orElseThrow(() -> new ResourceNotFoundException("Review not found"));

        // Kiểm tra quyền sở hữu
        if (!review.getUser().getId().equals(userId)) {
            throw new BadRequestException("You can only delete your own reviews");
        }

        Long productId = review.getProduct().getId();
        reviewRepository.delete(review);

        // Cập nhật rating trung bình của sản phẩm
        updateProductRating(productId);
    }

    private void updateProductRating(Long productId) {
        List<Review> reviews = reviewRepository.findByProductId(productId);
        if (!reviews.isEmpty()) {
            double averageRating = reviews.stream()
                .mapToDouble(Review::getRating)
                .average()
                .orElse(0.0);

            Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
            product.setRating(averageRating);
            productRepository.save(product);
        }
    }
} 