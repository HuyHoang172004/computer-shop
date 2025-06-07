package com.techecommerce.service;

import com.techecommerce.model.Comment;
import com.techecommerce.model.Product;
import com.techecommerce.model.User;
import com.techecommerce.repository.CommentRepository;
import com.techecommerce.repository.ProductRepository;
import com.techecommerce.exception.ResourceNotFoundException;
import com.techecommerce.exception.BadRequestException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final ProductRepository productRepository;

    public CommentService(CommentRepository commentRepository,
                         ProductRepository productRepository) {
        this.commentRepository = commentRepository;
        this.productRepository = productRepository;
    }

    public Page<Comment> getCommentsByProduct(Long productId, Pageable pageable) {
        return commentRepository.findByProductId(productId, pageable);
    }

    public Page<Comment> getCommentsByUser(Long userId, Pageable pageable) {
        return commentRepository.findByUserId(userId, pageable);
    }

    public Page<Comment> getRepliesByParent(Long parentId, Pageable pageable) {
        return commentRepository.findByParentId(parentId, pageable);
    }

    @Transactional
    public Comment createComment(Comment comment, Long productId, Long userId, Long parentId) {
        // Kiểm tra sản phẩm tồn tại
        Product product = productRepository.findById(productId)
            .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        // Nếu là reply, kiểm tra comment cha tồn tại
        if (parentId != null) {
            Comment parentComment = commentRepository.findById(parentId)
                .orElseThrow(() -> new ResourceNotFoundException("Parent comment not found"));
            
            // Kiểm tra comment cha thuộc cùng sản phẩm
            if (!parentComment.getProduct().getId().equals(productId)) {
                throw new BadRequestException("Parent comment does not belong to the same product");
            }
            
            comment.setParent(parentComment);
        }

        comment.setProduct(product);
        comment.setUser(new User(userId));
        return commentRepository.save(comment);
    }

    @Transactional
    public Comment updateComment(Long commentId, Comment commentDetails, Long userId) {
        Comment comment = commentRepository.findById(commentId)
            .orElseThrow(() -> new ResourceNotFoundException("Comment not found"));

        // Kiểm tra quyền sở hữu
        if (!comment.getUser().getId().equals(userId)) {
            throw new BadRequestException("You can only update your own comments");
        }

        comment.setContent(commentDetails.getContent());
        return commentRepository.save(comment);
    }

    @Transactional
    public void deleteComment(Long commentId, Long userId) {
        Comment comment = commentRepository.findById(commentId)
            .orElseThrow(() -> new ResourceNotFoundException("Comment not found"));

        // Kiểm tra quyền sở hữu
        if (!comment.getUser().getId().equals(userId)) {
            throw new BadRequestException("You can only delete your own comments");
        }

        // Xóa tất cả các reply của comment này
        List<Comment> replies = commentRepository.findByParentId(commentId);
        commentRepository.deleteAll(replies);

        // Xóa comment
        commentRepository.delete(comment);
    }
} 