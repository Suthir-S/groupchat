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
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int messageid;
    String senderid;
    String groupid;
    String messagetext;
    @CreationTimestamp
    Date timestamp;


    public Message(String groupid, String senderid, String messagetext) {
        this.senderid = senderid;
        this.groupid = groupid;
        this.messagetext = messagetext;
    }
}
