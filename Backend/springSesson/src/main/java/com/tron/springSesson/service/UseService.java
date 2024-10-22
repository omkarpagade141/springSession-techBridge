package com.tron.springSesson.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tron.springSesson.entity.User;
import com.tron.springSesson.repository.UserRepository;

@Service
public class UseService {
	
	
	@Autowired
	UserRepository userrepo;
	
	public ResponseEntity<?> addNewUser(User user){
		Optional<User> existingUser = userrepo.findByMobile(user.getMobile());
		Optional<User> existingUser2 = userrepo.findByUsername(user.getUsername());
		
		if(existingUser.isPresent()) {
			return new ResponseEntity<>("User with mobile number "+ user.getMobile()+" already exist,please login",HttpStatus.BAD_REQUEST);
		}else if(existingUser2.isPresent()) {
			return new ResponseEntity<>("User with username "+ user.getUsername()+" already exist,please login",HttpStatus.BAD_REQUEST);
		}else {
			LocalDate currentDt = LocalDate.now();
			user.setCreatedOn(currentDt);
			User save = userrepo.save(user);
			return new ResponseEntity<>(save,HttpStatus.OK);
		}
		 
	}
	
	
	
	public ResponseEntity<?> loginUser(User frontendUser){
		Optional<User> searchrdUser = userrepo.findByUsername(frontendUser.getUsername());
		
		if (!searchrdUser.isPresent()) {
			return new ResponseEntity<>("User with username "+ frontendUser.getUsername()+ " not found, please register",HttpStatus.BAD_REQUEST);
		}else {
			User dbUser = searchrdUser.get();
			
			if(dbUser.getPassword().equals(frontendUser.getPassword())) {
				return new ResponseEntity<>("login success",HttpStatus.OK);
			}else {
				return new ResponseEntity<>("lncorrect password",HttpStatus.BAD_REQUEST);
			}
		} 
	}

}
