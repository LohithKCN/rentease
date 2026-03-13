package com.example.rentease.service;

import com.example.rentease.entity.User;
import com.example.rentease.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    public User loginUser(String email, String password){

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if(passwordEncoder.matches(password, user.getPassword())){
            return user;
        } else {
            throw new RuntimeException("Invalid password");
        }
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}