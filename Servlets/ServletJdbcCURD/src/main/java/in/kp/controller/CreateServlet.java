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

@WebServlet(
		urlPatterns = { "/create" }, 
		initParams = { 
				@WebInitParam(name = "url", value = "jdbc:mysql://127.0.0.1:3306/?user=root"), 
				@WebInitParam(name = "uname", value = "root"), 
				@WebInitParam(name = "pwd", value = "root@123")
		})
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Connection conn=null;  
    static
    {
    	System.out.println("CreateServlet loading...");
    }
    public CreateServlet() {
        super();
        System.out.println("CreateServlet instantiated..");
        
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
		
		String playerId=request.getParameter("playerId");
		String playerName=request.getParameter("playerName");
		int price=Integer.parseInt(request.getParameter("playerPrice"));
		
		String sqlQuery="insert into sys.players(`playerId`,`name`,`price`) values(?,?,?)";
		PreparedStatement pstmt=null;
		int rowCount=0;
		
	try
	{
		if(conn!=null)
	
		{
			System.out.println("connection established..");
			pstmt=conn.prepareStatement(sqlQuery);
			if(pstmt!=null)
			{
				pstmt.setString(1,playerId);
				pstmt.setString(2,playerName);
				pstmt.setInt(3,price);
				
				rowCount=pstmt.executeUpdate();
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
	if(rowCount==1) {
		out.println("<h1 style='color:green;text-align:center;'>Created Succesfully</h1>");
		out.println("<a href='./menu.html'>Menu</a>");
	}
	else {
		out.println("<h1 style='color:red;text-align:center;'>Error in adding player</h1>");
		out.println("<a href='./menu.html'>menu</a>");
	}
	out.println("</body></html>");
	out.close();
	}

}
