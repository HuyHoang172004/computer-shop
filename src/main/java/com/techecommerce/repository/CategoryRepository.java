package com.techecommerce.repository;

import com.techecommerce.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByActive(boolean active);
    List<Category> findByParentId(Long parentId);
    boolean existsByName(String name);
} 