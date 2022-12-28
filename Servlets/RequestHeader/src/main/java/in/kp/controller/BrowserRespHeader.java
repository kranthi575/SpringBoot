package in.kp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BrowserRespHeader
 */
@WebServlet("/test")
public class BrowserRespHeader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	static
	{
		System.out.println("Servlet loading..");
	}
    public BrowserRespHeader() {
        super();
        // TODO Auto-generated constructor stub
        System.out.println("Server instantiation......");
    }
    @Override
    public void init() throws ServletException
    {
    	System.out.println("Servlet intialized...");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("RequestResponse for GET Request Type");
		
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		out.println("<htm><head><title>Output</title></head>");
		out.println("<body>");
		out.println("<h1>Request Header Information...</h1>");
		
		Enumeration<String> headerNames=request.getHeaderNames();
		
		out.println("<table border='1' align='center'>");
		out.println("<tr><th>HeaderName</th><th>HeaderValue</th></tr>");
		
		while(headerNames.hasMoreElements())
		{
			out.println("<tr>");
			String headerName=(String)headerNames.nextElement();
			String headerValue=request.getHeader(headerName);
			
			out.println("<td>"+headerName+"</td><td>"+headerValue+"</td>");
			
			out.println("</tr>");
		}
		
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	@Override
	public void destroy()
	{
		System.out.println("Servlet DeInstantiation...");
	}

}
