package in.kp.StudentFactory;

import in.kp.service.StudentService;
import in.kp.service.StudentServiceImple;

public class StudentServiceFactory {
	
	public static StudentService studentService;
	
	public static StudentService getStudentService()
	{
		if(studentService == null)
			studentService=new StudentServiceImple();
		
		return studentService;
	}

}
