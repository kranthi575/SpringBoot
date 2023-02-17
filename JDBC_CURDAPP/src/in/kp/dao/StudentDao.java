package in.kp.dao;

import in.kp.dto.Student;

public interface StudentDao {
	
	String save(Student s);
	
	Student findById(int id);
	
	String updateById(int id);
	
	String deleteById(int id);
	

}
