package in.kp.service;

import in.kp.StudentFactory.StudentDaoFactory;
import in.kp.dao.StudentDao;
import in.kp.dto.Student;

public class StudentServiceImple implements StudentService {

	@Override
	public String save(Student s) {
		
		StudentDao stdDao=StudentDaoFactory.getStudentDao();
		
		String str=stdDao.save(s);
		
		return str;
	}

	@Override
	public Student findById(int id) {
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
