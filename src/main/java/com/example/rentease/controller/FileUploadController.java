package com.example.rentease.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class FileUploadController {

    private static final String UPLOAD_DIR =
            System.getProperty("user.dir") + "/uploads/";

    @PostMapping("/upload")
    public String uploadImage(@RequestParam("file") MultipartFile file) throws IOException {

        File uploadDir = new File(UPLOAD_DIR);

        if(!uploadDir.exists()){
            uploadDir.mkdirs();
        }

        String fileName = file.getOriginalFilename();

        File destination = new File(UPLOAD_DIR + fileName);

        file.transferTo(destination);

        return "http://localhost:8080/uploads/" + fileName;
    }
}