package in.kp.Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
	
	
	public static Connection getJdbcConnection() throws SQLException
	{
		//::Resources::
		Connection conn=null;
		try {
			
		//Properties prop=new Properties();
		
		//FileInputStream fis=new FileInputStream("db.properties");
		
		//prop.load(fis);
		
		//String url=prop.getProperty("url");
		//String uname=prop.getProperty("uname");
		//String pwd=prop.getProperty("pwd");
		String url="jdbc:mysql://127.0.0.1:3306/?user=root";
		String uname="root";
		String pwd="root";
		//Establishing the connection
		conn=DriverManager.getConnection(url, uname, pwd);
		}
		catch(Exception fe)
		{
			fe.printStackTrace();
		}
		
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

}