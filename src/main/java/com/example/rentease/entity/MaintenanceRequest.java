package com.example.rentease.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "maintenance_requests")
public class MaintenanceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "rental_id")
    private Rental rental;

    private String issueDescription;

    private String status;

    private LocalDate requestDate;

    public MaintenanceRequest() {}

    public MaintenanceRequest(Rental rental, String issueDescription,
                              String status, LocalDate requestDate) {
        this.rental = rental;
        this.issueDescription = issueDescription;
        this.status = status;
        this.requestDate = requestDate;
    }

    public Long getId() { return id; }

    public Rental getRental() { return rental; }

    public String getIssueDescription() { return issueDescription; }

    public String getStatus() { return status; }

    public LocalDate getRequestDate() { return requestDate; }

    public void setId(Long id) { this.id = id; }

    public void setRental(Rental rental) { this.rental = rental; }

    public void setIssueDescription(String issueDescription) { this.issueDescription = issueDescription; }

    public void setStatus(String status) { this.status = status; }

    public void setRequestDate(LocalDate requestDate) { this.requestDate = requestDate; }
}