package com.kp.dao;

import com.kp.model.Student;

public interface IStudentDao {
	
    String save(Student s);
	
	String update(Student s);
	
	String delete(int id);
	
	String read(int id);
	
	Student search(int id);


}
