package com.crudJpa1.crudjpa1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudJpa1.crudjpa1.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	

}
