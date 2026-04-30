package com.shivam.monocept.demo;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/hello")
public class ServletDemo extends HttpServlet  {
@Override
public void init() throws ServletException {
	System.out.println("Server started");
	
}
@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("Hello from Servlet ");
	}

@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
		System.out.println("Server Destroy");
	}
}
