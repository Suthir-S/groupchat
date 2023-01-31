package com.quinbay.groupchat.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "files")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class File {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    String id;
    String name;
    String type;
    @Lob
    private byte[] data;
    //String groupid;

    public File(String name, String type, byte[] data) {
        this.name = name;
        this.type = type;
        this.data = data;
    }
}