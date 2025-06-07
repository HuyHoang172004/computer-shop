package com.techecommerce.repository;

import com.techecommerce.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByProductId(Long productId);
    List<Comment> findByUserId(Long userId);
    List<Comment> findByParentId(Long parentId);
} 