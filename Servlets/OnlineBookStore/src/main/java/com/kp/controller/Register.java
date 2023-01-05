package com.kp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kp.model.JdbcUtil;


@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Register() {
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<String> list=new ArrayList<String>();
		String uname=request.getParameter("uname");
		list.add(uname);
		String name=request.getParameter("name");
		list.add(name);
		String phnno=request.getParameter("phnno");
		list.add(phnno);
		String email=request.getParameter("email");
		list.add(email);
		String city=request.getParameter("city");
		list.add(city);
		String pwd=request.getParameter("pwd");
		list.add(pwd);
		RequestDispatcher dispatcher=null;
		if(uname==""||name==""||phnno==""||email==""||city==""||pwd=="")
		{
			request.setAttribute("msg","details should be empty");
		}
		else {
		String sqlQuery="insert into bookstore.account_details(`uname`,`name`,`phnno`,`email`,`city`,`pwd`) values(?,?,?,?,?,?)";
		String msg=null;
		try {
			msg=JdbcUtil.Create(list,sqlQuery);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("msg",msg);
		}
		dispatcher=request.getRequestDispatcher("./reg");
		
		dispatcher.forward(request, response);
		
		
	}

}
