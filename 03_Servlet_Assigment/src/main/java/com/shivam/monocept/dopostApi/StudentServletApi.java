package com.shivam.monocept.dopostApi;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class StudentServletApi extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String ageStr = request.getParameter("age");
        String course = request.getParameter("course");

        boolean hasError = false;

        // Validation
        if (name == null || name.trim().isEmpty()) {
            out.println("<p style='color:red;'>Name is required!</p>");
            hasError = true;
        }

        if (email == null || email.trim().isEmpty()) {
            out.println("<p style='color:red;'>Email is required!</p>");
            hasError = true;
        }

        int age = 0;
        try {
            age = Integer.parseInt(ageStr);
            if (age < 18) {
                out.println("Age must be 18 or above!");
                hasError = true;
            }
        } catch (Exception e) {
            out.println("<p style='color:red;'>Invalid age!</p>");
            hasError = true;
        }

        if (course == null || course.isEmpty()) {
            out.println("<p style='color:red;'>Please select a course!</p>");
            hasError = true;
        }

        
        if (hasError) {
            return;
        }

        
        out.println("<h1 style='color:green;'>Registration Successful!</h1>");
        out.println("<h3>Student Details:</h3>");
        out.println("<p><b>Name:</b> " + name + "</p>");
        out.println("<p><b>Email:</b> " + email + "</p>");
        out.println("<p><b>Age:</b> " + age + "</p>");
        out.println("<p><b>Course:</b> " + course + "</p>");
    }
}