package com.shivam.monocept.dopostApi;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/resume")
public class ResumeUploadServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String resume = request.getParameter("resume");
        String skills = request.getParameter("skills");

        // 🔥 Validation
        String error = validateInput(name, email, skills);

        if (error != null) {
            out.println("<h2 style='color:red;'>" + error + "</h2>");
            return;
        }

        // 🔥 Parse skills
        String[] skillList = skills.split(",");

        // ✅ Output Resume Preview
        out.println("<h1 style='color:green;'>Resume Preview</h1>");
        out.println("<p><b>Name:</b> " + name + "</p>");
        out.println("<p><b>Email:</b> " + email + "</p>");

        out.println("<h3>Skills:</h3><ul>");
        for (String skill : skillList) {
            out.println("<li>" + skill.trim() + "</li>");
        }
        out.println("</ul>");

        if (resume != null && !resume.trim().isEmpty()) {
            out.println("<h3>Summary:</h3>");
            out.println("<p>" + resume + "</p>");
        }
    }

    // ✅ Separate validation function
    private String validateInput(String name, String email, String skills) {

        if (name == null || name.trim().length() < 3) {
            return "Name must be at least 3 characters!";
        }

        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            return "Invalid email format!";
        }

        if (skills == null || skills.trim().isEmpty()) {
            return "At least one skill is required!";
        }

        return null;
    }
}