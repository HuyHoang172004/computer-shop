package com.techecommerce.repository;

import com.techecommerce.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    List<Location> findByParentId(Long parentId);
    List<Location> findByType(String type);
    List<Location> findByActive(boolean active);
    List<Location> findByNameContainingIgnoreCase(String name);
} 