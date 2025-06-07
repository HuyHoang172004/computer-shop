package com.techecommerce.service;

import com.techecommerce.model.Brand;
import com.techecommerce.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandService {
    private final BrandRepository brandRepository;

    @Transactional
    public Brand createBrand(Brand brand) {
        if (brandRepository.existsByName(brand.getName())) {
            throw new RuntimeException("Brand name already exists");
        }
        return brandRepository.save(brand);
    }

    @Transactional
    public Brand updateBrand(Long id, Brand brand) {
        Brand existingBrand = brandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Brand not found"));
        
        if (!existingBrand.getName().equals(brand.getName()) && 
            brandRepository.existsByName(brand.getName())) {
            throw new RuntimeException("Brand name already exists");
        }
        
        existingBrand.setName(brand.getName());
        existingBrand.setDescription(brand.getDescription());
        existingBrand.setLogo(brand.getLogo());
        existingBrand.setActive(brand.isActive());
        
        return brandRepository.save(existingBrand);
    }

    @Transactional
    public void deleteBrand(Long id) {
        brandRepository.deleteById(id);
    }

    public Brand getBrandById(Long id) {
        return brandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Brand not found"));
    }

    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    public List<Brand> getActiveBrands() {
        return brandRepository.findByActive(true);
    }
} 