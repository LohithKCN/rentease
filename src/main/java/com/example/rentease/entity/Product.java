package com.example.rentease.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category;

    @Column(columnDefinition = "TEXT")
    private String imageUrl;

    private Double monthlyRent;
    private Double securityDeposit;
    private Integer stockQuantity;
    private String description;
    private String city;
    private Boolean available;

    public Product() {}

    public Product(String name, String category, String imageUrl, Double monthlyRent,
                   Double securityDeposit, Integer stockQuantity, String description,
                   String city, Boolean available) {

        this.name = name;
        this.category = category;
        this.imageUrl = imageUrl;
        this.monthlyRent = monthlyRent;
        this.securityDeposit = securityDeposit;
        this.stockQuantity = stockQuantity;
        this.description = description;
        this.city = city;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Double getMonthlyRent() {
        return monthlyRent;
    }

    public Double getSecurityDeposit() {
        return securityDeposit;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public String getDescription() {
        return description;
    }

    public String getCity() {
        return city;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setMonthlyRent(Double monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public void setSecurityDeposit(Double securityDeposit) {
        this.securityDeposit = securityDeposit;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}