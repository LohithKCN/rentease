package com.example.rentease.service;

import com.example.rentease.entity.DeliverySchedule;
import com.example.rentease.repository.DeliveryScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryScheduleService {

    @Autowired
    private DeliveryScheduleRepository deliveryScheduleRepository;

    public DeliverySchedule scheduleDelivery(DeliverySchedule schedule){
        schedule.setStatus("SCHEDULED");
        return deliveryScheduleRepository.save(schedule);
    }
}