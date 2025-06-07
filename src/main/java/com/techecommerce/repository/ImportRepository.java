package com.techecommerce.repository;

import com.techecommerce.model.Import;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ImportRepository extends JpaRepository<Import, Long> {
    List<Import> findByProductId(Long productId);
    List<Import> findByImportDateBetween(LocalDateTime startDate, LocalDateTime endDate);
    List<Import> findBySupplierName(String supplierName);
} 