package com.techecommerce.service;

import com.techecommerce.model.Import;
import com.techecommerce.model.Product;
import com.techecommerce.repository.ImportRepository;
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
public class ImportService {
    private final ImportRepository importRepository;
    private final ProductRepository productRepository;

    public ImportService(ImportRepository importRepository,
                        ProductRepository productRepository) {
        this.importRepository = importRepository;
        this.productRepository = productRepository;
    }

    public Page<Import> getImportsByProduct(Long productId, Pageable pageable) {
        return importRepository.findByProductId(productId, pageable);
    }

    public Page<Import> getImportsByDateRange(LocalDateTime startDate, LocalDateTime endDate, Pageable pageable) {
        return importRepository.findByImportDateBetween(startDate, endDate, pageable);
    }

    public Page<Import> getImportsBySupplier(String supplierName, Pageable pageable) {
        return importRepository.findBySupplierName(supplierName, pageable);
    }

    @Transactional
    public Import createImport(Import importRecord) {
        // Kiểm tra sản phẩm tồn tại
        Product product = productRepository.findById(importRecord.getProduct().getId())
            .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        // Cập nhật tồn kho và giá sản phẩm
        updateProductStockAndPrice(product, importRecord);

        // Lưu lịch sử nhập hàng
        importRecord.setProduct(product);
        importRecord.setImportDate(LocalDateTime.now());
        return importRepository.save(importRecord);
    }

    @Transactional
    public Import updateImport(Long importId, Import importDetails) {
        Import importRecord = importRepository.findById(importId)
            .orElseThrow(() -> new ResourceNotFoundException("Import record not found"));

        // Hoàn tác thay đổi tồn kho và giá cũ
        Product product = importRecord.getProduct();
        product.setStock(product.getStock() - importRecord.getQuantity());
        product.setImportPrice(product.getImportPrice().subtract(importRecord.getTotalAmount()));

        // Cập nhật thông tin nhập hàng
        importRecord.setQuantity(importDetails.getQuantity());
        importRecord.setUnitPrice(importDetails.getUnitPrice());
        importRecord.setTotalAmount(importDetails.getUnitPrice().multiply(BigDecimal.valueOf(importDetails.getQuantity())));
        importRecord.setSupplierName(importDetails.getSupplierName());
        importRecord.setNote(importDetails.getNote());

        // Cập nhật tồn kho và giá mới
        updateProductStockAndPrice(product, importRecord);

        return importRepository.save(importRecord);
    }

    @Transactional
    public void deleteImport(Long importId) {
        Import importRecord = importRepository.findById(importId)
            .orElseThrow(() -> new ResourceNotFoundException("Import record not found"));

        // Hoàn tác thay đổi tồn kho và giá
        Product product = importRecord.getProduct();
        product.setStock(product.getStock() - importRecord.getQuantity());
        product.setImportPrice(product.getImportPrice().subtract(importRecord.getTotalAmount()));
        productRepository.save(product);

        importRepository.delete(importRecord);
    }

    public Map<String, Object> getImportStatistics(LocalDateTime startDate, LocalDateTime endDate) {
        List<Import> imports = importRepository.findByImportDateBetween(startDate, endDate);
        
        Map<String, Object> statistics = new HashMap<>();
        BigDecimal totalAmount = BigDecimal.ZERO;
        int totalQuantity = 0;
        Map<String, Integer> supplierStats = new HashMap<>();
        Map<Long, Integer> productStats = new HashMap<>();

        for (Import importRecord : imports) {
            totalAmount = totalAmount.add(importRecord.getTotalAmount());
            totalQuantity += importRecord.getQuantity();

            // Thống kê theo nhà cung cấp
            supplierStats.merge(importRecord.getSupplierName(), importRecord.getQuantity(), Integer::sum);

            // Thống kê theo sản phẩm
            productStats.merge(importRecord.getProduct().getId(), importRecord.getQuantity(), Integer::sum);
        }

        statistics.put("totalAmount", totalAmount);
        statistics.put("totalQuantity", totalQuantity);
        statistics.put("supplierStats", supplierStats);
        statistics.put("productStats", productStats);

        return statistics;
    }

    private void updateProductStockAndPrice(Product product, Import importRecord) {
        // Cập nhật tồn kho
        product.setStock(product.getStock() + importRecord.getQuantity());

        // Cập nhật giá nhập
        BigDecimal newImportPrice = product.getImportPrice().add(importRecord.getTotalAmount());
        product.setImportPrice(newImportPrice);

        // Cập nhật giá bán (ví dụ: giá bán = giá nhập * 1.3)
        BigDecimal sellingPrice = newImportPrice.multiply(BigDecimal.valueOf(1.3));
        product.setPrice(sellingPrice);

        productRepository.save(product);
    }
} 