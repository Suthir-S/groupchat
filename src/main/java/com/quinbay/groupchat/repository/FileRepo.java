package com.quinbay.groupchat.repository;

import com.quinbay.groupchat.model.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepo extends JpaRepository<File,String> {
}
