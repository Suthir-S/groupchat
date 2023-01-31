package com.quinbay.groupchat.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupMembers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String groupid;  //groupname
    String userid;  //mobilenum
}
