package com.example.rentease.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "rentals")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private Integer quantity;
    private LocalDate startDate;

    private LocalDate endDate;

    private Double totalAmount;

    private String status;

    public Rental() {}

    public Rental(User user, Product product, LocalDate startDate,
                  LocalDate endDate, Double totalAmount, String status , Integer quantity) {
        this.user = user;
        this.product = product;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalAmount = totalAmount;
        this.status = status;
        this.quantity=quantity;
    }

    public Long getId() { return id; }

    public User getUser() { return user; }

    public Product getProduct() { return product; }

    public LocalDate getStartDate() { return startDate; }

    public LocalDate getEndDate() { return endDate; }

    public Double getTotalAmount() { return totalAmount; }

    public String getStatus() { return status; }

    public void setId(Long id) { this.id = id; }

    public void setUser(User user) { this.user = user; }

    public void setProduct(Product product) { this.product = product; }

    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public void setTotalAmount(Double totalAmount) { this.totalAmount = totalAmount; }

    public void setStatus(String status) { this.status = status; }
    public void setQuantity(Integer quantity){this.quantity = quantity;}
}