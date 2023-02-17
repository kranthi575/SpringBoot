package com.kp.controller;

import com.kp.model.Student;
import com.kp.service.IStudentService;
import com.kp.service.StudentServiceImple;
import com.kp.studentFactory.StudentServiceFactory;

public class StudentControllerImple implements IStudentController {

	@Override
	public String save(Student s) {
		IStudentService studService=StudentServiceFactory.getStudentService();
		
		String msg=studService.save(s);
		
		return msg;
		
	}

	@Override
	public String update(Student s) {
		
		IStudentService studService=StudentServiceFactory.getStudentService();
		
		String msg=studService.update(s);
		
		return msg;
	}

	@Override
	public String delete(int id) {
		
		IStudentService studService=StudentServiceFactory.getStudentService();
		String msg=studService.delete(id);
		return msg;
	}

	@Override
	public Student read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student search(int id) {

		IStudentService studService=StudentServiceFactory.getStudentService();
		Student stud=studService.search(id);
		return stud;
	}

}
