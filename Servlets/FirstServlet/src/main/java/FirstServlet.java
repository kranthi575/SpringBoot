import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpResponse;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "FirstServlet", urlPatterns = { "/test" })

public class  FirstServlet implements Servlet
{

	static{
		System.out.println("Servlet Loading....");
	}

	public FirstServlet(){
		System.out.println("Servlet Instantiation...");
	}

	//life cycle methods
	public void init(ServletConfig config)throws ServletException{
		//Servlet Initialization phase
		System.out.println("Servlet is initialized...");
	}

	public void service(ServletRequest request, ServletResponse response) throws ServletException,IOException{
		//Request-Processing-logic
		System.out.println("providing the service for the users");

		// 1. Set the response type to HTML
			response.setContentType("text/html");

		// 2. Use PrintWriter object  to send the response
			PrintWriter out = response.getWriter();
			out.println("<html><head><title>Output</title></head>");
			out.println("<body>");
			out.println("<h1 style='color:red'><marquee>Welcome to servlet coding...</marquee></h1>");
			out.println("</body>");
			out.println("</html>");

		// 3. Close the PrintWriter
			out.close();
	}

	public void destroy(){
		// Deinstantiation activities
		System.out.println("Servlet DeInstantiation....");
	}

	public ServletConfig getServletConfig(){
		return null;

	}
	public String getServletInfo(){
		return "Developed by nitin";
	}
	}
