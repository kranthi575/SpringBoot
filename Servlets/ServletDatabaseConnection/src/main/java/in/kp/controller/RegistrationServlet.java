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
 * Servlet implementation class RegistrationServlet
 */
@WebServlet(
		urlPatterns = { "/reg" }, 
		initParams = { 
				@WebInitParam(name = "url", value = "jdbc:mysql://127.0.0.1:3306/?user=root"), 
				@WebInitParam(name = "uname", value = "root"), 
				@WebInitParam(name = "pwd", value = "root@123")
		})
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	//private ServletConfig config=getServletConfig();
       
    	static
	{
		System.out.println("Servlet loading..");
	}
    public RegistrationServlet() 
    {
    	
        super();
        System.out.println("Servlet instantiating...");
    }
    
    @Override
	public void init() throws ServletException
    {
    	ServletConfig config = getServletConfig();
    	System.out.println("servlet initialized...");
    	System.out.println("Establishing JDBC connection::");
    try {
    		String url=config.getInitParameter("url");
    		String uname=config.getInitParameter("uname");
    		String pwd=config.getInitParameter("pwd");
    		
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		conn=DriverManager.getConnection(url,uname,pwd);
    	}
    catch(SQLException se)
    	{
    		se.printStackTrace();
    	}
    catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,NullPointerException
	{
		System.out.println("doGet...");
		String name=request.getParameter("name");
		String mail=request.getParameter("mail");
		String country=request.getParameter("country");
		String phnno=request.getParameter("phnNo");
		
		int rowCount=0;
		
		String sqlQuery="insert into sys.student(`name`,`email`,`country`,`phnno`) values(?,?,?,?)";
	try 
	{
		if(conn!=null)
		{
		System.out.println("connection established.");
		pstmt=conn.prepareStatement(sqlQuery);
		
		pstmt.setString(1, name);
		pstmt.setString(2, mail);
		pstmt.setString(3, country);
		pstmt.setString(4, phnno);
		
		rowCount=pstmt.executeUpdate();
		System.out.println("Pstmt executed....");
		}
	}
	catch(SQLException se)
	{
		se.printStackTrace();
	}
	
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	
	out.println("<html><body>");
	if(rowCount==1)
		out.println("<h1 style='color:green;text-align:center;'>Registered Succesfully</h1>");
	else 
	{
		out.println("<h1 style='color:red;text-align:center;'>Error in registartion</h1>");
		out.println("<a href='./Register.html'>Register Here</a>");
		
	}
	out.println("</body></html>");
	out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	@Override
	public void destroy()
	{
		System.out.println("servlet DeInstantiated..");
	}

}
