package com.kp.studentFactory;

import com.kp.dao.IStudentDao;
import com.kp.dao.StudentDaoImple;

public class StudentDaoFactory {

	public static IStudentDao studentDao=null;
	
	public static IStudentDao getStudentDao() {

		if(studentDao == null) {
			
			studentDao=new StudentDaoImple();
			
		}
		return studentDao;
	}
}
