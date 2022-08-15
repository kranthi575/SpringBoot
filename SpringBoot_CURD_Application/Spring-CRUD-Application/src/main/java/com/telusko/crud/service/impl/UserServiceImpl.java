package com.telusko.crud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.telusko.crud.model.User;
import com.telusko.crud.repos.UserRepository;
import com.telusko.crud.service.UserService;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User add(User user) {
		User savedUser=userRepository.save(user);
		return savedUser;
	}
	@Override
	public List<User> findall() {
		
		return (List<User>) userRepository.findAll();
		
	}
	@Override
	public User findById(Integer id) {
		
		User user= userRepository.findById(id).get();
		return user;
	}
	@Override
	public User updateUser(User user) {
		User updateduser=userRepository.save(user);
		return updateduser;
	}
	@Override
	public void deleteUser(Integer id) {
		Optional<User> user=userRepository.findById(id);
		if(user.isPresent()) {
			userRepository.delete(user.get());
		}
	}
}
