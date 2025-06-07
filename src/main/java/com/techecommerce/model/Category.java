package com.techecommerce.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private String description;

    private String image;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category parent;

    private boolean active = true;
} 