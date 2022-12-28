package in.kp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet(
		urlPatterns = { "/register" }, 
		initParams = { 
				@WebInitParam(name = "url", value = "jdbc:mysql://127.0.0.1:3306/?user=root"), 
				@WebInitParam(name = "uname", value = "root"), 
				@WebInitParam(name = "pwd", value = "root@123")
		})
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn=null;

	static
	{
		System.out.println("RegisterServlet is loading...");
	}
	public RegisterServlet()
	{
		System.out.println("RegisterServlet instantiation...");
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
	
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("pwd");
		String team=request.getParameter("team");
		
		String sqlQuery="insert into sys.cricket_teams(`name`,`email`,`password`,`team`) values(?,?,?,?)";
		PreparedStatement pstmt=null;
		int rowCount=0;
	try 
	{	if(conn!=null)
		{
			pstmt=conn.prepareStatement(sqlQuery);
			
			if(pstmt!=null)
			{
				pstmt.setString(1,name);
				pstmt.setString(2,email);
				pstmt.setString(3,password);
				pstmt.setString(4, team);
			}
			rowCount=pstmt.executeUpdate();
			
		}
	}
	catch(SQLException se)
	{
		se.printStackTrace();
	}
	
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	out.println("<htm><body>");
	if(rowCount==1) {
		out.println("<h1 style='color:green;text-align:center;'>Registered Succesfully</h1>");
		out.println("<a href='./login.html'>Login here</a>");
	}
	else {
		out.println("<h1 style='color:red;text-align:center;'>Error in registartion</h1>");
		out.println("<a href='./register.html'>Register here</a>");
	}
	out.println("</body></html>");
	out.close();
}
}
