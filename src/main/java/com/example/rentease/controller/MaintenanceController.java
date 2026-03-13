package com.example.rentease.controller;

import com.example.rentease.entity.MaintenanceRequest;
import com.example.rentease.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/maintenance")
public class MaintenanceController {

    @Autowired
    private MaintenanceService maintenanceService;

    @PostMapping("/request")
    public MaintenanceRequest createRequest(@RequestBody MaintenanceRequest request){
        return maintenanceService.createRequest(request);
    }
}