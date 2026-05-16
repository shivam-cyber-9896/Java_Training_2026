package com.shivam.monocept.studentcourse.controller.registration;

import java.io.IOException;
import java.util.List;

import com.shivam.monocept.studentcourse.dao.RegistrationDAO;
import com.shivam.monocept.studentcourse.model.Registration;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/registration/list")
public class ViewRegistrationsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException {

        HttpSession session =
                request.getSession(false);

        if(session == null ||
           session.getAttribute("loggedInUser") == null){

            response.sendRedirect("../login");
            return;
        }

        RegistrationDAO dao =
                new RegistrationDAO();

        List<Registration> registrations =
                dao.getAllRegistrations();

        request.setAttribute(
                "registrations",
                registrations);

        RequestDispatcher rd =
                request.getRequestDispatcher(
                "/WEB-INF/views/registration-list.jsp");

        rd.forward(request, response);
    }
}