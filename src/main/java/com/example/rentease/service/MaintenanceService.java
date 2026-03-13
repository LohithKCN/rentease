package com.example.rentease.service;

import com.example.rentease.entity.MaintenanceRequest;
import com.example.rentease.repository.MaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class MaintenanceService {

    @Autowired
    private MaintenanceRepository maintenanceRepository;

    public MaintenanceRequest createRequest(MaintenanceRequest request){
        request.setStatus("OPEN");
        request.setRequestDate(LocalDate.now());
        return maintenanceRepository.save(request);
    }
}