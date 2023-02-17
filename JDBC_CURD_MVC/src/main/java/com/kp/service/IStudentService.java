package com.kp.service;

import com.kp.dto.Student;

//data transfer object
public interface IStudentService {
	
	String add(Student s);
	Student getByID(int id);
	String deleteById(int id);
	String edit(Student s);
	
	

}
