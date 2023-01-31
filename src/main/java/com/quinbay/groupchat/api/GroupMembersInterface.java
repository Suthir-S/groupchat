package com.quinbay.groupchat.api;

import com.quinbay.groupchat.model.Contacts;
import com.quinbay.groupchat.model.GroupMembers;

import java.util.List;

public interface GroupMembersInterface {
    String addGroupMem(List<Contacts> users, String groupname);
    List<GroupMembers> findSpecific(String groupid);
}
