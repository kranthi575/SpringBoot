package com.kp.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImgResponse
 */
@WebServlet("/Img")
public class ImgResponse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	static
	{
		System.out.println("servlet is loading.....");
	}
    public ImgResponse() {
        super();
        // TODO Auto-generated constructor stub
        System.out.println("Servlet instantiating....");
    }
    @Override
    public void init() throws ServletException
    {
    	System.out.println("Servlet initialized..");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//response.setContentType("text/html");
		//response.setContentType("video/mp4");
		response.setContentType("application/pdf");
		
		ServletOutputStream outStream=response.getOutputStream();
		
		String path=getServletContext().getRealPath("sample.pdf");
		
		File f=new File(path);
		//File f=new File("E:\\GoToTraining 000.png");
		
		FileInputStream fis=new FileInputStream(f);
		
		byte[] b =new byte[(int)f.length()];
		
		fis.read(b); //Reading the file and placing into byte array.
		
		outStream.write(b);
		outStream.flush();
		outStream.close();
		fis.close();
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
