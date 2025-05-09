package com.example.Demo.QCManagementTool.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.Demo.QCManagementTool.Entity.User;

@CrossOrigin
public interface userRepository extends JpaRepository<User, Integer>{
	
	User findByName(String name);

}
