package com.kp.service;

import com.kp.model.Student;

public interface IStudentService {

	String save(Student s);
	
	String update(Student s);
	
	String delete(int id);
	
	String read(int id);
	
	Student search(int id);

}
