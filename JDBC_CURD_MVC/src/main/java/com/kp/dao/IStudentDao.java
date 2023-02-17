package com.kp.dao;

import com.kp.dto.Student;

public interface IStudentDao {
	
	String add(Student stud);
	Student getById(int id);
	String deleteById(int id);
	String edit(Student s);
}
