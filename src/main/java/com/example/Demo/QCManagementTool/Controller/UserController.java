package com.example.Demo.QCManagementTool.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Demo.QCManagementTool.Entity.User;
import com.example.Demo.QCManagementTool.Service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("/register")
	public User register(@RequestBody User user)
	{
		return service.register(user);
	}

}
