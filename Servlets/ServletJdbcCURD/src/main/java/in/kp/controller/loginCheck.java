package in.kp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginCheck
 */
@WebServlet(
		urlPatterns = { "/loginCheck" }, 
		initParams = { 
				@WebInitParam(name = "url", value = "jdbc:mysql://127.0.0.1:3306/?user=root"), 
				@WebInitParam(name = "uname", value = "root"), 
				@WebInitParam(name = "pwd", value = "root@123")
		})
public class loginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private Connection conn=null; 
	static
	{
		System.out.println("loginCheckServlet loading...");
	}
    public loginCheck() {
        super();
        System.out.println("loginCheckServlet instantiation..");
    }
    @Override
	public void init() throws ServletException
	{
    	ServletConfig config=getServletConfig(); 
		System.out.println("RegisterServlet is initialized...");
		String url=config.getInitParameter("url");
		String uname=config.getInitParameter("uname");
		String pwd=config.getInitParameter("pwd");
	try 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn=DriverManager.getConnection(url,uname,pwd);
	}
	catch(SQLException se)
	{
		se.printStackTrace();
	}
	catch(ClassNotFoundException ce)
	{
		ce.printStackTrace();
	}
	
	}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	String uname=request.getParameter("uname");
    	String pwd=request.getParameter("pwd");
    	
    	String sqlQuery="select password from sys.cricket_teams where name=?";
    	PreparedStatement pstmt=null;
    	ResultSet resultSet=null;
    	boolean flag=false;
    try
    {
    	if(conn!=null)
    
    	{
    		pstmt=conn.prepareStatement(sqlQuery);
    		if(pstmt!=null)
    		{
    			pstmt.setString(1,uname);
    			resultSet=pstmt.executeQuery();
    			System.out.println("before resultSet...");
    			if(resultSet!=null)
    			{
    				System.out.println("entered resultset,..");
    				System.out.println(resultSet.toString());
    				
    				if(resultSet.next()) {
    				String password=resultSet.getString(1);
    				
    				System.out.println(password);
    				if(password.equalsIgnoreCase(pwd))
    					flag=true;
    				}
    			}
    			
    		}
    	}
    	
	}
    catch(SQLException se)
    {
    	se.printStackTrace();
    }
    
    PrintWriter out=response.getWriter();
    
    out.println("<html><body>");
    if(flag)
    out.println("<h1 >Login successfully!</h1>");
    else
    	out.println("<h1>enter correct credentials!</h1>");
    
    out.close();
    
   }
}
