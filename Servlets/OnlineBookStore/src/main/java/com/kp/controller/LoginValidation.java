package com.kp.controller;
import com.kp.model.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginValidation")
public class LoginValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
	public void init(){
    	
	 
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String uname=request.getParameter("uname");
	String pwd=request.getParameter("pwd");
	String query="SELECT * FROM bookstore.accounts";
	
	ResultSet resultSet=null;
	RequestDispatcher dispatcher=null;
	String msg=null;
	
	try {
		resultSet=JdbcUtil.Read(query);
		
		while(resultSet.next()) {
			String name=resultSet.getString(1);
			if(name.equalsIgnoreCase(uname))
			{
				if(pwd.equalsIgnoreCase(resultSet.getString(3))) {
					msg="Logged in successfully!";
				}
				else
				{
					msg="enter correct password";
					dispatcher=request.getRequestDispatcher("./login");
				}
			}
		}
		if(msg==null)
		{
			msg="No Account Found! Pls Register before login";
			dispatcher=request.getRequestDispatcher("./login");
		}
		
	} catch (ClassNotFoundException | SQLException e) {
		
		e.printStackTrace();
	}
	request.setAttribute("msg",msg);
	dispatcher.forward(request, response);
	}

}
