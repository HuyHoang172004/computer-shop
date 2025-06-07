package com.techecommerce.controller;

import com.techecommerce.model.Location;
import com.techecommerce.service.LocationService;
import com.techecommerce.security.CurrentUser;
import com.techecommerce.security.UserPrincipal;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/api/locations")
@Tag(name = "Location", description = "Location management APIs")
@SecurityRequirement(name = "bearerAuth")
public class LocationController {
    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/parent/{parentId}")
    @Operation(summary = "Get locations by parent ID")
    public ResponseEntity<Page<Location>> getLocationsByParent(
            @Parameter(description = "Parent location ID") @PathVariable Long parentId,
            Pageable pageable) {
        return ResponseEntity.ok(locationService.getLocationsByParent(parentId, pageable));
    }

    @GetMapping("/type/{type}")
    @Operation(summary = "Get locations by type")
    public ResponseEntity<Page<Location>> getLocationsByType(
            @Parameter(description = "Location type") @PathVariable String type,
            Pageable pageable) {
        return ResponseEntity.ok(locationService.getLocationsByType(type, pageable));
    }

    @GetMapping("/active")
    @Operation(summary = "Get active locations")
    public ResponseEntity<Page<Location>> getActiveLocations(Pageable pageable) {
        return ResponseEntity.ok(locationService.getActiveLocations(pageable));
    }

    @GetMapping("/search")
    @Operation(summary = "Search locations by name")
    public ResponseEntity<Page<Location>> searchLocations(
            @Parameter(description = "Location name") @RequestParam String name,
            Pageable pageable) {
        return ResponseEntity.ok(locationService.searchLocations(name, pageable));
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Create a new location")
    public ResponseEntity<Location> createLocation(
            @Valid @RequestBody Location location,
            @CurrentUser UserPrincipal currentUser) {
        return ResponseEntity.ok(locationService.createLocation(location));
    }

    @PutMapping("/{locationId}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Update a location")
    public ResponseEntity<Location> updateLocation(
            @Parameter(description = "Location ID") @PathVariable Long locationId,
            @Valid @RequestBody Location location,
            @CurrentUser UserPrincipal currentUser) {
        return ResponseEntity.ok(locationService.updateLocation(locationId, location));
    }

    @DeleteMapping("/{locationId}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Delete a location")
    public ResponseEntity<Void> deleteLocation(
            @Parameter(description = "Location ID") @PathVariable Long locationId,
            @CurrentUser UserPrincipal currentUser) {
        locationService.deleteLocation(locationId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{locationId}/hierarchy")
    @Operation(summary = "Get location hierarchy")
    public ResponseEntity<Map<String, Object>> getLocationHierarchy(
            @Parameter(description = "Location ID") @PathVariable Long locationId) {
        return ResponseEntity.ok(locationService.getLocationHierarchy(locationId));
    }

    @GetMapping("/shipping-fee")
    @Operation(summary = "Calculate shipping fee")
    public ResponseEntity<Map<String, Double>> calculateShippingFee(
            @Parameter(description = "From location ID") @RequestParam Long fromLocationId,
            @Parameter(description = "To location ID") @RequestParam Long toLocationId) {
        double fee = locationService.calculateShippingFee(fromLocationId, toLocationId);
        return ResponseEntity.ok(Map.of("shippingFee", fee));
    }
} 