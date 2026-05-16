package com.shivam.monocept.studentcourse.controller.registration;

import java.io.IOException;

import com.shivam.monocept.studentcourse.dao.RegistrationDAO;
import com.shivam.monocept.studentcourse.model.Registration;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registration/delete")
public class DeleteRegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException {

        String idParam =
                request.getParameter("id");

        if(idParam == null){

            RequestDispatcher rd =
                    request.getRequestDispatcher(
                    "/WEB-INF/views/registration-delete.jsp");

            rd.forward(request, response);

            return;
        }

        int id =
                Integer.parseInt(idParam);

        RegistrationDAO dao =
                new RegistrationDAO();

        Registration registration =
                dao.getRegistrationById(id);

        request.setAttribute(
                "registration",
                registration);

        RequestDispatcher rd =
                request.getRequestDispatcher(
                "/WEB-INF/views/registration-delete.jsp");

        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException {

        int id =
                Integer.parseInt(
                request.getParameter("id"));

        RegistrationDAO dao =
                new RegistrationDAO();

        dao.deleteRegistration(id);

        response.sendRedirect("../registration/list");
    }
}