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
 * Servlet implementation class ReadServlet
 */
@WebServlet(
		urlPatterns = { "/read" }, 
		initParams = { 
				@WebInitParam(name = "url", value = "jdbc:mysql://127.0.0.1:3306/?user=root"), 
				@WebInitParam(name = "uname", value = "root"), 
				@WebInitParam(name = "pwd", value = "root@123")
		})
public class ReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Connection conn=null;  
    static
    {
    	System.out.println("ReadServlet loading...");
    }
    public ReadServlet() {
        super();
        System.out.println("ReadServlet instantiated..");
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
		
		String sqlQuery="select playerId,name,price from sys.players; ";
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
	try
	{
		if(conn!=null)
		{
			pstmt=conn.prepareStatement(sqlQuery);
			
			if(pstmt!=null)
			{
				resultSet=pstmt.executeQuery();
			}
			
		}
	}	
	catch(SQLException se)
	{
		se.printStackTrace();
	}
	
	PrintWriter out=response.getWriter();
	
	out.println("<html>");
	out.println("<style>");
	out.println("table, th, td {\r\n"
			+ "  border: 1px solid black;\r\n"
			+ "}");
	out.println("</style>");
	out.println("<body><h1 style=\"text-align:center;color:green;\">Players Data</h1>");
	out.println("<table align=\"center\" style=\"border: 1px solid black;\">");
	out.println("<tr>");
	out.println("<th>PlayerID</th><th>PlayerName</th><th>Price</th>");
	out.println("</tr>");
	try {
	while(resultSet.next())
	{
		out.println("<tr>");
		out.println("<td>"+resultSet.getString(1)+"</td><td>"+resultSet.getString(2)+"</td><td>"+resultSet.getString(3)+"</td>");
		out.println("</tr>");
		
	
	}
	}
	catch(SQLException se) {
		se.printStackTrace();
	}
	out.println("</table>");
	out.println("</body></html>");
	out.close();
	}

}
