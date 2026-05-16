package com.shivam.monocept.studentcourse.controller.registration;

import java.io.IOException;

import com.shivam.monocept.studentcourse.dao.RegistrationDAO;
import com.shivam.monocept.studentcourse.model.Registration;
import com.shivam.monocept.studentcourse.validation.RegistrationValidation;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/registration/add")
public class AddRegistrationServlet extends HttpServlet {

    // OPEN FORM
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException {

        HttpSession session =
                request.getSession(false);

        // SESSION VALIDATION
        if(session == null ||
           session.getAttribute("loggedInUser") == null){

            response.sendRedirect("../login");
            return;
        }

        RequestDispatcher rd =
                request.getRequestDispatcher(
                "/WEB-INF/views/registration-form.jsp");

        rd.forward(request, response);
    }

    // ADD REGISTRATION
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException {

        int studentId =
                Integer.parseInt(
                request.getParameter("studentId"));

        int courseId =
                Integer.parseInt(
                request.getParameter("courseId"));

        String registrationDate =
                request.getParameter(
                "registrationDate");

        String status =
                request.getParameter(
                "status");

        // VALIDATION
        String error =
                RegistrationValidation
                .validateRegistration(
                studentId,
                courseId,
                registrationDate,
                status);

        // VALIDATION FAILED
        if(error != null){

            request.setAttribute(
                    "error",
                    error);

            RequestDispatcher rd =
                    request.getRequestDispatcher(
                    "/WEB-INF/views/registration-form.jsp");

            rd.forward(request, response);

            return;
        }

        // CREATE OBJECT
        Registration registration =
                new Registration(
                studentId,
                courseId,
                registrationDate,
                status);

        RegistrationDAO dao =
                new RegistrationDAO();

        boolean statusResult =
                dao.addRegistration(
                registration);

        // SUCCESS
        if(statusResult){

            response.sendRedirect(
                    "../registration/list");

        } else {

            request.setAttribute(
                    "error",
                    "Failed To Add Registration");

            RequestDispatcher rd =
                    request.getRequestDispatcher(
                    "/WEB-INF/views/registration-form.jsp");

            rd.forward(request, response);
        }
    }
}