package com.example.rentease.controller;

import com.example.rentease.entity.Rental;
import com.example.rentease.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/rentals")
public class RentalController {

    @Autowired
    private RentalService rentalService;

    @PostMapping("/rent")
    public Rental rentProduct(@RequestBody Rental rental){
        return rentalService.rentProduct(rental);
    }

    @GetMapping("/all")
    public List<Rental> getAllRentals(){
        return rentalService.getAllRentals();
    }
    
}