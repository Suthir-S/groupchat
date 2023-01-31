package com.quinbay.groupchat.service;


import com.quinbay.groupchat.api.MessageInterface;
import com.quinbay.groupchat.model.GroupMembers;
import com.quinbay.groupchat.model.Groups;
import com.quinbay.groupchat.model.Message;
import com.quinbay.groupchat.repository.GroupMembersRepo;
import com.quinbay.groupchat.repository.GroupRepo;
import com.quinbay.groupchat.repository.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService implements MessageInterface {

    @Autowired
    MessageRepo messageRepo;

    @Autowired
    GroupMembersRepo groupMembersRepo;

    @Autowired
    GroupRepo groupRepo;

    @Override
    public String sendMessage(Message newmsg) { //grpname,sendernum,msgtext
        Groups grpPresent = groupRepo.findByGroupname(newmsg.getGroupid());
        if (grpPresent != null) {
            List<GroupMembers> check = groupMembersRepo.findByUserid(newmsg.getSenderid()); //findByUseridAndGroupid => confirm specific sender is in group
            if (check != null) {                                                            //findByGroupid => get all members of the group send and save a message to each Userid and store in message
                for (GroupMembers mems : check) {
                    if (mems.getGroupid().equals(newmsg.getGroupid())) {                    //remove=> findByuseridAndGroupid delet
                        Message newaddmsg = new Message();
                        newaddmsg.setSenderid(newmsg.getSenderid());
                        newaddmsg.setGroupid(newmsg.getGroupid());
                        newaddmsg.setMessagetext(newmsg.getMessagetext());
                        messageRepo.save(newaddmsg);
                        return "Message Sent";
                    }
                }
            }
            return "Member doesn't Exists";
        }
        return "Group doesn't Exists";
    }

    @Override
    public List<Message> findAll() {
        List<Message> message = messageRepo.findAll();
        return message;
    }

    @Override
    public List<Message> findSpecific(String groupid) {
        List<Message> message = messageRepo.findByGroupid(groupid);
        return message;
    }

}
