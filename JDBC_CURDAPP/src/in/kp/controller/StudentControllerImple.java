package in.kp.controller;

import in.kp.StudentFactory.StudentServiceFactory;
import in.kp.dto.Student;
import in.kp.service.StudentService;

public class StudentControllerImple implements StudentController {

	@Override
	public String save(Student s) {
		StudentService stdService=StudentServiceFactory.getStudentService();
		
		String str=stdService.save(s);
		return str;
	}

	@Override
	public Student findyById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
