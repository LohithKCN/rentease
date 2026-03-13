package com.example.rentease.repository;

import com.example.rentease.entity.MaintenanceRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintenanceRepository extends JpaRepository<MaintenanceRequest, Long> {

}