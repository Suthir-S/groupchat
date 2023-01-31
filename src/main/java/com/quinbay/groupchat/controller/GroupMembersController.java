package com.quinbay.groupchat.controller;

import com.quinbay.groupchat.model.GroupMembers;
import com.quinbay.groupchat.service.GroupMembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GroupMembersController {

    @Autowired
    GroupMembersService groupMembersService;

    @GetMapping("/displayGroupMembers")
    public List<GroupMembers> getAllUsers() {
        return groupMembersService.findAllUsers();
    }

    @GetMapping("/displayAgroupMembers")
    public List<GroupMembers> getAllMembers(@RequestParam String groupid){
        return groupMembersService.findSpecific(groupid);
    }
}
