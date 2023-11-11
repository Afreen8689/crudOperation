package com.crudJpa1.crudjpa1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crudJpa1.crudjpa1.entity.User;
import com.crudJpa1.crudjpa1.service.UserDaoService;

@RestController
public class UserController {
	
	@Autowired
	UserDaoService service;
	
	@GetMapping("/JpaUsers")
	public List<User> getAllusers() {
		return service.findAllUsers();
	}
	
	@GetMapping("/JpaUsers/{id}")
	public User getUser(@PathVariable Long id) {
		User u=  service.findUser(id);
		return u;
		
		
	}
	
	
	@PostMapping("/JpaUsers")
	public ResponseEntity<User> getUser(@RequestBody User user) {
		User user1 = service.saveUser(user);
		return new ResponseEntity<>(user1, HttpStatus.CREATED);
	}
	
	@PutMapping("/JpaUsers/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User user) {
		User existingUser = service.findUser(user.getId());
		existingUser.setName(user.getName());
		existingUser.setEmail(user.getEmail());
		existingUser.setBirthDate(user.getBirthDate());
		User user2= service.saveUser(existingUser);
		return user2;
	}
	
	@DeleteMapping("/JpaUsers/{id}")
	public List<User> deleteUser(@PathVariable Long id) {
		service.deleteUser(id);
		return service.findAllUsers();
	}
		

}
