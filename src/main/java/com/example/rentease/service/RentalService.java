package com.example.rentease.service;

import com.example.rentease.entity.Rental;
import com.example.rentease.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    public Rental rentProduct(Rental rental){
        rental.setStatus("ACTIVE");
        return rentalRepository.save(rental);
    }

    public List<Rental> getAllRentals(){
        return rentalRepository.findAll();
    }

}