package com.kp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.DuplicateFormatFlagsException;
import java.util.List;
import java.util.Scanner;

public class JdbcUtil {
	
	
	public static Connection getJdbcConnection() throws SQLException, ClassNotFoundException
	{
		//::Resources::
		Connection conn=null;
		
		//server details
		//jdbc:mysql://port/?user=USERNAME
		String url="jdbc:mysql://localhost:3306/?user=root";
		String uname="root";
		String pwd="root@123";
		
		//Establishing the connection
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn=DriverManager.getConnection(url, uname, pwd);
		
		return conn;
	}
	
	
	public static void closeConnection(Connection conn,Statement stmt,ResultSet resultSet) throws SQLException
	{
		
		//closing connection
		
		if(conn!=null) {
			
			conn.close();
		}
		if(stmt!=null) {
			stmt.close();
		}
		if(resultSet!=null) {
			resultSet.close();
		}
		
		
	}
	//inserting row
	public static String Create(List list, String query) throws SQLException,ClassNotFoundException{
		//Resources
				Connection conn=null;
				PreparedStatement pstmt=null;
				
				
				String sqlQuery=query;
				
				conn=JdbcUtil.getJdbcConnection();
			try {	
				if(conn!=null)
				{
					pstmt=conn.prepareStatement(sqlQuery);
					if(pstmt!=null)
					{	
						int num=0;
						//setting parameters to pstmt
						for(Object val:list){
						pstmt.setString(num+1,(String)list.get(num) );
						num++;
						}
						if(!pstmt.execute())
						{
						return "account created successfuly";	
						}
						
					}
				}
			}
			catch(SQLIntegrityConstraintViolationException de)
			{
				return "username already found!pls enter unique username";
			}
				JdbcUtil.closeConnection(conn, pstmt, null);
				return "error in creating account";
			}
	
	//Reading table
	public static ResultSet Read(String query) throws SQLException,ClassNotFoundException {
		
		//Resources
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		String sqlQuery=query;
		
		conn=JdbcUtil.getJdbcConnection();
		if(conn!=null)
		{
			pstmt=conn.prepareStatement(sqlQuery);
			if(pstmt!=null)
			{
				resultSet=pstmt.executeQuery();
				if(resultSet!=null)
				{
					return resultSet;
				}
			}
			
		}
		
		
		JdbcUtil.closeConnection(conn, pstmt, resultSet);

		return resultSet;
		
	}

	//deleting row
	public static String Delete(String query) throws SQLException,ClassNotFoundException {
	
			//Resourrces
			Connection conn=null;
			PreparedStatement pstmt=null;
			
						
			String sqlQuery =query ;
				
			conn=JdbcUtil.getJdbcConnection();
			if(conn!=null) {
				pstmt=conn.prepareStatement(sqlQuery);
				
				if(!pstmt.execute());
					return "account  deleted successfully!!";
			
				}
			
			JdbcUtil.closeConnection(conn, pstmt, null);
			return "error in deleting account!";
			}
	//updating row
	public static String Update(String query) throws SQLException,ClassNotFoundException{
	
		//Resources
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		String sqlQuery=null;
							
			
		sqlQuery =query ;	
		
		conn=JdbcUtil.getJdbcConnection();
		if(conn!=null)
		{
			pstmt=conn.prepareStatement(sqlQuery);
			if(pstmt!=null)
			{
				//setting pstmt values
				
				if(pstmt.executeUpdate()==1)
				{
					return "Row updated successfuly!";
				}
				
			}
		
		}
		
		JdbcUtil.closeConnection(conn, pstmt, null);
		return "fail in updating row";
	
	}


		

}