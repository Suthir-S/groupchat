package com.quinbay.groupchat.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Groups {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int groupid;
    String groupname;
    String createdby;
    public Groups(String groupname, String createdby) {
        this.groupname = groupname;
        this.createdby = createdby;
    }
    @CreationTimestamp
    Date createdon;
    //@Temporal(TemporalType.TIME)

}
