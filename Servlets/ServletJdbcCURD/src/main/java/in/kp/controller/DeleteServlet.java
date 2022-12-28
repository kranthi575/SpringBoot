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
 * Servlet implementation class DeleteServlet
 */
@WebServlet(
		urlPatterns = { "/delete" }, 
		initParams = { 
				@WebInitParam(name = "url", value = "jdbc:mysql://127.0.0.1:3306/?user=root"), 
				@WebInitParam(name = "uname", value = "root"), 
				@WebInitParam(name = "pwd", value = "root@123")
		})

public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 private Connection conn=null;  
	    static
	    {
	    	System.out.println("DeleteServlet loading...");
	    }
	    public DeleteServlet() {
	        super();
	        System.out.println("DeleteServlet instantiated..");
	    }

	    @Override
	   	public void init() throws ServletException
	   	{
	       	ServletConfig config=getServletConfig(); 
	   		System.out.println("DeleteServlet is initialized...");
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
		
		String playerId=request.getParameter("playerId");
		
		String sqlQuery="delete from sys.players where playerId=?";
		PreparedStatement pstmt=null;
		int count=0;
	try {
		if(conn!=null)
		{
			pstmt=conn.prepareStatement(sqlQuery);
			if(pstmt!=null)
			{
				pstmt.setString(1,playerId);
				count=pstmt.executeUpdate();
				
			}
			
		}
	}
	catch(SQLException se)
	{
		se.printStackTrace();
	}
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	out.println("<htm><body>");
	if(count==1) {
		out.println("<h1 style='color:green;text-align:center;'>Deleted Succesfully</h1>");
		out.println("<a href='./menu.html'>Menu</a>");
	}
	else {
		out.println("<h1 style='color:red;text-align:center;'>Error in deleting player</h1>");
		out.println("<a href='./menu.html'>menu</a>");
	}
	out.println("</body></html>");
	out.close();
	}

}
