package com.kp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kp.dto.Student;
import com.kp.service.IStudentService;
import com.kp.studentFactory.StudentServiceFactory;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/controller/*")
public class ControllerServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public static Student student=null;
	
	public static void add(HttpServletRequest request,HttpServletResponse response) {
		
		String name=request.getParameter("sname");
		String age=request.getParameter("sage");
		String mail=request.getParameter("semail");
		String country=request.getParameter("saddr");
		
		student=new Student(name,age,mail,country);
		
		IStudentService studentService=StudentServiceFactory.getStudentService();
		
		String resp=studentService.add(student);
		
		System.out.println(resp);
		
		
		
		RequestDispatcher reqDp=request.getRequestDispatcher("../success.jsp");
		
		request.setAttribute("msg", resp);
		
		try {
			reqDp.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public static void delete(HttpServletRequest request, HttpServletResponse response) {
		
		String sid=request.getParameter("sid");
		
		IStudentService studService=StudentServiceFactory.getStudentService();
		
		String str = studService.deleteById(Integer.parseInt(sid));
		
		System.out.println(str);
	
		RequestDispatcher reqDp=request.getRequestDispatcher("../success.jsp");
		
		request.setAttribute("msg", str);
		
		try {
			reqDp.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void update(HttpServletRequest request, HttpServletResponse response) {
		
		String sid=request.getParameter("sid");
		
		IStudentService studService=StudentServiceFactory.getStudentService();
		
		Student student=studService.getByID(Integer.parseInt(sid));
		
		request.setAttribute("name", student.getName());
		request.setAttribute("age", student.getAge());
		request.setAttribute("email", student.getEmail());
		request.setAttribute("country", student.getCountry());
		
		RequestDispatcher reqDp=request.getRequestDispatcher("../editpage.jsp");
		
		try {
			reqDp.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void edit(HttpServletRequest request, HttpServletResponse response) {
		
		String name=request.getParameter("sname");
		String age=request.getParameter("sage");
		String mail=request.getParameter("semail");
		String country=request.getParameter("scountry");
		
		student=new Student(name,age,mail,country);
		
		IStudentService stdServ=StudentServiceFactory.getStudentService();
		
		String str=stdServ.edit(student);
		
		System.out.println(str);
		request.setAttribute("msg", str);
		RequestDispatcher reqDp=request.getRequestDispatcher("../success.jsp");
		
		
		
		try {
			reqDp.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void doProcess(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		
		String requestURI=request.getRequestURI();
		
		if(requestURI.endsWith("addForm")) {
			System.out.println("Add form..."); 
			add(request,response);
		}
		
		if(requestURI.endsWith("searchForm")) {
			
			System.out.println("Search Form....");
		}
		
		if(requestURI.endsWith("deleteForm")) {
			
			System.out.println("Delete Form...");
			delete(request,response);
		}
		
		if(requestURI.endsWith("updateForm")) {
			
			System.out.println("Update Form..");
			update(request,response);
		}
		if(requestURI.endsWith("editForm")) {
			
			System.out.println("edit Form..");
			edit(request,response);
		}
		
	}

}
