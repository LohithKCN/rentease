package com.example.rentease.controller;

import com.example.rentease.entity.Message;
import com.example.rentease.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
@CrossOrigin("*")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/send")
    public Message sendMessage(@RequestBody Message message){
        return messageService.sendMessage(message);
    }

    @GetMapping("/product/{productId}")
    public List<Message> getMessages(@PathVariable Long productId){
        return messageService.getMessages(productId);
    }
}
