package com.quinbay.groupchat.api;

import com.quinbay.groupchat.model.Contacts;
import com.quinbay.groupchat.model.Groups;

import java.util.List;

public interface GroupInterface {
    String GroupAddMembers(List<Contacts> users, String groupname,String createdby);
//    String removeMembers(String groupid,String userid);
}
