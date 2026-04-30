package com.shivam.monocept.formhandler;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/show")
public class FormHandler extends HttpServlet {
@Override
public void init() throws ServletException {
	// TODO Auto-generated method stub
	System.out.println("Start Server");
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
    resp.setContentType("text/html");

   
    String name = req.getParameter("name");
    String age = req.getParameter("age");
    String studentClass = req.getParameter("class");
    String percentage = req.getParameter("percentage");
    String branch = req.getParameter("branch");

    PrintWriter out = resp.getWriter();

    out.println("<html><body>");
    out.println("<h2>Student Details</h2>");

    out.println("<p><b>Name:</b> " + name + "</p>");
    out.println("<p><b>Age:</b> " + age + "</p>");
    out.println("<p><b>Class:</b> " + studentClass + "</p>");
    out.println("<p><b>Percentage:</b> " + percentage + "</p>");
    out.println("<p><b>Branch:</b> " + branch + "</p>");

    out.println("</body></html>");
	}
}
