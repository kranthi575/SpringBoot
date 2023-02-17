package com.kp.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.kp.model.Student;
import com.kp.util.HibernateUtil;

public class StudentDaoImple implements IStudentDao {

	@Override
	public String save(Student s) {
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		String msg=null;
		try {
		session=HibernateUtil.getSession();
		transaction=session.beginTransaction();
		
		session.save(s);
		flag=true;
		
		}
		catch(HibernateException hbe) {
			hbe.printStackTrace();
			msg = "error in save operation";
		}
		finally {
			try {
				if(flag==true) {
					transaction.commit();
					msg= "Student Object Successfull added to database";
				}
				else {
					msg= "error in save operation::";
				}
				//HibernateUtil.closeSession(session);
			}catch(HibernateException hbe) {
				hbe.printStackTrace();
				
			}
		}
		return msg;
		
	}

	@Override
	public String update(Student s) {
	
		String msg=null;
		Session session=null;
		Transaction transaction=null;
		Boolean flag=false;
		try {
			
			session=HibernateUtil.getSession();
			transaction=session.beginTransaction();
			
			session.update(s);
			flag=true;
			
			
		}catch(HibernateException hbe) {
			hbe.printStackTrace();
		}finally {
			try {
				if(flag==true) {
					transaction.commit();
					msg="Successfully updated student object from database";
				}
				
				//HibernateUtil.closeSession(session);
				
								
				
			}catch(HibernateException hbe){
				hbe.printStackTrace();
				msg="error in update operation";
			}
		}
		
		return msg;
	}

	@Override
	public String delete(int id) {
		
		boolean flag=false;
		Transaction transaction=null;
		Session session=null;
		String msg=null;
		try{
			
			session=HibernateUtil.getSession();
			transaction=session.beginTransaction();
			Student stud=session.get(Student.class,id);
			if(stud!=null) {
			session.delete(stud);
			flag=true;}
			
		}catch(HibernateException hbe) {
			hbe.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
			msg=" error in delete operation";
		}finally {
			try {
				if(flag==true) {
					transaction.commit();
					msg = "Successfully deleted student object from database";
					//HibernateUtil.closeSession(session);
				}
								
				
			}catch(HibernateException hbe){
				hbe.printStackTrace();
				msg ="error in delete operation";
			}
		}
		
		return msg;
	}

	@Override
	public String read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student search(int id) {
	
		Student stud=null;
		Session session=null;
		Transaction transaction=null;
		Boolean flag=false;
		
		
		try {
			session=HibernateUtil.getSession();
			transaction=session.beginTransaction();
			stud=session.get(Student.class, id);
			transaction.commit();
			return stud;
			
			
		}
		catch(HibernateException hbe) {
			hbe.printStackTrace();
		}
		
		return stud;
	}

}
