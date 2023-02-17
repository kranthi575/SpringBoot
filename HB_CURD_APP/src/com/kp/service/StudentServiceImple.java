package com.kp.service;

import com.kp.dao.IStudentDao;
import com.kp.dao.StudentDaoImple;
import com.kp.model.Student;
import com.kp.studentFactory.StudentDaoFactory;

public class StudentServiceImple implements IStudentService {

	@Override
	public String save(Student s) {
		
		IStudentDao studDao=StudentDaoFactory.getStudentDao();
		
		String msg=studDao.save(s);
		
		return msg;
	}

	@Override
	public String update(Student s) {
		IStudentDao studDao=StudentDaoFactory.getStudentDao();
		
		String msg=studDao.update(s);
		
		return msg;
	}

	@Override
	public String delete(int id) {
		
		IStudentDao studDao=new StudentDaoImple();
		String msg=studDao.delete(id);
		return msg;
	}

	@Override
	public String read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student search(int id) {
	
		IStudentDao studDao=StudentDaoFactory.getStudentDao();
		Student stud=studDao.search(id);
		return stud;
	}

}
