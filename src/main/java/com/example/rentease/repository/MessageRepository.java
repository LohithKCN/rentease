package com.example.rentease.repository;

import com.example.rentease.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findByProductId(Long productId);

}
