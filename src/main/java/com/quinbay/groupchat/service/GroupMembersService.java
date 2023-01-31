package com.quinbay.groupchat.service;


import com.quinbay.groupchat.api.GroupMembersInterface;
import com.quinbay.groupchat.model.Contacts;
import com.quinbay.groupchat.model.GroupMembers;
import com.quinbay.groupchat.model.Message;
import com.quinbay.groupchat.repository.GroupMembersRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class GroupMembersService implements GroupMembersInterface {

//    @Autowired
//    GroupMembers groupMembers;

    @Autowired
    GroupMembersRepo groupMembersRepo;


    public String addGroupMem(List<Contacts> users, String groupname) {
        List<GroupMembers> fetchGroupMem = groupMembersRepo.findByGroupid(groupname);
        for (Contacts con : users) {
            for(GroupMembers memcheck : fetchGroupMem){
                if (con.getMobilenum() != memcheck.getUserid()) {
                    GroupMembers groupMembers = new GroupMembers();
                    groupMembers.setUserid(con.getMobilenum());
                    groupMembers.setGroupid(groupname);
                    groupMembersRepo.save(groupMembers);
                }
                else {
                    log.info("Member "+memcheck.getUserid()+" already present");
                }
            }
        }
        return "Members Added Successfully";
    }
    public List<GroupMembers> findAllUsers() {
        List<GroupMembers> users = groupMembersRepo.findAll();
        return users;
    }


    @Override
    public List<GroupMembers> findSpecific(String groupid) {
        List<GroupMembers> message = groupMembersRepo.findByGroupid(groupid);
        return message;
    }
}

