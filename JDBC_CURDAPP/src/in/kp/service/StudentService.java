package in.kp.service;

import in.kp.dto.Student;

public interface StudentService {
	
	String save(Student s);
	
	Student findById(int id);
	
	String updateById(int id);
	
	String deleteById(int id);

}
