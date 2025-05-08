package com.example.Demo.QCManagementTool.Service;

import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Demo.QCManagementTool.Entity.User;
import com.example.Demo.QCManagementTool.Repository.userRepository;

@Service
public class UserService {
	
	@Autowired
	private userRepository repo;
	
	@Autowired
	AuthenticationManager authManager;
	
	@Autowired
	private JWTService jwtService;
	
	private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);

	public User register(User user) {
		
		user.setUserPassword(encoder.encode(user.getUserPassword()));
		return repo.save(user);
		
	}

	public String verify(User user) {
		Authentication authentication=
				authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getName(), user.getUserPassword())) ;
		if(authentication.isAuthenticated())
			return jwtService.generateToken(user.getName());
		
		return "fail";
	}
	
}
