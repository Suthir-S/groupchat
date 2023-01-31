package com.quinbay.groupchat.repository;

import com.quinbay.groupchat.model.GroupMembers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupMembersRepo extends JpaRepository<GroupMembers,Integer> {
    List<GroupMembers> findByGroupid(String groupid);
    List<GroupMembers> findByUserid(String groupid);
    GroupMembers deleteByUserid(String userid);
}
