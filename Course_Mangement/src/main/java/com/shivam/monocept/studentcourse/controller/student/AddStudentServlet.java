package com.shivam.monocept.studentcourse.controller.student;
import java.io.IOException;

import com.shivam.monocept.studentcourse.dao.StudentDAO;
import com.shivam.monocept.studentcourse.model.Student;
import com.shivam.monocept.studentcourse.validation.InputValidation;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/student/add")
public class AddStudentServlet extends HttpServlet {

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

        RequestDispatcher rd =
                request.getRequestDispatcher(
                "/WEB-INF/views/student-form.jsp");

        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException {

        String name =
                request.getParameter("studentName");
       
        String email =
                request.getParameter("email");

        String phone =
                request.getParameter("phone");

        int age =
                Integer.parseInt(
                request.getParameter("age"));

        String city =
                request.getParameter("city");

        String error = InputValidation.validateStudent(
                name,
                email,
                phone,
                age,
                city);

        if(error != null){

            request.setAttribute("error", error);

            RequestDispatcher rd =
                    request.getRequestDispatcher(
                    "/WEB-INF/views/student-form.jsp");

            rd.forward(request, response);

            return;
        }

        Student student =
                new Student(name,email,phone,age,city);

        StudentDAO dao = new StudentDAO();

        boolean status =
                dao.addStudent(student);

        if(status){

            response.sendRedirect("../students");

        } else {

            request.setAttribute(
                    "error",
                    "Failed To Add Student");

            RequestDispatcher rd =
                    request.getRequestDispatcher(
                    "/WEB-INF/views/student-form.jsp");

            rd.forward(request, response);
        }
    }
}