package com.quinbay.groupchat.repository;

import com.quinbay.groupchat.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MessageRepo extends JpaRepository<Message,Integer> {
     List<Message> findAll();
     List<Message> findByGroupid(String groupid);
}
