package in.kp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.kp.Util.JdbcUtil;
import in.kp.dto.Student;

public class StudentDaoImple implements StudentDao {

	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet resultSet=null;
	
	
	@Override
	public String save(Student s) {
		
		
		try {
			conn=JdbcUtil.getJdbcConnection();
			
			String name=s.getName();
			String email=s.getEmail();
			String city=s.getCity();
			String country=s.getCountry();
			
			String sqlQuery="insert into enterprisejava.stud(`name`,`email`,`city`,`country`) values(?,?,?,?)";
			if(conn!=null) {
				
				pstmt=conn.prepareStatement(sqlQuery);
				if(pstmt!=null) {
					
				pstmt.setString(1,name);
				pstmt.setString(2, email);
				pstmt.setString(3,city);
				pstmt.setString(4, country);
				
				if(!pstmt.execute())
					return "succesfully saved";
				else
					return "Not saved";
				}
			}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		return null;
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
