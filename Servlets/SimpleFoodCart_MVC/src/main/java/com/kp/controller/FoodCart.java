package com.kp.controller;
import com.kp.model.*;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FoodCart")
public class FoodCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	static
	{
		System.out.println("FoodCart loading...");
	}
    public FoodCart() {
        super();
        System.out.println("FoodCart instantiated..");
    }
    @Override
    public void init()
    {
    	System.out.println("FoodCart initialized..");
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Food> items=FoodCartDbUtil.getFoodItems();
		System.out.println(request.getLocalAddr());
		System.out.println(request.getContextPath());
		System.out.println(request.getPathInfo());
		System.out.println(request);
		String addr=request.getRemoteAddr();
		String str=request.getRequestURI();
		request.setAttribute("foodItems",items);
		request.setAttribute("url",str);
		request.setAttribute("addr",addr);
		RequestDispatcher dispatcher=request.getRequestDispatcher("menu.jsp");
		
		dispatcher.forward(request, response);
		
	}

}
