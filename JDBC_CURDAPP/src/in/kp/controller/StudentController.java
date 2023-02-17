package in.kp.controller;

import in.kp.dto.Student;

public interface StudentController {
	
	String save(Student s);
	
	Student findyById(int id);
	
	String updateById(int id);
	
	String deleteById(int id);
	
	
	

}
