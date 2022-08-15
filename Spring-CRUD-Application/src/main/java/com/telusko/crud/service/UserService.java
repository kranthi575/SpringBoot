package com.telusko.crud.service;

import com.telusko.crud.model.User;


import java.util.List;

public interface UserService {
	
	User add(User user);
	
	List<User> findall();
	
	User findById(Integer id);
	
	User updateUser(User user);
	
	void deleteUser(Integer id);

}
