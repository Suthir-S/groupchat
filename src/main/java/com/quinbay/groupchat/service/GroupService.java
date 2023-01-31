package com.quinbay.groupchat.service;


import com.quinbay.groupchat.api.GroupInterface;
import com.quinbay.groupchat.model.Contacts;
import com.quinbay.groupchat.model.GroupMembers;
import com.quinbay.groupchat.model.Groups;
import com.quinbay.groupchat.model.Message;
import com.quinbay.groupchat.repository.GroupMembersRepo;
import com.quinbay.groupchat.repository.GroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class GroupService implements GroupInterface {

    @Autowired
    GroupRepo groupRepo;

    @Autowired
    GroupMembersRepo groupMembersRepo;

    @Autowired
    GroupMembersService groupMembersService;

    @Autowired
    MessageService messageService;


//    @Override
//    public String createGroup(String groupname , String createdby ) {
//        Groups newGroups = new Groups();
//        newGroups = groupRepo.findByGroupname(groupname);
//        //System.out.println(" ------------------------------------------------------ ");
//        //System.out.println(newGroups);
//        if (newGroups == null) {
//            System.out.println(" ------------------------------------------------------ ");
//            Groups addGroups = new Groups();
//            addGroups.setGroupname(groupname);
//            addGroups.setCreatedby(createdby); //contactnum
//            //newGroups = new Groups(groupname,createdby);
//            //newGroups.setCreatedon(timestamp);
//            groupRepo.save(addGroups);
//            return "Groups Created";
//        } else {
//            return "Groupname Already exists";
//        }
//    }

    public String addMembers(Contacts con, String groupname) {
        List<GroupMembers> fetchGroupMem = groupMembersRepo.findByGroupid(groupname);
            for(GroupMembers memcheck : fetchGroupMem) {
                if (con.getMobilenum() != memcheck.getUserid()) {
                    GroupMembers groupMembers = new GroupMembers();
                    groupMembers.setUserid(con.getMobilenum());
                    groupMembers.setGroupid(groupname);
                    groupMembersRepo.save(groupMembers);
                    return "Member Added Successfully";
                } else {
                    return "Member already Exists";
                }
            }
        GroupMembers groupMembers = new GroupMembers();
        groupMembers.setUserid(con.getMobilenum());
        groupMembers.setGroupid(groupname);
        groupMembersRepo.save(groupMembers);
        return "Member Added Successfully";
        }


//    @Override
//    public String removeMembers(String groupid,String userid){
//        List<GroupMembers> newGroups = groupMembersRepo.findByUserid(userid);
//        if(newGroups!=null){
//            Groups fetchGroup = groupRepo.findByGroupname(groupid);
//            if(fetchGroup!=null){
////                newGroups.remove(userid);
//                groupMembersRepo.deleteByUserid(userid);
//                return "Member Removed";
//            }
//        }
//        return "Member doesn't exist";
//    }

    @Override
    public String GroupAddMembers(List<Contacts> users, String groupname, String createdby) {
        Groups newGroups = groupRepo.findByGroupname(groupname);
        if (newGroups == null) {
            Groups addGroups = new Groups();
            GroupMembers addMember = new GroupMembers();
            addGroups.setGroupname(groupname);
            addGroups.setCreatedby(createdby);
            groupRepo.save(addGroups);
            addMember.setUserid(createdby);
            addMember.setGroupid(groupname);
            groupMembersRepo.save(addMember);
            groupMembersService.addGroupMem(users, groupname);
            Message addMsg = new Message();
            addMsg.setSenderid(createdby);
            addMsg.setGroupid(groupname);
            addMsg.setMessagetext("Group Created");
            messageService.sendMessage(addMsg);
            return "Members added";
        }
        return "Groupname Already Exists";
    }


}

