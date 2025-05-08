package com.example.Demo.QCManagementTool.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Demo.QCManagementTool.Entity.User;
import com.example.Demo.QCManagementTool.Repository.userRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	private userRepository repo;

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		
		User user =repo.findByName(name);
		// TODO Auto-generated method stub
		
		if(user == null) {
			System.out.println("User not Found");
			throw new UsernameNotFoundException("user not found");
		}
		
		return new UserPrincipal(user);
	}

}
