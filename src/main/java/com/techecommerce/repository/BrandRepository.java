package com.techecommerce.repository;

import com.techecommerce.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
    List<Brand> findByActive(boolean active);
    boolean existsByName(String name);
} 