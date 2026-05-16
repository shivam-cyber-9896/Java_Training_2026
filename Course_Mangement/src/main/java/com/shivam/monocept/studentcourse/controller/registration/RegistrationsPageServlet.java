package com.shivam.monocept.studentcourse.controller.registration;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/registrations")
public class RegistrationsPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException {

        HttpSession session =
                request.getSession(false);

        // SESSION VALIDATION
        if(session == null ||
           session.getAttribute("loggedInUser") == null){

            response.sendRedirect("login");
            return;
        }

        RequestDispatcher rd =
                request.getRequestDispatcher(
                "/WEB-INF/views/registrations.jsp");

        rd.forward(request, response);
    }
}