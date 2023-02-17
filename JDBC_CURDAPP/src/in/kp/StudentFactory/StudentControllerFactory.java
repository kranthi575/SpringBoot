package in.kp.StudentFactory;

import in.kp.controller.StudentController;
import in.kp.controller.StudentControllerImple;

public class StudentControllerFactory {
	
	public static StudentController studentController=null;
	
	public static StudentController getStudentController()
	{
		if(studentController == null)
			studentController=new StudentControllerImple();
		
		return studentController;
	}

}
