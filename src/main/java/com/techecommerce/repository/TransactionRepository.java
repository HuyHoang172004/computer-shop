package com.techecommerce.repository;

import com.techecommerce.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByOrderId(Long orderId);
    List<Transaction> findByType(String type);
    List<Transaction> findByStatus(String status);
    List<Transaction> findByPaymentMethod(String paymentMethod);
} 