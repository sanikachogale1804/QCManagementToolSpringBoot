package com.example.Demo.QCManagementTool.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Demo.QCManagementTool.Entity.User;
import com.example.Demo.QCManagementTool.Repository.userRepository;

@Service
public class UserService {
	
	@Autowired
	private userRepository repo;
	
	private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);

	public User register(User user) {
		
		user.setUserPassword(encoder.encode(user.getUserPassword()));
		return repo.save(user);
		
	}
	
}
