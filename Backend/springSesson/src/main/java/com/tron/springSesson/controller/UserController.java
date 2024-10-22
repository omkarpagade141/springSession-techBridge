package com.tron.springSesson.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tron.springSesson.entity.User;
import com.tron.springSesson.service.UseService;

@RestController
@RequestMapping("/user")
@CrossOrigin(value = "*")
public class UserController {
	
	
	@Autowired
	UseService userservice;
	
	@PostMapping("/adduser")
	public ResponseEntity<?> addNewUser(@RequestBody User user){
		 return userservice.addNewUser(user);
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody User user){
		 return userservice.loginUser(user);
		
	}


}
