package com.quinbay.groupchat.controller;


import com.quinbay.groupchat.model.Contacts;
//import com.quinbay.groupchat.model.Groups;
import com.quinbay.groupchat.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GroupController {

//    @Autowired
//    Groups group;

    @Autowired
    GroupService groupService;

//    @PostMapping("/createownGroup")
//    public String newGroup(@RequestParam String groupname ,@RequestParam String createdby){
//        return groupService.createGroup(groupname,createdby);
//    }


    @PostMapping("/addMembers")
    public String addMembers(@RequestBody Contacts users, @RequestParam String groupname){
        return groupService.addMembers(users,groupname);
    }


    @PostMapping("/createGroup")
    public String addMembers(@RequestBody List<Contacts> users, @RequestParam String groupname,@RequestParam String createdby){
        return groupService.GroupAddMembers(users,groupname,createdby);
    }



//
//    @DeleteMapping("/removeMember")
//    public String removeMember(@RequestParam String groupid,@RequestParam String userid){
//        return groupService.removeMembers(groupid,userid);
//    }


}
