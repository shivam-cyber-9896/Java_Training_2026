package com.shivam.monocept.studentservlet;



import java.io.IOException;
import java.io.PrintWriter;

import com.shivam.monocept.student.serviecs.StudentDao;
import com.shivam.monocept.vaildation.inputVaildation;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
StudentDao student = new StudentDao();
    
    public void init() {
        System.out.println("Servlet Started...");
    }

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String error = request.getParameter("error");

        out.println("<html><head>");
        out.println("<title>Register</title>");
        out.println("<link rel='stylesheet' href='style.css'>");
        out.println("</head><body>");

        out.println("<div class='container'>");
        out.println("<h2>Student Registration</h2>");

       
        if (error != null) {
            out.println("<p class='error'>" + error + "</p>");
        }

        out.println("<form method='post' action='register'>");

        out.println("<input type='text' name='name' placeholder='Enter Name'><br>");
        out.println("<input type='email' name='email' placeholder='Enter Email'><br>");
        out.println("<input type='number' name='age' placeholder='Enter Age'><br>");

        out.println("<select name='course'>");
        out.println("<option value=''>Select Course</option>");
        out.println("<option>Java Full Stack</option>");
        out.println("<option>Python Full Stack</option>");
        out.println("<option>MERN Stack</option>");
        out.println("<option>Data Analytics</option>");
        out.println("</select><br>");

        out.println("<select name='batch'>");
        out.println("<option value=''>Select Batch</option>");
        out.println("<option>Morning</option>");
        out.println("<option>Afternoon</option>");
        out.println("<option>Evening</option>");
        out.println("</select><br>");

        out.println("<button type='submit'>Register</button>");
        out.println("</form>");

        out.println("</div></body></html>");
    }

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String ageStr = request.getParameter("age");
        String course = request.getParameter("course");
        String batch = request.getParameter("batch");

        int age = 0;
        try {
            age = Integer.parseInt(ageStr);
        } catch (Exception e) {}

        String error = inputVaildation.validate(name, email, age, course, batch);
        if (error != null) {
            response.sendRedirect("register?error=" + error);
            return;
        }
        try {
			student.addStudent(name, email, age, course, batch);
		} catch (Exception e) {
			e.printStackTrace();
		}
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head>");
        out.println("<link rel='stylesheet' href='style.css'>");
        out.println("</head><body>");

        out.println("<div class='container'>");
        out.println("<h2 style='color:green;'>Registration Successful 🎉</h2>");

        out.println("<p><b>Name:</b> " + name + "</p>");
        out.println("<p><b>Email:</b> " + email + "</p>");
        out.println("<p><b>Age:</b> " + age + "</p>");
        out.println("<p><b>Course:</b> " + course + "</p>");
        out.println("<p><b>Batch:</b> " + batch + "</p>");

        out.println("</div></body></html>");
    }

    public void destroy() {
    	
        System.out.println("Servlet Destroyed...");
    }
}