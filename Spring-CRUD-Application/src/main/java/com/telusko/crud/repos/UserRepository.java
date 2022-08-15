package com.telusko.crud.repos;


import org.springframework.data.jpa.repository.JpaRepository;

import com.telusko.crud.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {
	
}
