package com.example.rentease.repository;

import com.example.rentease.entity.DeliverySchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryScheduleRepository extends JpaRepository<DeliverySchedule, Long> {

}