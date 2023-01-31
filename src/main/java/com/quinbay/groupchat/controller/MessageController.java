package com.quinbay.groupchat.controller;


import com.quinbay.groupchat.model.GroupMembers;
import com.quinbay.groupchat.model.Message;
import com.quinbay.groupchat.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {

    @Autowired
    MessageService messageService;

    @PostMapping("/sendMessage")
    public String sendMessage(@RequestBody Message newmsg){
        return messageService.sendMessage(newmsg);
    }

    @GetMapping("/displayGroupMessages")
    public List<Message> getAllMessage() {
        return messageService.findAll();
    }


    @GetMapping("/displaySpecific")
    public List<Message> getSpecific(@RequestParam String groupid){
        return messageService.findSpecific(groupid);
    }


}
