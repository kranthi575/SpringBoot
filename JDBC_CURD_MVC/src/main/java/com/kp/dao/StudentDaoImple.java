package com.kp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kp.dto.Student;
import com.kp.studentFactory.StudentDaoFactory;
import com.kp.util.JdbcUtil;

public class StudentDaoImple implements IStudentDao {

	static Connection conn=null;
	static PreparedStatement pstmt=null;
	static ResultSet resultSet=null;
	 Student student=null; 
	static int edit_id;
	@Override
	public String add(Student stud) {
		
		try {
			
			String name=stud.getName();
			int age=stud.getAge();
			String email=stud.getEmail();
			String country=stud.getCountry();
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			String url="jdbc:mysql://127.0.0.1:3306/?user=root";
//			String uname="root";
//			String pwd="root";
//			//Establishing the connection
//			conn=DriverManager.getConnection(url, uname, pwd);
//			
			String sqlQuery="insert into enterprisejava.student_mvc(`name`,age,`email`,`country`) values(?,?,?,?)";
			
			conn=JdbcUtil.getJdbcConnection();
			if(conn!=null) {
				
				pstmt=conn.prepareStatement(sqlQuery);
				if(pstmt!=null) {
					
					pstmt.setString(1,name);
					pstmt.setInt(2, age);
					pstmt.setString(3, email);
					pstmt.setString(4,country);
					
					if(!pstmt.execute()) {
						return "sucessfully added";
					}
					else
					{
						return "error in adding student";
					}
				}
			}
			
		} catch (SQLException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Student getById(int id) {
		student=null;
		edit_id=id;
	try {
		 String sqlQuery="select name,age,email,country from enterprisejava.student_mvc where id=?";
		 conn=JdbcUtil.getJdbcConnection();
		 
		 if(conn!=null) {
			 
			 pstmt=conn.prepareStatement(sqlQuery);
			 if(pstmt!=null) {
				 
				 pstmt.setInt(1, id);
				 
				 resultSet=pstmt.executeQuery();
				 if(resultSet!=null) {
					 
					 while(resultSet.next()) {
						String name=resultSet.getString(1);
						String age=Integer.toString(resultSet.getInt(2));
						String mail=resultSet.getString(3);
						String country=resultSet.getString(4);
						
						student=new Student(name,age,mail,country);
						 
					 }
					
				 }
			 }
			 
		 }
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
			try {
				JdbcUtil.closeConnection(conn, pstmt, resultSet);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
	    return student;
	}

	@Override
	public String deleteById(int id) {
		
		String msg=null;
		try {
		
			//validating ID
			IStudentDao studDao=StudentDaoFactory.getStudentDao();
			Student stud=studDao.getById(id);
			System.out.println(stud);
			if(stud==null)
				return "Requested Id is not found in db";
			String sqlQuery="delete from enterprisejava.student_mvc where id=?";
			conn=JdbcUtil.getJdbcConnection();
			
			if(conn!=null) {
				
				pstmt=conn.prepareStatement(sqlQuery);
				if(pstmt!=null) {
					
					pstmt.setInt(1, id);
					if(!pstmt.execute()) {
						msg="deleted successfully";
//						studDao=null;
					}
					else
						msg="error in deleting student";
//					studDao=null;
				}
				studDao=null;
				
			}
			System.out.println(msg);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
			try {
				JdbcUtil.closeConnection(conn, pstmt, resultSet);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return msg;
	}
	
	@Override
	public String edit(Student s) {
		
		try {
			String sqlQuery="update enterprisejava.student_mvc set name=?,age=?,email=?,country=? where id=?";
			conn=JdbcUtil.getJdbcConnection();
			if(conn!=null) {
				
				pstmt=conn.prepareStatement(sqlQuery);
				if(pstmt!=null) {
					
					pstmt.setString(1,s.getName());
					pstmt.setInt(2,s.getAge());
					pstmt.setString(3,s.getEmail());
					pstmt.setString(4, s.getCountry());
					pstmt.setInt(5,edit_id);
					
					if(!pstmt.execute()) {
						return "updated successfully";
					}
					else
						return "error in updating value";
					
					
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
