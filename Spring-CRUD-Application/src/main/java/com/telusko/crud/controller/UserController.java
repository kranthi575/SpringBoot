package com.telusko.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.telusko.crud.model.User;
import com.telusko.crud.service.UserService;


import java.util.List;
@Controller
public class UserController {
	
	@Autowired
	private UserService userservcie;
	@RequestMapping("createUser")
	public String createUser() {
		
		return "createUser";
	}
	
	@RequestMapping("saveUser")
	public String saveuser(@ModelAttribute("user") User user,ModelMap modelmap) {
		
		User saveduser=userservcie.add(user);
		
		String msg="User is saved successfully with ID"+saveduser.getId();
		modelmap.addAttribute("msg",msg);
		
		return "createUser";
	}
	
	@RequestMapping("viewAll")
	public String viewallusers(ModelMap modelmap) {
		List<User> usersList=userservcie.findall();
		
		modelmap.addAttribute("users",usersList);
		return "viewAllUsers";
	}
	@RequestMapping("editUser")
	public String edituser(@RequestParam("id") int Id,ModelMap modelmap) {
		
		User user=userservcie.findById(Id);
		
		modelmap.addAttribute("user",user);
		return "editUser";
	}
	@RequestMapping("updateUser")
	public String updateuser(@ModelAttribute("user") User user,ModelMap modelmap) {
	
		User updateduser=userservcie.updateUser(user);
		modelmap.addAttribute("user",updateduser);
		String msg="User is updated successfully with ID"+updateduser.getId();
		modelmap.addAttribute("msg",msg);
	return "createUser";	
	}
	//value="${user.status='INACTIVE'?'checked':''}"
	@RequestMapping("deleteUser")
	public String deleteUser(@RequestParam("id") int Id,ModelMap modelmap) {
		
		userservcie.deleteUser(Id);
		List<User> usersList=userservcie.findall();
		
		modelmap.addAttribute("users", usersList);
		return "viewAllUsers";
	}
	
	
}
