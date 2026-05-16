package com.shivam.monocept.exam.servlet;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/result")
public class ExamEvaluterServlet extends HttpServlet {

    public void init() {
        System.out.println("Servlet Initialized");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String roll = request.getParameter("roll");
        String m1Str = request.getParameter("m1");
        String m2Str = request.getParameter("m2");
        String m3Str = request.getParameter("m3");

       
        if (name == null || name.trim().isEmpty() ||!name.matches("[a-zA-Z ]+") ||
            roll == null || roll.trim().isEmpty() ||
            m1Str == null || m2Str == null || m3Str == null) {

            response.sendRedirect("exam.jsp");
            return;
        }

        int m1, m2, m3;

        try {
            m1 = Integer.parseInt(m1Str);
            m2 = Integer.parseInt(m2Str);
            m3 = Integer.parseInt(m3Str);
        } catch (NumberFormatException e) {
            response.sendRedirect("exam.jsp");
            return;
        }

      
        if (m1 < 0 || m1 > 100 || m2 < 0 || m2 > 100 || m3 < 0 || m3 > 100) {
            response.sendRedirect("exam.jsp");
            return;
        }

       
        int total = m1 + m2 + m3;
        double percentage = total / 3.0;

        String status;

        if (percentage >= 75) {
            status = "Distinction";
        } else if (percentage >= 60) {
            status = "First Class";
        } else if (percentage >= 40) {
            status = "Pass";
        } else {
            status = "Fail";
        }

       
        request.setAttribute("name", name);
        request.setAttribute("roll", roll);
        request.setAttribute("m1", m1);
        request.setAttribute("m2", m2);
        request.setAttribute("m3", m3);
        request.setAttribute("total", total);
        request.setAttribute("percentage", percentage);
        request.setAttribute("status", status);

       
        RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
        rd.forward(request, response);
    }

    public void destroy() {
        System.out.println("Servlet Destroyed");
    }
}