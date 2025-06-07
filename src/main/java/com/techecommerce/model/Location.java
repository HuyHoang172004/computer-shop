package com.techecommerce.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "type", nullable = false)
    private String type; // COUNTRY, PROVINCE, DISTRICT, WARD

    @Column(name = "code", unique = true)
    private String code;

    private boolean active = true;
} 