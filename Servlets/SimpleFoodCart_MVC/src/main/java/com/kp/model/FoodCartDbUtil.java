package com.kp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodCartDbUtil {
	
	public static List<Food> getFoodItems()
	{
	//Resources
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet resultSet=null;
	
	List<Food> items=new ArrayList();
	
	String sqlQuery="select name,price from sys.fooditems;";
	try {
		conn=JdbcUtil.getJdbcConnection();
		
		if(conn!=null)
		{
			pstmt=conn.prepareStatement(sqlQuery);
			
			if(pstmt!=null)
			{
				resultSet=pstmt.executeQuery();
				if(resultSet!=null) 
				{
					while(resultSet.next())
					{
					String name=resultSet.getString(1);
					int price=resultSet.getInt(2);
					
					Food f=new Food(name,price);
					
					items.add(f);
					}
				}
			}
		}	
	} catch (SQLException | ClassNotFoundException e) {
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
		
	return items;
	}

}
