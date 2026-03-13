package com.example.rentease.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long senderId;

    private Long receiverId;

    private Long productId;

    private String content;

    private LocalDateTime timestamp;

    public Message() {}

    public Long getId() { return id; }
    public Long getSenderId() { return senderId; }
    public Long getReceiverId() { return receiverId; }
    public Long getProductId() { return productId; }
    public String getContent() { return content; }
    public LocalDateTime getTimestamp() { return timestamp; }

    public void setId(Long id) { this.id = id; }
    public void setSenderId(Long senderId) { this.senderId = senderId; }
    public void setReceiverId(Long receiverId) { this.receiverId = receiverId; }
    public void setProductId(Long productId) { this.productId = productId; }
    public void setContent(String content) { this.content = content; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}
