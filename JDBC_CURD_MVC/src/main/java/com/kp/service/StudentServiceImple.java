package com.kp.service;

import com.kp.dao.IStudentDao;
import com.kp.dto.Student;
import com.kp.studentFactory.StudentDaoFactory;

public class StudentServiceImple implements IStudentService {

	@Override
	public String add(Student s) {
		
		IStudentDao studentDao=StudentDaoFactory.getStudentDao();
		
		String response=studentDao.add(s);
		
		return response;
	}

	@Override
	public Student getByID(int id) {
		
		IStudentDao studentDao=StudentDaoFactory.getStudentDao();
		
		Student std=studentDao.getById(id);
		
		return std;
	}

	@Override
	public String deleteById(int id) {
		
		IStudentDao studentDao=StudentDaoFactory.getStudentDao();
		
		String resp=studentDao.deleteById(id);
		
		return resp;
	}
	
	@Override
	public String edit(Student s) {
		
		IStudentDao studentDao=StudentDaoFactory.getStudentDao();
		
		String resp=studentDao.edit(s);
		
		return resp;
	}

}
