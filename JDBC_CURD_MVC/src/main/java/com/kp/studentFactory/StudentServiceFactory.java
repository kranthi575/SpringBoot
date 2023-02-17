package com.kp.studentFactory;

import com.kp.service.IStudentService;
import com.kp.service.StudentServiceImple;

public class StudentServiceFactory {
	
	public static IStudentService studentService=null;
	
	public static IStudentService getStudentService() {
		if(studentService == null)
			studentService=new StudentServiceImple();
		return studentService;
	}

}
