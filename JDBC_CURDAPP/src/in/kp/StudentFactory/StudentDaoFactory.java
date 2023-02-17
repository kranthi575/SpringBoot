package in.kp.StudentFactory;

import in.kp.dao.StudentDao;
import in.kp.dao.StudentDaoImple;

public class StudentDaoFactory {
	
	public static StudentDao studentDao=null;
	
	public static StudentDao getStudentDao()
	{
		if(studentDao == null)
			studentDao=new StudentDaoImple();
		
		return studentDao;
	}

}
