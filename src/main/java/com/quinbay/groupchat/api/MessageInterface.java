package com.quinbay.groupchat.api;

import com.quinbay.groupchat.model.Message;

import java.util.List;

public interface MessageInterface {
    String sendMessage(Message msg);
//-------------------------------------------------
//   List<Message> findAllMessages();
   List<Message> findSpecific(String groupid);
   List<Message> findAll();
}
