package com.example.rentease.controller;

import com.example.rentease.entity.DeliverySchedule;
import com.example.rentease.service.DeliveryScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/delivery")
public class DeliveryScheduleController {

    @Autowired
    private DeliveryScheduleService deliveryScheduleService;

    @PostMapping("/schedule")
    public DeliverySchedule scheduleDelivery(@RequestBody DeliverySchedule schedule){
        return deliveryScheduleService.scheduleDelivery(schedule);
    }
}