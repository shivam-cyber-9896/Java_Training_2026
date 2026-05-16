package com.shivam.monocept.studentcourse.controller;


import java.io.IOException;

import com.shivam.monocept.studentcourse.dao.AdminDAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login-action")
public class LoginServlet extends HttpServlet {

    
   
    // PROCESS LOGIN
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException {

        String username =
                request.getParameter("username");

        String password =
                request.getParameter("password");

        AdminDAO dao = new AdminDAO();

        boolean status =
                dao.validateAdmin(username, password);

        if(status) {

            HttpSession session =
                    request.getSession();

            session.setAttribute(
                    "loggedInUser",
                    username);

            response.sendRedirect("dashboard");

        } else {

            request.setAttribute(
                    "error",
                    "Invalid Username or Password");

            RequestDispatcher rd =
                    request.getRequestDispatcher(
                    "/WEB-INF/views/Login.jsp");

            rd.forward(request, response);
        }
    }
}