package com.shivam.monocept.course;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/courses")
public class CourseCatlog extends HttpServlet {
	@Override
	   protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        String dept = request.getParameter("department");

	       
	        if (dept == null || dept.trim().isEmpty()) {
	            out.println("<h2 style='color:red;'>Department is required!</h2>");
	            return;
	        }

	       
	        List<String> courses = getCoursesByDepartment(dept);

	        if (courses == null) {
	            out.println("<h2 style='color:red;'>Invalid Department!</h2>");
	            return;
	        }

	       
	        out.println("<h1>Course List</h1>");
	        out.println("<h2>Department: " + dept.toUpperCase() + "</h2>");
	        out.println("<ul>");

	        for (String course : courses) {
	            out.println("<li>" + course + "</li>");
	        }

	        out.println("</ul>");
	    }

	  
	    private List<String> getCoursesByDepartment(String dept) {

	        dept = dept.toUpperCase();

	        if (dept.equals("CS")) {
	            return List.of(
	                "Data Structures",
	                "Operating Systems",
	                "Database Management System",
	                "Computer Networks"
	            );
	        } 
	        else if (dept.equals("ME")) {
	            return List.of(
	                "Thermodynamics",
	                "Fluid Mechanics",
	                "Machine Design",
	                "Heat Transfer"
	            );
	        } 
	        else if (dept.equals("EE")) {
	            return List.of(
	                "Circuit Theory",
	                "Power Systems",
	                "Electrical Machines",
	                "Control Systems"
	            );
	        }

	        return null; 
	    }
	}

