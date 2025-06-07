package com.techecommerce.service;

import com.techecommerce.model.Location;
import com.techecommerce.repository.LocationRepository;
import com.techecommerce.exception.ResourceNotFoundException;
import com.techecommerce.exception.BadRequestException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

@Service
public class LocationService {
    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Page<Location> getLocationsByParent(Long parentId, Pageable pageable) {
        return locationRepository.findByParentId(parentId, pageable);
    }

    public Page<Location> getLocationsByType(String type, Pageable pageable) {
        return locationRepository.findByType(type, pageable);
    }

    public Page<Location> getActiveLocations(Pageable pageable) {
        return locationRepository.findByActiveTrue(pageable);
    }

    public Page<Location> searchLocations(String name, Pageable pageable) {
        return locationRepository.findByNameContainingIgnoreCase(name, pageable);
    }

    @Transactional
    public Location createLocation(Location location) {
        // Kiểm tra mã địa chỉ đã tồn tại chưa
        if (locationRepository.existsByCode(location.getCode())) {
            throw new BadRequestException("Location code already exists");
        }

        // Nếu có parent, kiểm tra parent tồn tại
        if (location.getParentId() != null) {
            Location parent = locationRepository.findById(location.getParentId())
                .orElseThrow(() -> new ResourceNotFoundException("Parent location not found"));
            
            // Kiểm tra loại địa chỉ hợp lệ
            validateLocationType(location.getType(), parent.getType());
        }

        location.setActive(true);
        return locationRepository.save(location);
    }

    @Transactional
    public Location updateLocation(Long locationId, Location locationDetails) {
        Location location = locationRepository.findById(locationId)
            .orElseThrow(() -> new ResourceNotFoundException("Location not found"));

        // Kiểm tra mã địa chỉ mới có bị trùng không
        if (!location.getCode().equals(locationDetails.getCode()) &&
            locationRepository.existsByCode(locationDetails.getCode())) {
            throw new BadRequestException("Location code already exists");
        }

        // Nếu thay đổi parent, kiểm tra parent mới
        if (location.getParentId() != null && !location.getParentId().equals(locationDetails.getParentId())) {
            Location parent = locationRepository.findById(locationDetails.getParentId())
                .orElseThrow(() -> new ResourceNotFoundException("Parent location not found"));
            
            // Kiểm tra loại địa chỉ hợp lệ
            validateLocationType(locationDetails.getType(), parent.getType());
        }

        location.setName(locationDetails.getName());
        location.setCode(locationDetails.getCode());
        location.setType(locationDetails.getType());
        location.setParentId(locationDetails.getParentId());
        location.setActive(locationDetails.getActive());

        return locationRepository.save(location);
    }

    @Transactional
    public void deleteLocation(Long locationId) {
        Location location = locationRepository.findById(locationId)
            .orElseThrow(() -> new ResourceNotFoundException("Location not found"));

        // Kiểm tra có địa chỉ con không
        if (locationRepository.existsByParentId(locationId)) {
            throw new BadRequestException("Cannot delete location with children");
        }

        locationRepository.delete(location);
    }

    public Map<String, Object> getLocationHierarchy(Long locationId) {
        Location location = locationRepository.findById(locationId)
            .orElseThrow(() -> new ResourceNotFoundException("Location not found"));

        Map<String, Object> hierarchy = new HashMap<>();
        hierarchy.put("id", location.getId());
        hierarchy.put("name", location.getName());
        hierarchy.put("type", location.getType());
        hierarchy.put("code", location.getCode());

        if (location.getParentId() != null) {
            hierarchy.put("parent", getLocationHierarchy(location.getParentId()));
        }

        List<Location> children = locationRepository.findByParentId(locationId);
        if (!children.isEmpty()) {
            hierarchy.put("children", children.stream()
                .map(child -> getLocationHierarchy(child.getId()))
                .collect(Collectors.toList()));
        }

        return hierarchy;
    }

    public double calculateShippingFee(Long fromLocationId, Long toLocationId) {
        Location fromLocation = locationRepository.findById(fromLocationId)
            .orElseThrow(() -> new ResourceNotFoundException("From location not found"));
        Location toLocation = locationRepository.findById(toLocationId)
            .orElseThrow(() -> new ResourceNotFoundException("To location not found"));

        // Tính phí vận chuyển dựa trên khoảng cách và loại địa chỉ
        double baseFee = 30000.0; // Phí cơ bản
        double distanceMultiplier = calculateDistanceMultiplier(fromLocation, toLocation);
        double typeMultiplier = calculateTypeMultiplier(fromLocation, toLocation);

        return baseFee * distanceMultiplier * typeMultiplier;
    }

    private void validateLocationType(String childType, String parentType) {
        switch (parentType) {
            case "COUNTRY":
                if (!childType.equals("PROVINCE")) {
                    throw new BadRequestException("Country can only have provinces as children");
                }
                break;
            case "PROVINCE":
                if (!childType.equals("DISTRICT")) {
                    throw new BadRequestException("Province can only have districts as children");
                }
                break;
            case "DISTRICT":
                if (!childType.equals("WARD")) {
                    throw new BadRequestException("District can only have wards as children");
                }
                break;
            case "WARD":
                throw new BadRequestException("Ward cannot have children");
        }
    }

    private double calculateDistanceMultiplier(Location from, Location to) {
        // Logic tính hệ số khoảng cách
        // Ví dụ đơn giản: cùng tỉnh = 1.0, khác tỉnh = 1.5
        if (from.getParentId().equals(to.getParentId())) {
            return 1.0;
        }
        return 1.5;
    }

    private double calculateTypeMultiplier(Location from, Location to) {
        // Logic tính hệ số loại địa chỉ
        // Ví dụ đơn giản: nông thôn = 1.2, thành thị = 1.0
        if (from.getType().equals("WARD") && from.getName().contains("Xã")) {
            return 1.2;
        }
        return 1.0;
    }
} 