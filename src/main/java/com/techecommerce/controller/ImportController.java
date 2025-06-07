package com.techecommerce.controller;

import com.techecommerce.model.Import;
import com.techecommerce.service.ImportService;
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
@RequestMapping("/api/imports")
@Tag(name = "Import", description = "Import management APIs")
@SecurityRequirement(name = "bearerAuth")
public class ImportController {
    private final ImportService importService;

    public ImportController(ImportService importService) {
        this.importService = importService;
    }

    @GetMapping("/product/{productId}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Get imports by product ID")
    public ResponseEntity<Page<Import>> getImportsByProduct(
            @Parameter(description = "Product ID") @PathVariable Long productId,
            Pageable pageable) {
        return ResponseEntity.ok(importService.getImportsByProduct(productId, pageable));
    }

    @GetMapping("/date-range")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Get imports by date range")
    public ResponseEntity<Page<Import>> getImportsByDateRange(
            @Parameter(description = "Start date") @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @Parameter(description = "End date") @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate,
            Pageable pageable) {
        return ResponseEntity.ok(importService.getImportsByDateRange(startDate, endDate, pageable));
    }

    @GetMapping("/supplier/{supplierName}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Get imports by supplier name")
    public ResponseEntity<Page<Import>> getImportsBySupplier(
            @Parameter(description = "Supplier name") @PathVariable String supplierName,
            Pageable pageable) {
        return ResponseEntity.ok(importService.getImportsBySupplier(supplierName, pageable));
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Create a new import record")
    public ResponseEntity<Import> createImport(
            @Valid @RequestBody Import importRecord,
            @CurrentUser UserPrincipal currentUser) {
        return ResponseEntity.ok(importService.createImport(importRecord));
    }

    @PutMapping("/{importId}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Update an import record")
    public ResponseEntity<Import> updateImport(
            @Parameter(description = "Import ID") @PathVariable Long importId,
            @Valid @RequestBody Import importDetails,
            @CurrentUser UserPrincipal currentUser) {
        return ResponseEntity.ok(importService.updateImport(importId, importDetails));
    }

    @DeleteMapping("/{importId}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Delete an import record")
    public ResponseEntity<Void> deleteImport(
            @Parameter(description = "Import ID") @PathVariable Long importId,
            @CurrentUser UserPrincipal currentUser) {
        importService.deleteImport(importId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/statistics")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Get import statistics")
    public ResponseEntity<Map<String, Object>> getImportStatistics(
            @Parameter(description = "Start date") @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @Parameter(description = "End date") @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
        return ResponseEntity.ok(importService.getImportStatistics(startDate, endDate));
    }
} 