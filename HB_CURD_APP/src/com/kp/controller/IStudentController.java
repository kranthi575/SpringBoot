package com.kp.controller;

import com.kp.model.Student;

public interface IStudentController {
	
	String save(Student s);
	
	String update(Student s);
	
	String delete(int id);
	
	Student read(int id);
	
	Student search(int id);
	
	

}
