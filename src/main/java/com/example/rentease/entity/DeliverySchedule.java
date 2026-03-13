package com.example.rentease.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "delivery_schedules")
public class DeliverySchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "rental_id")
    private Rental rental;

    private LocalDate deliveryDate;
    private LocalDate pickupDate;
    private String deliveryAddress;
    private String status;

    public DeliverySchedule() {}

    public DeliverySchedule(Rental rental, LocalDate deliveryDate,
                            LocalDate pickupDate, String deliveryAddress, String status) {
        this.rental = rental;
        this.deliveryDate = deliveryDate;
        this.pickupDate = pickupDate;
        this.deliveryAddress = deliveryAddress;
        this.status = status;
    }

    public Long getId() { return id; }
    public Rental getRental() { return rental; }
    public LocalDate getDeliveryDate() { return deliveryDate; }
    public LocalDate getPickupDate() { return pickupDate; }
    public String getDeliveryAddress() { return deliveryAddress; }
    public String getStatus() { return status; }

    public void setId(Long id) { this.id = id; }
    public void setRental(Rental rental) { this.rental = rental; }
    public void setDeliveryDate(LocalDate deliveryDate) { this.deliveryDate = deliveryDate; }
    public void setPickupDate(LocalDate pickupDate) { this.pickupDate = pickupDate; }
    public void setDeliveryAddress(String deliveryAddress) { this.deliveryAddress = deliveryAddress; }
    public void setStatus(String status) { this.status = status; }
}