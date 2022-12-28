package in.kp.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BrowserResponseHeader
 */
@WebServlet("/test")
public class BrowserResponseHeader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	static
	{
		System.out.println("Servlet is loading");
	}
	
    public BrowserResponseHeader() {
        super();
        System.out.println("Servket  instantiating..");
    }
    
    @Override
	public void init() throws ServletException
	{
    	System.out.println("Servlet is intialized..");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	response.setContentType("text/html");
	
	System.out.println("Request processing for GET request...");
	
	System.out.println("Clieni IP Address:"+request.getRemoteAddr());
	System.out.println("Client Host::"+request.getRemoteHost());
	System.out.println("Client Port::"+request.getRemotePort());
	System.out.println("Seerver name::"+request.getServerName());
	System.out.println("Server port::"+request.getServerPort());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
