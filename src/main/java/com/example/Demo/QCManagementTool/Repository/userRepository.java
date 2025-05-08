package com.example.Demo.QCManagementTool.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Demo.QCManagementTool.Entity.User;

public interface userRepository extends JpaRepository<User, Integer>{
	
	User findByName(String name);

}
