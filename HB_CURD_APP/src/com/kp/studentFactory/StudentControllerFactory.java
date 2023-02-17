package com.kp.studentFactory;

import com.kp.controller.IStudentController;
import com.kp.controller.StudentControllerImple;

public class StudentControllerFactory {

	public static IStudentController studentController=null;
	
	public static IStudentController getStudentController() {
		
		if(studentController==null) {
			studentController=new StudentControllerImple();
		}
		return studentController;
	}
}
