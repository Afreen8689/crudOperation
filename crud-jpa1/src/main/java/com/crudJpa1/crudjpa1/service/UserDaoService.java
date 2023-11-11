package com.crudJpa1.crudjpa1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.crudJpa1.crudjpa1.entity.User;
import com.crudJpa1.crudjpa1.repository.UserRepository;

@Component
public class UserDaoService {
	
	@Autowired
	UserRepository repository;

	public List<User> findAllUsers() {
		return repository.findAll();		
	}

	public User findUser(Long id) {
		return repository.findById(id).orElse(null);
	}

	public User saveUser(User user) {
		return repository.save(user);
	}

	public void deleteUser(Long id) {
		repository.deleteById(id);
		
	}
	
	
	
	

}
