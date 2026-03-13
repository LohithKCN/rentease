package com.example.rentease.service;

import com.example.rentease.entity.Message;
import com.example.rentease.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public Message sendMessage(Message message){
        message.setTimestamp(LocalDateTime.now());
        return messageRepository.save(message);
    }

    public List<Message> getMessages(Long productId){
        return messageRepository.findByProductId(productId);
    }
}
